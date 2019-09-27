package dbUtils

import com.datastax.oss.driver.api.core.CqlSession

interface DBConnector {
    fun connect(): CqlSession
}
