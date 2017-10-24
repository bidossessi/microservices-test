package ca.kovaro.shop.warehouse.domain.services.picking

import ca.kovaro.shop.warehouse.domain.models.InPickingDTO
import ca.kovaro.shop.warehouse.domain.models.Picking

interface PickingService {
    fun create(dto: InPickingDTO)
    fun all(): List<Picking>
}