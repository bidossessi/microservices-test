package ca.kovaro.shop.warehouse.domain.models

import java.time.Instant
import java.util.*

// We're assuming that only one product can be ordered at once.
// In a real setting, we'd be using PickingLines for each product
// and group all products into a single picking.

enum class PickingStatus {
    Draft,
    Provisionned,
    Validated,
    Shipped
}

data class Picking(val id: UUID = UUID.randomUUID(),
                   val customer_id: Long,
                   val product_id: Long,
                   val move_qty: Long,
                   var status: PickingStatus = PickingStatus.Draft,
                   val created_on: Date = Date.from(Instant.now()),
                   var updated_on: Date = Date.from(Instant.now()))

data class InPickingDTO(val id: UUID = UUID.randomUUID(),
                        val customer_id: Long = 0,
                        val product_id: Long = 0,
                        val qty: Long = 0)

data class PickingDTO(val id: UUID, val customer_id: Long, val product_id: Long, val move_qty: Long)