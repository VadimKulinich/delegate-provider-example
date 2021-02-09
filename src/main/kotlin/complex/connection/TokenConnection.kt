package complex.connection

class TokenConnection(
    private val host: String,
    private val token: String
): Connection {

    override fun init() {
        // perform init
    }

    override fun connect() {
        // perform connect
    }
}