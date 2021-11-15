package app

import app.domain.exception.NotFoundException
import app.domain.usecases.findcustomerbyid.input.FindCustomerByIdUsecase
import app.domain.usecases.savecustomer.input.SaveCustomerUsecase
import app.entrypoint.dto.AppError
import app.entrypoint.dto.CustomerDTO
import app.entrypoint.utils.toEntity
import io.jooby.Kooby
import io.jooby.di.SpringModule
import io.jooby.hibernate.HibernateModule
import io.jooby.hikari.HikariModule
import io.jooby.json.JacksonModule
import io.jooby.require
import io.jooby.runApp


class App() : Kooby({

    install(HikariModule())
    install(HibernateModule().scan("app"))
    install(SpringModule("app"))
    install(JacksonModule())

    get("/") {
        "Welcome to Jooby!"
    }

    path("customers") {

        get("/{id}") {
            val findByIdUseCase = require(FindCustomerByIdUsecase::class)

            try {
                val id = ctx.path("id").longValue()

                findByIdUseCase.find(id)
            } catch (ex: NotFoundException) {
                ctx.setResponseCode(404)
                AppError(ex.message)
            }
        }

        post("/") {
            val saveCustomerUseCase = require(SaveCustomerUsecase::class)

            val customerDto = ctx.body().to(CustomerDTO::class.java)

            saveCustomerUseCase.save(customerDto.toEntity())
        }
    }
})

fun main(args: Array<String>) {
    runApp(args, App::class)
}
