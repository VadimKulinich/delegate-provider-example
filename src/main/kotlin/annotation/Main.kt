package annotation

import kotlin.properties.PropertyDelegateProvider

class Main(provider: PropertyDelegateProvider<Any?, Delegate>) {
    @CustomAnnotation("Some string")
    val delegated: String by provider
}

fun main() {
    val main = Main(AnnotationDelegateProvider())
    println(main.delegated)
}