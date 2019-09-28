package dbUtils

import com.datastax.oss.driver.api.core.CqlSession
import com.google.inject.Guice
import dbUtils.cassandra.CassandraConnector
import dbUtils.cassandra.CassandraConnectorModule

class SessionFactory {
    companion object {
        private val session: CqlSession? = null

        @JvmStatic
        fun getSession(): CqlSession {
            if (session != null) {
                return session
            }
            val injector = Guice.createInjector(CassandraConnectorModule())
            val connector = injector.getInstance(DataConnector::class.java)

            return connector.connect()
        }
    }
}