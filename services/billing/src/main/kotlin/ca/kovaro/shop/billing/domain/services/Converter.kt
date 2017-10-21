package ca.kovaro.shop.billing.domain.services

import ca.kovaro.shop.billing.domain.models.HistoryDTO
import ca.kovaro.shop.billing.domain.models.Purchase
import ca.kovaro.shop.billing.domain.models.PurchaseDTO

class Converter {
    fun convertTo(id: Long, purchases: List<Purchase>): HistoryDTO {
        val p:List<PurchaseDTO> = purchases.map { PurchaseDTO( it.product_id, it.name, it.price, it.created_on) }
        return HistoryDTO(id, p)
    }
}