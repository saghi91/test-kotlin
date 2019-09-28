package dbUtils.cassandra

import com.google.inject.Provider
import dbUtils.DataConnector

class CassandraConnectorProvider: Provider<DataConnector> {
    override fun get(): DataConnector {
        val username = "cassandra"
        val password = "cassandra"
        val keyspace = "testkeyspace"

        return CassandraConnector(username, password, keyspace)
    }

}
