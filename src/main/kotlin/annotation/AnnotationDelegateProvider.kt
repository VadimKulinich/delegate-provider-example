package annotation

import java.lang.IllegalStateException
import kotlin.properties.PropertyDelegateProvider
import kotlin.reflect.KProperty

class AnnotationDelegateProvider : PropertyDelegateProvider<Any?, Delegate> {
    override fun provideDelegate(thisRef: Any?, property: KProperty<*>): Delegate {
        val annotation = property.annotations.find { it is CustomAnnotation } as? CustomAnnotation
            ?: throw IllegalStateException("Cannot delegate to property without annotation")
        return Delegate(annotation.config)
    }
}