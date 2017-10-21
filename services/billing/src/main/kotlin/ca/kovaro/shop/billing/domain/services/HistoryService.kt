package ca.kovaro.shop.billing.domain.services

import ca.kovaro.shop.billing.domain.models.HistoryDTO

interface HistoryService {
    fun get(id: Long): HistoryDTO?
}