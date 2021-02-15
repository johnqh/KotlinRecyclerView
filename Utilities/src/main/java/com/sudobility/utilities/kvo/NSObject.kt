package com.sudobility.utilities.kvo

import kotlin.collections.HashMap

open class NSObject: ObservedProtocol {
    override var _kvoController: KVOController? = null

    private var properties: HashMap<String, Any?> = HashMap<String, Any?>()

    public fun value(key: String): Any? {
        return  properties[key]
    }

    public fun set(value: Any?, key: String) {
        val old = properties[key]
        properties[key] = value
        didChange(key, old, value)
    }

}