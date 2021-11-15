package app.domain.usecases.findcustomerbyid.input

import app.domain.entity.Customer

interface FindCustomerByIdUsecase {
    fun find(id: Long) : Customer
}