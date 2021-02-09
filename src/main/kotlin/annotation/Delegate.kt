package annotation

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class Delegate(private val config: String) : ReadOnlyProperty<Any?, String> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): String = config
}