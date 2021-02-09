package complex.connection

class PasswordConnection(
    private val host: String,
    private val password: String
) : Connection {

    override fun init() {
        // perform some setup
    }

    override fun connect() {
        // perform connect
    }
}