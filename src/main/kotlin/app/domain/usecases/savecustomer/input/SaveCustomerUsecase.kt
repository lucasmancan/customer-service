package app.domain.usecases.savecustomer.input

import app.domain.entity.Customer

interface SaveCustomerUsecase {
    fun save(customer: Customer): Customer
}