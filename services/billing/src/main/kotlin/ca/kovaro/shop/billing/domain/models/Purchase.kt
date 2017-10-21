package ca.kovaro.shop.billing.domain.models

import java.util.*

data class Purchase(val user_id: Long,
                    val product_id: Long,
                    val name: String,
                    val price: Double,
                    val created_on: Date)

data class PurchaseDTO(val product_id: Long,
                       val name: String,
                       val price: Double,
                       val created_on: Date)

data class HistoryDTO(val id: Long, val purchases: List<PurchaseDTO>)