package repositories

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.querybuilder.QueryBuilder
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.selectFrom
import com.datastax.oss.driver.api.querybuilder.insert.RegularInsert
import user.User


class UserRepository(val session: CqlSession) {
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

    fun findAll() {
        println(selectFrom("users").all())
    }
}

