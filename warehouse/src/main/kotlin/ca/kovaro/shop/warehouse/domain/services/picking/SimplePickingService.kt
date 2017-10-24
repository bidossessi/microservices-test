package ca.kovaro.shop.warehouse.domain.services.picking

import ca.kovaro.shop.warehouse.api.v1.amqp.AMQPSender
import ca.kovaro.shop.warehouse.domain.models.InPickingDTO
import ca.kovaro.shop.warehouse.domain.models.Picking
import ca.kovaro.shop.warehouse.domain.models.PickingStatus
import ca.kovaro.shop.warehouse.domain.repositories.InventoryDAO
import ca.kovaro.shop.warehouse.domain.repositories.PickingDAO
import ca.kovaro.shop.warehouse.domain.services.DTOConverter
import org.springframework.stereotype.Component

@Component
class SimplePickingService(val inventoryDAO: InventoryDAO,
                           val dao: PickingDAO,
                           val converter: DTOConverter,
                           val publisher: AMQPSender): PickingService {
    override fun create(dto: InPickingDTO) {
        val p = converter.toPicking(dto)
        if (inventoryDAO.hasEnough(dto.product_id, dto.qty)) {
            p.status = PickingStatus.Provisionned
        }
        dao.save(p)
        publisher.pickingCreated(p)
    }

    override fun all(): List<Picking> {
        return dao.all()
    }
}