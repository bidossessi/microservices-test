package ca.kovaro.shop.billing.domain.services.history

import ca.kovaro.shop.billing.domain.models.HistoryDTO
import ca.kovaro.shop.billing.domain.models.Purchase
import ca.kovaro.shop.billing.domain.repositories.HashPurchaseDAO
import ca.kovaro.shop.billing.domain.repositories.PurchaseDAO
import ca.kovaro.shop.billing.domain.services.DTOConverter
import org.springframework.stereotype.Component

@Component
class SimpleHistoryService(private val dao: PurchaseDAO,
                           private val converter: DTOConverter): HistoryService {

    override fun getHistory(id: Long): HistoryDTO {
        val found: List<Purchase> = dao.getValidated(id)
        return converter.toHistory(id, found)
    }
}