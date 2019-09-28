package user

import UserServiceInterface
import com.google.inject.Inject
import dbUtils.cassandra.CassandraConnector
import utils.Responses.Response
import java.time.Instant
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("users")
class UserResource @Inject constructor(private val userService: UserServiceInterface) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun get(): List<String> {
        return userService.getAll()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun create(request: User): Response {
        val user = User(UUID.randomUUID(), request.name, request.password, request.age, Instant.now())
        return userService.create(user)
    }
}
