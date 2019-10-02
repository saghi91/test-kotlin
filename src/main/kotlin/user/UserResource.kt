package user

import dbUtils.solr.SolrClient
import user.repositories.UserSolrRepository
import user.services.ServiceFactory
import utils.Responses.Response
import java.time.Instant
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("users")
class UserResource {
    private val userService = ServiceFactory().createUserService()

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun get(): List<String> {
        return userService.getAll()
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("solr-data")
    fun getSolrData(): String {
        val solrClient = SolrClient().connect()
        return UserSolrRepository(solrClient).create()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun create(request: User): Response {
        val user = User(UUID.randomUUID(), request.name, request.password, request.age, Instant.now())
        return userService.create(user)
    }
}
