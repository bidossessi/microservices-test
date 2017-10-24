package ca.kovaro.shop.billing.domain.services.history

import ca.kovaro.shop.billing.domain.models.HistoryDTO

interface HistoryService {
    fun getHistory(id: Long): HistoryDTO
}