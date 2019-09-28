package user

import utils.HttpStatus
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.querybuilder.QueryBuilder
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal
import com.datastax.oss.driver.api.querybuilder.insert.RegularInsert
import com.google.inject.Inject
import utils.Responses.HttpResponse
import utils.Responses.Response
import java.util.stream.Collectors


class UserRepository @Inject constructor(private val session: CqlSession) {
    fun save(user: User): Response {
        try {
            session
            val query: RegularInsert = QueryBuilder.insertInto("testkeyspace", "users")
                .value("user_id", literal((user.user_id)))
                .value("name", literal(user.name))
                .value("password", literal(user.password))
                .value("age", literal(user.age))
                .value("creation_date", literal(user.creation_date))
            val statement = query.build()
            session.execute(statement)

            session.close()

            return HttpResponse.create(HttpStatus.Ok, "User created successfully!")
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception(e.message)
        }

    }

    fun findAll(): List<String> {
        try {
            val query = QueryBuilder.selectFrom("testkeyspace", "users").all()
            val statement = query.build()
            val result: ResultSet = session.execute(statement)
            session.close()

            val rows = result.all().stream().collect(Collectors.toList())
            val users: MutableList<String> = arrayListOf()

            for (row in rows) {
                users.add(row.formattedContents)
            }
            return users

        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception(e.message)
        }
    }

    fun execute() {

    }
}

