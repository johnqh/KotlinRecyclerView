package com.rkpandey.kotlinrecyclerview.presenters
import android.content.Context
import kotlin.reflect.full.memberProperties
import com.rkpandey.kotlinrecyclerview.model.ModelObjectProtocol
import com.rkpandey.kotlinrecyclerview.particles.ParticlesApplication
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
        var layoutId = cache[named]
        if (layoutId != 0) {
            layoutId = ParticlesApplication.shared().layoutId(named)
            cache[named] = layoutId
        }
        return  layoutId
    }
}