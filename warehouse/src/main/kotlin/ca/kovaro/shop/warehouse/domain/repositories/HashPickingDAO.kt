package ca.kovaro.shop.warehouse.domain.repositories

import ca.kovaro.shop.warehouse.domain.models.Picking

class HashPickingDAO: PickingDAO {


    private var store = mutableListOf<Picking>()

    override fun save(picking: Picking) {
        store.add(picking)
    }
}