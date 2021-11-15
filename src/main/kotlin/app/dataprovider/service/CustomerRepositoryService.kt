package app.dataprovider.service

import app.dataprovider.repository.input.CustomerRepository
import app.dataprovider.toEntity
import app.domain.entity.Customer
import app.domain.usecases.findcustomerbyid.output.FindCustomerByIdRepositoryPort
import app.domain.usecases.savecustomer.output.SaveCustomerRepositoryPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerRepositoryService(@Autowired private val customerRepository: CustomerRepository) : FindCustomerByIdRepositoryPort, SaveCustomerRepositoryPort {
    override fun find(id: Long): Customer? {
        return customerRepository.findById(id)?.toEntity()
    }

    override fun save(customer: Customer): Customer {
        return customerRepository.save(customer)
    }
}