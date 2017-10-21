package ca.kovaro.shop.billing.domain.repositories

import ca.kovaro.shop.billing.domain.models.Purchase
import java.time.Instant
import java.util.*

class HashHistoryDAO: HistoryDAO {

    private var store = mutableListOf<Purchase>()

    init {
        for (i in 1..5 ) {
            val idx = i.toLong()
            store.add(Purchase(
                    user_id = idx,
                    product_id = 1,
                    name = "Cool product",
                    price = 17.3,
                    created_on = Date.from(Instant.now())))
            store.add(Purchase(
                    user_id = idx,
                    product_id = 2,
                    name = "Other thing",
                    price = 3.0,
                    created_on = Date.from(Instant.now())))
            store.add(Purchase(
                    user_id = idx,
                    product_id = 3,
                    name = "Expensive stuff",
                    price = 237.5,
                    created_on = Date.from(Instant.now())))
        }
    }

    override fun get(id: Long): List<Purchase> {
        return store.filter { it.user_id == id }
    }

}