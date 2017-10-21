package ca.kovaro.shop.billing.domain.services

import ca.kovaro.shop.billing.domain.models.HistoryDTO
import ca.kovaro.shop.billing.domain.models.Purchase
import ca.kovaro.shop.billing.domain.repositories.HashHistoryDAO
import ca.kovaro.shop.billing.domain.repositories.HistoryDAO

class SimpleHistoryService(private val dao: HistoryDAO = HashHistoryDAO(),
                           private val converter: Converter = Converter()): HistoryService {
    override fun get(id: Long): HistoryDTO? {
        val found: List<Purchase> = dao.get(id)
        if (found.count() > 0) {
            return converter.convertTo(id, found)
        }
        return null
    }
}