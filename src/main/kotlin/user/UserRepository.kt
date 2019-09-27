package user

import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.querybuilder.QueryBuilder
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal
import com.datastax.oss.driver.api.querybuilder.insert.RegularInsert
import com.google.inject.Inject
import dbUtils.DBConnector
import java.util.stream.Collectors


class UserRepository @Inject constructor(val dbConnector: DBConnector) {

    val session = dbConnector.connect()

    fun save(user: User) {
        try {
            val query: RegularInsert = QueryBuilder.insertInto("testkeyspace", "users")
                .value("user_id", literal((user.user_id)))
                .value("name", literal(user.name))
                .value("password", literal(user.password))
                .value("age", literal(user.age))
                .value("creation_date", literal(user.creation_date))
            val statement = query.build()
            session.execute(statement)

            session.close()
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
}

