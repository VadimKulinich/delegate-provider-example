package complex

import complex.connection.Connection
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ConnectionDelegate(
    private val connection: Connection
) : ReadOnlyProperty<Any?, Connection> {

    init {
        connection.init()
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): Connection = connection
}