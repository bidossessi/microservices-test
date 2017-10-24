package ca.kovaro.shop.warehouse.domain.repositories

import ca.kovaro.shop.warehouse.domain.models.Picking
import java.util.*

interface PickingDAO {
    fun getForId(id: UUID): Picking?
    fun save(picking: Picking)
    fun all(): List<Picking>
}