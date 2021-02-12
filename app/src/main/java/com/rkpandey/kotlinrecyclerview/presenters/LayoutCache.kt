package com.rkpandey.kotlinrecyclerview.presenters
import kotlin.reflect.full.memberProperties
import com.rkpandey.kotlinrecyclerview.model.ModelObjectProtocol
import kotlin.reflect.full.declaredMemberProperties

object LayoutCache {
    private var cache = HashMap<String, Int>()

    public fun parse(obj: Any) {
        obj.javaClass.kotlin.declaredMemberProperties.forEach { property ->
            val value = property.get(obj) as? Int
            value?.let {
                cache[property.name] = value
            }
        }
    }

    public fun layoutId(named: String): Int? {
        return cache[named]
    }
}