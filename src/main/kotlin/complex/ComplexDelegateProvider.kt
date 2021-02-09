package complex

import complex.connection.FileConnection
import complex.provider.DependencyProvider
import complex.connection.PasswordConnection
import complex.connection.TokenConnection
import java.lang.IllegalStateException
import kotlin.properties.PropertyDelegateProvider
import kotlin.reflect.KProperty

class ComplexDelegateProvider(
    private val hostProvider: DependencyProvider<String>,
    private val passwordProvider: DependencyProvider<String>,
    private val tokenProvider: DependencyProvider<String>,
    private val filePathProvider: DependencyProvider<String>,
    private val connectionVerifier: ConnectionVerifier
) : PropertyDelegateProvider<Any?, ConnectionDelegate> {

    override fun provideDelegate(thisRef: Any?, property: KProperty<*>): ConnectionDelegate {
        val host = hostProvider.provide()
        val password = passwordProvider.provide()
        if(connectionVerifier.isValidByPassword(host, password)) {
            println("Provider by password")
            return ConnectionDelegate(PasswordConnection(host, password))
        }

        val token =  tokenProvider.provide()
        if(connectionVerifier.isValidByToken(host, token)) {
            println("Provider by token")
            return ConnectionDelegate(TokenConnection(host, token))
        }

        val filePath = filePathProvider.provide()
        if(connectionVerifier.isValidByFile(filePath)) {
            println("Provider by file")
            return ConnectionDelegate(FileConnection(filePath))
        }

        throw IllegalStateException("Invalid configuration provided")
    }
}