package app.dataprovider.service

import app.dataprovider.repository.input.CustomerRepository
import app.dataprovider.toEntity
import app.domain.entity.Customer
import app.domain.usecases.findcustomerbyid.output.FindCustomerByIdRepositoryPort
import app.domain.usecases.savecustomer.output.SaveCustomerRepositoryPort
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class CustomerRepositoryService(@Inject  val customerRepository: CustomerRepository) : FindCustomerByIdRepositoryPort, SaveCustomerRepositoryPort {
    override fun find(id: Long): Customer? {
        return customerRepository.findById(id)?.toEntity()
    }

    override fun save(customer: Customer): Customer {
        return customerRepository.save(customer)
    }
}