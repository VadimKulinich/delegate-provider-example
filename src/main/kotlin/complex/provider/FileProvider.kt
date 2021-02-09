package complex.provider

class FileProvider : DependencyProvider<String> {
    override fun provide(): String = "path_to_some_file"
}