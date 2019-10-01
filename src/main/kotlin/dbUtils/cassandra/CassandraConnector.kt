package dbUtils.cassandra
import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import dbUtils.DataConnector
import javax.inject.Singleton

@Singleton
class CassandraConnector(private val username: String, private val password: String, private val keyspace: String):
    DataConnector<CqlSession> {

    override fun connect(): CqlSession {
        return CqlSession.builder()
            .withAuthCredentials(username, password)
            .withKeyspace(CqlIdentifier.fromCql(keyspace)).build()
    }
}
