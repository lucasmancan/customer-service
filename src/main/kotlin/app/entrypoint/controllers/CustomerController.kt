package app.entrypoint.controllers

import app.domain.exception.NotFoundException
import app.domain.usecases.findcustomerbyid.input.FindCustomerByIdUsecase
import app.domain.usecases.savecustomer.input.SaveCustomerUsecase
import app.entrypoint.dto.CustomerDTO
import app.entrypoint.utils.toDTO
import app.entrypoint.utils.toEntity
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/customers")
class CustomerController(
    private val findCustomerByIdUsecase: FindCustomerByIdUsecase,
    private val saveCustomerUsecase: SaveCustomerUsecase
) {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun findById(@PathParam("id") id: Long): Response {
        return try {
            Response.ok(findCustomerByIdUsecase.find(id).toDTO()).build()
        } catch (ex: NotFoundException) {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    fun save(dto: CustomerDTO): CustomerDTO {
        return saveCustomerUsecase.save(dto.toEntity()).toDTO()
    }
}