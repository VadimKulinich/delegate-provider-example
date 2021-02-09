package complex.provider

class TokenProvider : DependencyProvider<String> {
    override fun provide(): String = "JWT"
}