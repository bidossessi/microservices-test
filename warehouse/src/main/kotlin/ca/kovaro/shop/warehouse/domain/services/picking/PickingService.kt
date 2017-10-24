package ca.kovaro.shop.warehouse.domain.services.picking

import ca.kovaro.shop.warehouse.domain.models.InPickingDTO

interface PickingService {
    fun create(dto: InPickingDTO)
}