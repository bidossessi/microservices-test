package ca.kovaro.shop.warehouse.domain.repositories


interface InventoryDAO {
    fun hasEnough(id: Long, qty: Long): Boolean
}