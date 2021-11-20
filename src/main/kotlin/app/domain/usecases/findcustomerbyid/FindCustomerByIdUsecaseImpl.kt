package app.domain.usecases.findcustomerbyid

import app.domain.entity.Customer
import app.domain.exception.NotFoundException
import app.domain.usecases.findcustomerbyid.input.FindCustomerByIdUsecase
import app.domain.usecases.findcustomerbyid.output.FindCustomerByIdRepositoryPort
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class FindCustomerByIdUsecaseImpl(@Inject val repository: FindCustomerByIdRepositoryPort) :
    FindCustomerByIdUsecase {
    override fun find(id: Long): Customer {
        return repository.find(id) ?: throw NotFoundException("Customer $id not found.")
    }
}