package dbUtils

import com.datastax.oss.driver.api.core.CqlSession
import dbUtils.cassandra.CassandraConnector

class SessionFactory {
    companion object {
        private val session: CqlSession? = null

        @JvmStatic
        fun getSession(): CqlSession {
            if (session != null) {
                return session
            }
//            val injector = Guice.createInjector(CassandraConnectorModule())
//            val connector = injector.getInstance(DataConnector::class.java)
            val connector = CassandraConnector("cassandra", "cassandra", "testkeyspace")

            return connector.connect()
        }
    }
}
