package dbUtils.cassandra

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import dbUtils.DataConnector

class CassandraConnectorModule : AbstractModule() {
    override fun configure() {
        bind(DataConnector::class.java).toProvider(CassandraConnectorProvider::class.java)
    }
}
