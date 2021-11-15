package app.domain.usecases.findcustomerbyid.output

import app.domain.entity.Customer

interface FindCustomerByIdRepositoryPort {
    fun find(id: Long): Customer?
}