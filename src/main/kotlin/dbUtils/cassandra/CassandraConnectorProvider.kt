package dbUtils.cassandra

import com.google.inject.Provider
import dbUtils.DBConnector

class CassandraConnectorProvider: Provider<DBConnector> {
    override fun get(): DBConnector {
        val username = "cassandra"
        val password = "cassandra"
        val keyspace = "testkeyspace"

        return CassandraConnector(username, password, keyspace)
    }

}
