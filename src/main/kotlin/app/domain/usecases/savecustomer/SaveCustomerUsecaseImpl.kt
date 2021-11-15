package app.domain.usecases.savecustomer

import app.domain.entity.Customer
import app.domain.usecases.savecustomer.input.SaveCustomerUsecase
import app.domain.usecases.savecustomer.output.SaveCustomerRepositoryPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SaveCustomerUsecaseImpl(@Autowired private val saveCustomerRepositoryPort: SaveCustomerRepositoryPort) :
    SaveCustomerUsecase {
    override fun save(customer: Customer): Customer {
        return saveCustomerRepositoryPort.save(customer)
    }
}