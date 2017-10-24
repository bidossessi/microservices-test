package ca.kovaro.shop.billing.domain.services.purchase

import ca.kovaro.shop.billing.domain.models.InPurchaseDTO
import ca.kovaro.shop.billing.domain.models.PurchaseDTO
import java.util.*

interface PurchaseService {
    fun create(id: Long, dto: InPurchaseDTO)
    fun all(id: Long): List<PurchaseDTO>
    fun pending(id: Long): List<PurchaseDTO>
    fun validated(id: Long): List<PurchaseDTO>

    fun confirm(id: UUID): Boolean
}