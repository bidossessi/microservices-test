package ca.kovaro.shop.customers.domain.services

import ca.kovaro.shop.customers.domain.models.ProfileDTO
import ca.kovaro.shop.customers.domain.repositories.HashProfileDAO
import ca.kovaro.shop.customers.domain.repositories.ProfileDAO
import org.springframework.stereotype.Component

@Component
class SimpleProfileService(
        private val dao: ProfileDAO = HashProfileDAO(),
        private val converter: DTOConverter = DTOConverter()
): ProfileService {

    override fun list() = converter.convertTo(dao.all())

    override fun create(dto: ProfileDTO) {
        // Some validation...
        val p = converter.convertFrom(dto)
        dao.save(p)
    }

    override fun one(id: Long): ProfileDTO? {
        val r = dao.get(id)
        return if (r != null) converter.convertTo(profile = r) else null
    }
}