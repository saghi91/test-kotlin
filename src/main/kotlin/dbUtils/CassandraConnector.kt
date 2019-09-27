package dbUtils
import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import javax.inject.Singleton

@Singleton
class CassandraConnector: DBConnector {

    override fun connect(): CqlSession {
        val session: CqlSession = CqlSession.builder()
            .withAuthCredentials("cassandra", "cassandra")
            .withKeyspace(CqlIdentifier.fromCql("testkeyspace")).build()

        return session
    }
}
