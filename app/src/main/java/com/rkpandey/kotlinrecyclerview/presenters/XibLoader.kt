package com.rkpandey.kotlinrecyclerview.presenters

import com.rkpandey.kotlinrecyclerview.json.JsonLoader
import org.json.JSONObject
import android.content.Context
import android.widget.RelativeLayout

object XibLoader {
    public var context: Context? = null
        set(value) {
            field = value
            value?.let {
                json = JsonLoader.load(it, "xib.json")
            }
        }

    private var json: JSONObject? = null

    public fun xib(className: String): Map<String, String>? {
        json?.let {
            val item = it[className]
            val string = item as? String
            string?.let {
                return mapOf("view" to string)
            }
            return item as? Map<String, String>
        }
        return null
    }

    public fun view(className: String): RelativeLayout? {
        val xib = xib(className)
        xib.let {
            val viewClass = xib!!["view"]
            viewClass.let {
                val xml = xib!!["xml"]

            }
        }
    }
}