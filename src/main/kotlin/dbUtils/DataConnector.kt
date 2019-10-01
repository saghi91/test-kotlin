package dbUtils

interface DataConnector<out T> {
    fun connect(): T
}
