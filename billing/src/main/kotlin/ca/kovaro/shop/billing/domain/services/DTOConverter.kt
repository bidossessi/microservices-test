package ca.kovaro.shop.billing.domain.services

import ca.kovaro.shop.billing.domain.models.HistoryDTO
import ca.kovaro.shop.billing.domain.models.InPurchaseDTO
import ca.kovaro.shop.billing.domain.models.Purchase
import ca.kovaro.shop.billing.domain.models.PurchaseDTO
import org.springframework.stereotype.Component


@Component
class DTOConverter {
    fun toHistory(id: Long, purchases: List<Purchase>): HistoryDTO {
        val p:List<PurchaseDTO> = purchases.map {
            PurchaseDTO(
                    id = it.id,
                    product_id = it.product_id,
                    name = it.name,
                    price = it.price,
                    qty = it.qty,
                    updated_on = it.updated_on) }
        return HistoryDTO(id, p)
    }

    fun toList(purchases: List<Purchase>): List<PurchaseDTO> {
        return purchases.map { PurchaseDTO( it.id, it.product_id, it.name, it.price, it.qty, it.updated_on) }
    }

    fun toPurchase(id: Long, dto: InPurchaseDTO): Purchase {
        return Purchase(
                customer_id = id,
                product_id = dto.product_id,
                name = dto.name,
                qty = dto.qty,
                price = dto.price)
    }
}