package app.domain.usecases.savecustomer

import app.domain.entity.Customer
import app.domain.usecases.savecustomer.input.SaveCustomerUsecase
import app.domain.usecases.savecustomer.output.SaveCustomerRepositoryPort
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class SaveCustomerUsecaseImpl(@Inject  val saveCustomerRepositoryPort: SaveCustomerRepositoryPort) :
    SaveCustomerUsecase {
    override fun save(customer: Customer): Customer {
        return saveCustomerRepositoryPort.save(customer)
    }
}