package ca.kovaro.shop.warehouse.domain.services

import ca.kovaro.shop.warehouse.domain.models.InPickingDTO
import ca.kovaro.shop.warehouse.domain.models.Picking
import org.springframework.stereotype.Component

@Component
class DTOConverter {
    fun toPicking(dto: InPickingDTO): Picking {
        return Picking(
                customer_id = dto.customer_id,
                product_id = dto.product_id,
                move_qty = dto.qty)
    }
}