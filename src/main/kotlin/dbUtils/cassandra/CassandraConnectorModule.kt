package dbUtils.cassandra

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import dbUtils.DBConnector

@Singleton
class CassandraConnectorModule : AbstractModule() {
    override fun configure() {
        bind(DBConnector::class.java).toProvider(CassandraConnectorProvider::class.java)
    }
}
