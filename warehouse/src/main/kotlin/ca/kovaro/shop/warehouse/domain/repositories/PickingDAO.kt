package ca.kovaro.shop.warehouse.domain.repositories

import ca.kovaro.shop.warehouse.domain.models.Picking

interface PickingDAO {
    fun save(picking: Picking)
}