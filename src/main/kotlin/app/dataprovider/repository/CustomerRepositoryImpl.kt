package app.dataprovider.repository

import app.dataprovider.entity.CustomerJpaEntity
import app.dataprovider.repository.input.CustomerRepository
import app.dataprovider.toEntity
import app.dataprovider.toJpaEntity
import app.domain.entity.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class CustomerRepositoryImpl(@Autowired private val entityManager: EntityManager) : CustomerRepository {
    override fun findById(id: Long): CustomerJpaEntity? {
        return entityManager.find(CustomerJpaEntity::class.java, id)
    }

    override fun save(customer: Customer): Customer {
        return entityManager.merge(customer.toJpaEntity()).toEntity()
    }
}