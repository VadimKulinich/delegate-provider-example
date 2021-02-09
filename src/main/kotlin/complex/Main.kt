package complex

import complex.connection.Connection
import complex.provider.FileProvider
import complex.provider.HostProvider
import complex.provider.PasswordProvider
import complex.provider.TokenProvider
import kotlin.properties.PropertyDelegateProvider

class Main(delegateProvider: PropertyDelegateProvider<Any?, ConnectionDelegate>) {
    
    val connection: Connection by delegateProvider
}

fun main() {
    val delegateProvider = ComplexDelegateProvider(
        HostProvider(), PasswordProvider(),TokenProvider(),
        FileProvider(), ConnectionVerifier()
    )
    val m = Main(delegateProvider)
    println(m.connection)
}