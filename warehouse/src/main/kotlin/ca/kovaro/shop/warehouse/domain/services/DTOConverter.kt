package ca.kovaro.shop.warehouse.domain.services

import ca.kovaro.shop.warehouse.domain.models.InPickingDTO
import ca.kovaro.shop.warehouse.domain.models.Picking
import ca.kovaro.shop.warehouse.domain.models.PickingDTO
import org.springframework.stereotype.Component

@Component
object DTOConverter {
    fun toPicking(dto: InPickingDTO): Picking {
        return Picking(
                customer_id = dto.customer_id,
                product_id = dto.product_id,
                move_qty = dto.qty)
    }

    fun toList(purchases: List<Picking>): List<PickingDTO> {
        return purchases.map { PickingDTO( it.id, it.product_id, it.customer_id, it.move_qty) }
    }
}