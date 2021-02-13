package com.rkpandey.kotlinrecyclerview.presenters
import kotlin.reflect.full.memberProperties
import com.rkpandey.kotlinrecyclerview.model.ModelObjectProtocol
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.staticProperties

object LayoutCache {
    private var cache = HashMap<String, Int>()

    public fun parse(obj: Any) {
        val objClass = obj.javaClass.kotlin
        objClass.staticProperties.forEach { property ->
            val value = property.get() as? Int
            value?.let {
                cache[property.name] = value
            }
        }
    }

    public fun layoutId(named: String): Int? {
        return cache[named]
    }
}