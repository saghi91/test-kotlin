package user

import com.google.inject.Inject
import java.time.Instant
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("users")
class UserResouce @Inject constructor(val service: UserService) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun get(): List<String> {
       return service.getAll()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun create() {
        val user = User(UUID.randomUUID(), "TestUserName", "123456", 32, Instant.now())
        service.create(user)
    }
}
