package ca.kovaro.shop.billing.domain.repositories

import ca.kovaro.shop.billing.domain.models.Purchase
import java.util.*

interface PurchaseDAO {
    fun get(id: UUID): Purchase?
    fun getForCustomer(customer_id: Long, id: UUID): Purchase?
    fun getAll(id: Long): List<Purchase>
    fun getValidated(id: Long): List<Purchase>
    fun getPending(id: Long): List<Purchase>
    fun save(purchase: Purchase)
}