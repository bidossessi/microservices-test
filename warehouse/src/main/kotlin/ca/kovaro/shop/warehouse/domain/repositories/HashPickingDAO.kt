package ca.kovaro.shop.warehouse.domain.repositories

import ca.kovaro.shop.warehouse.domain.models.Picking
import org.springframework.stereotype.Component

@Component
object HashPickingDAO: PickingDAO {


    private var store = mutableListOf<Picking>()

    override fun save(picking: Picking) {
        store.add(picking)
    }

    override fun all(): List<Picking> {
        return store
    }
}