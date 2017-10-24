package ca.kovaro.shop.billing.domain.services.purchase

import ca.kovaro.shop.billing.api.v1.ampq.AMQPSender
import ca.kovaro.shop.billing.domain.models.*
import ca.kovaro.shop.billing.domain.repositories.HashPurchaseDAO
import ca.kovaro.shop.billing.domain.repositories.PurchaseDAO
import ca.kovaro.shop.billing.domain.services.DTOConverter
import org.springframework.stereotype.Component
import java.util.*


@Component
class SimplePurchaseService(private val dao: PurchaseDAO,
                            val converter: DTOConverter = DTOConverter(),
                            val publisher: AMQPSender) : PurchaseService {

    override fun all(id: Long): List<PurchaseDTO> {
        val found: List<Purchase> = dao.getAll(id)
        return converter.toList(found)
    }

    override fun pending(id: Long): List<PurchaseDTO> {
        val found: List<Purchase> = dao.getPending(id)
        return converter.toList(found)
    }
    override fun validated(id: Long): List<PurchaseDTO> {
        val found: List<Purchase> = dao.getValidated(id)
        return converter.toList(found)
    }

    override fun confirm(id: UUID): Boolean {
        val p = dao.get(id)
        if (p != null) {
            p.status = PurchaseStatus.Validated
            publisher.purchaseValidated(p)
            return true
        }
        return false
    }


    override fun create(id: Long, dto: InPurchaseDTO) {
        val p = converter.toPurchase(id, dto)
        dao.save(p)
        publisher.newPurchase(p)
    }

}