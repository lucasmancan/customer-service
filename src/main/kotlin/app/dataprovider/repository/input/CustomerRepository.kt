package app.dataprovider.repository.input

import app.dataprovider.entity.CustomerJpaEntity
import app.domain.entity.Customer

interface CustomerRepository {
    fun findById(id: Long): CustomerJpaEntity?
    fun save(customer: Customer): Customer
}