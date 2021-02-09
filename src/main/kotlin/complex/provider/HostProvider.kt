package complex.provider

class HostProvider : DependencyProvider<String> {

    override fun provide(): String = "localhost"
}