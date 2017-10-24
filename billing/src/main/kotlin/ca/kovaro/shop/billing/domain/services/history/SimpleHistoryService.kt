package ca.kovaro.shop.billing.domain.services.history

import ca.kovaro.shop.billing.domain.models.HistoryDTO
import ca.kovaro.shop.billing.domain.models.Purchase
import ca.kovaro.shop.billing.domain.repositories.HashPurchaseDAO
import ca.kovaro.shop.billing.domain.repositories.PurchaseDAO
import ca.kovaro.shop.billing.domain.services.DTOConverter

class SimpleHistoryService(private val dao: PurchaseDAO = HashPurchaseDAO(),
                           private val converter: DTOConverter = DTOConverter()): HistoryService {
    override fun get(id: Long): HistoryDTO? {
        val found: List<Purchase> = dao.getValidated(id)
        if (found.count() > 0) {
            return converter.toHistory(id, found)
        }
        return null
    }
}