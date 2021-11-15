package app.entrypoint.utils

import app.domain.entity.Customer
import app.entrypoint.dto.CustomerDTO

fun CustomerDTO.toEntity(): Customer {
    return Customer(id, name)
}

fun Customer.toDTO(): CustomerDTO {
    return CustomerDTO(id, name)
}
