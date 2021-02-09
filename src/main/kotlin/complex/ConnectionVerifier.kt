package complex

class ConnectionVerifier {
    fun isValidByPassword(host: String, password: String): Boolean = host == password

    fun isValidByToken(host: String, token: String): Boolean = host.isNotEmpty() && token == "JWT"

    fun isValidByFile(path: String) = path.isNotEmpty()
}