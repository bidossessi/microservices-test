package ca.kovaro.shop.billing.domain.models

import java.time.Instant
import java.util.*


enum class PurchaseStatus {
    Draft,
    Validated
}

data class Purchase(val id: UUID = UUID.randomUUID(),
                    val customer_id: Long,
                    val product_id: Long,
                    val name: String,
                    val price: Double,
                    val qty: Long = 1,
                    var status: PurchaseStatus = PurchaseStatus.Draft,
                    val created_on: Date = Date.from(Instant.now()),
                    var updated_on: Date = Date.from(Instant.now()))

data class InPurchaseDTO(val product_id: Long, val name: String, val price: Double, val qty: Long)

data class PurchaseDTO(val id: UUID,
                       val product_id: Long,
                       val name: String,
                       val price: Double,
                       val qty: Long,
                       val updated_on: Date)

data class HistoryDTO(val id: Long, val purchases: List<PurchaseDTO>)