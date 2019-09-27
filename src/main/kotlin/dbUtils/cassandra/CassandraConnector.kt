package dbUtils.cassandra
import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import dbUtils.DBConnector
import javax.inject.Singleton

@Singleton
class CassandraConnector(val username: String, val password: String, val keyspace: String): DBConnector {

    override fun connect(): CqlSession {
        val session: CqlSession = CqlSession.builder()
            .withAuthCredentials(username, password)
            .withKeyspace(CqlIdentifier.fromCql(keyspace)).build()

        return session
    }
}
