package complex.provider

class PasswordProvider : DependencyProvider<String> {

    override fun provide(): String = "localhost"
}