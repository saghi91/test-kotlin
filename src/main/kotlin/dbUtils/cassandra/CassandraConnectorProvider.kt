package dbUtils.cassandra

import com.datastax.oss.driver.api.core.CqlSession
import com.google.inject.Provider
import dbUtils.DataConnector

class CassandraConnectorProvider: Provider<DataConnector<CqlSession>> {
    override fun get(): DataConnector<CqlSession> {
        val username = "cassandra"
        val password = "cassandra"
        val keyspace = "testkeyspace"

        return CassandraConnector(username, password, keyspace)
    }

}
