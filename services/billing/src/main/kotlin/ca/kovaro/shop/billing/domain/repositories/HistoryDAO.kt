package ca.kovaro.shop.billing.domain.repositories

import ca.kovaro.shop.billing.domain.models.Purchase

interface HistoryDAO {
    fun get(id: Long): List<Purchase>
}