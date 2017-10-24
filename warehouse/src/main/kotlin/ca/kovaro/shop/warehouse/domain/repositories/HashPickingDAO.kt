package ca.kovaro.shop.warehouse.domain.repositories

import ca.kovaro.shop.warehouse.domain.models.Picking
import org.springframework.stereotype.Component
import java.util.*

@Component
object HashPickingDAO: PickingDAO {


    private var store = mutableListOf<Picking>()

    override fun getForId(id: UUID): Picking? {
        return store.find { it.id == id}
    }

    override fun save(picking: Picking) {
        if (getForId(picking.id) != null) return
        store.add(picking)
    }

    override fun all(): List<Picking> {
        return store
    }
}