package ca.kovaro.shop.warehouse.domain.repositories

import ca.kovaro.shop.warehouse.domain.models.Inventory

class HashInventoryDAO : InventoryDAO {


    private var store = listOf<Inventory>()

    init {
        val idxs = 1..5
        val invs = idxs.map { Inventory(it.toLong(), it*3.toLong()) }
        this.store = invs
    }

    override fun hasEnough(id: Long, qty: Long): Boolean {
        val inv = this.store.find { it.product_id == id }
        return if (inv?.quantity != null) inv.quantity >= qty else false
    }

}