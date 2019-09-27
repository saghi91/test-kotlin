package user

import com.google.inject.Guice
import dbUtils.DBConnector
import dbUtils.cassandra.CassandraConnector
import dbUtils.cassandra.CassandraConnectorModule
import java.time.Instant
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("users")
class UserResouce {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun get(): List<String> {
        val service = UserService(UserRepository(dbConnector = CassandraConnector("cassandra", "cassandra", "testkeyspace")))
        return service.getAll()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun create() {
        val user = User(UUID.randomUUID(), "TestUserName", "123456", 32, Instant.now())
        val service = UserService(UserRepository(dbConnector = CassandraConnector("cassandra", "cassandra", "testkeyspace")))
        service.create(user)
    }

    private fun createDBInstance() {
        val injector = Guice.createInjector(CassandraConnectorModule())
        val editor = injector.getInstance(DBConnector::class.java)
        editor.connect()
    }
}
