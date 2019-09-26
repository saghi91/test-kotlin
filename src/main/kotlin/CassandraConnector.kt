
import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession

class CassandraConnector {

    fun connect(): CqlSession {
        val session: CqlSession = CqlSession.builder()
            .withAuthCredentials("cassandra", "cassandra")
            .withKeyspace(CqlIdentifier.fromCql("testkeyspace")).build()

        return session
    }
}
