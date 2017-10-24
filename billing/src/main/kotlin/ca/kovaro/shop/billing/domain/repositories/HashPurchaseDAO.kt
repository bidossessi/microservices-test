package ca.kovaro.shop.billing.domain.repositories

import ca.kovaro.shop.billing.domain.models.Purchase
import ca.kovaro.shop.billing.domain.models.PurchaseStatus
import java.time.Instant
import java.util.*

class HashPurchaseDAO : PurchaseDAO {
    private var store = mutableListOf<Purchase>()

    init {
        for (i in 1..5 ) {
            val idx = i.toLong()
            store.add(Purchase(
                    customer_id = idx,
                    product_id = 1,
                    name = "Cool product",
                    price = 17.3,
                    created_on = Date.from(Instant.now())))
            store.add(Purchase(
                    customer_id = idx,
                    product_id = 2,
                    name = "Other thing",
                    price = 3.0,
                    created_on = Date.from(Instant.now())))
            store.add(Purchase(
                    customer_id = idx,
                    product_id = 3,
                    name = "Expensive stuff",
                    price = 237.5,
                    created_on = Date.from(Instant.now())))
        }
    }

    override fun get(id: UUID): Purchase? {
        return store.find { it.id == id }
    }

    override fun getAll(id: Long): List<Purchase> {
        return store.filter { it.customer_id == id }
    }

    override fun getValidated(id: Long): List<Purchase> {
        return store.filter { it.customer_id == id && it.status == PurchaseStatus.Validated }
    }

    override fun getPending(id: Long): List<Purchase> {
        return store.filter { it.customer_id == id && it.status == PurchaseStatus.Draft }
    }

    override fun save(purchase: Purchase) {
        store.add(purchase)
    }

}