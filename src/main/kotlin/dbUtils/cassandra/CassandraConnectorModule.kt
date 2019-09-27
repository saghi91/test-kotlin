package dbUtils.cassandra

import com.google.inject.AbstractModule
import dbUtils.DBConnector

class CassandraConnectorModule : AbstractModule() {
    override fun configure() {
        bind(DBConnector::class.java).toProvider(CassandraConnectorProvider::class.java)
    }
}
