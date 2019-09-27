package user

import CassandraConnector
import repositories.UserRepository
import java.time.Instant
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import kotlin.collections.HashMap

@Path("users")
class UserResouce {
    private val users = HashMap<String, User>()

    init {
        users += Pair("Saghi", User(UUID.randomUUID(), "SaghiTest", "098765", 26, Instant.now()))
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun get(): String {
        val dbUtils = CassandraConnector()
        val session = dbUtils.connect()

       return UserRepository(session).findAll()
    }

//    @Produces(MediaType.APPLICATION_JSON)
//    @GET @Path("{username}")
//    fun get(@PathParam("username") username: String): User? {
//        return users[username]
//    }
//
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun create() {
        val dbUtils = CassandraConnector()
        val session = dbUtils.connect()
        val user = User(UUID.randomUUID(), "TestUserName", "123456", 32, Instant.now())
        UserRepository(session).save(user)
    }
//
//    @PUT @Path("{username}")
//    fun update(@PathParam("username") username: String, user: User) {
//        users -= username
////        users += user.username to user
//    }
//
//    @DELETE @Path("{username}")
//    fun delete(@PathParam("username") username: String): User? {
//        return users.remove(username)
//    }
}
