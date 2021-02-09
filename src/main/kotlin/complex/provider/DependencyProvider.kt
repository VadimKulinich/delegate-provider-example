package complex.provider

interface DependencyProvider<T> {

    fun provide(): T
}