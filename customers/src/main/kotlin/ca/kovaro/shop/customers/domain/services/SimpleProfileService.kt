package ca.kovaro.shop.customers.domain.services

import ca.kovaro.shop.customers.domain.models.ProfileDTO
import ca.kovaro.shop.customers.domain.repositories.MemoryProfileDao
import ca.kovaro.shop.customers.domain.repositories.ProfileDAO

class SimpleProfileService(
        private val dao: ProfileDAO = MemoryProfileDao(),
        private val converter: Converter = Converter()
): ProfileService {

//    @Inject private lateinit var dao: MemoryProfileDao
//    @Inject private lateinit var converter: Converter

    init {
        println("Starting ProfileService...")
    }
    override fun list() = converter.convertTo(dao.all())

    override fun create(dto: ProfileDTO): Boolean {
        // Some validation...
        val p = converter.convertFrom(dto)
        return dao.create(p)
    }

    override fun one(id: Long): ProfileDTO? {
        val r = dao.get(id)
        return if (r != null) converter.convertTo(profile = r) else null
    }
}