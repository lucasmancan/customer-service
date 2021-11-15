package app.dataprovider

import app.dataprovider.entity.CustomerJpaEntity
import app.domain.entity.Customer

fun CustomerJpaEntity.toEntity(): Customer {
    return Customer(id!!, name!!)
}

fun Customer.toJpaEntity(): CustomerJpaEntity {
    return CustomerJpaEntity(id, name)
}