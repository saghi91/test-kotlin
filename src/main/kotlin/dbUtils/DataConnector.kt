package dbUtils

import com.datastax.oss.driver.api.core.CqlSession

interface DataConnector {
    fun connect(): CqlSession
}
