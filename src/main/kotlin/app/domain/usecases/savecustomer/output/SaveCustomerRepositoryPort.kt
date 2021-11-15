package app.domain.usecases.savecustomer.output

import app.domain.entity.Customer

interface SaveCustomerRepositoryPort {
    fun save(customer: Customer): Customer
}