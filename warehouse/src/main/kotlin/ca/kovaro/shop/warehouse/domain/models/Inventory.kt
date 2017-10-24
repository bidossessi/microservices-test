package ca.kovaro.shop.warehouse.domain.models

data class Inventory(val product_id: Long,
                     val quantity: Long = 0)