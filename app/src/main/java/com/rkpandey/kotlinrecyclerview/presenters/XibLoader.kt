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
        /*
        JSON should contain a class name of the Object Presenter, and the XML name of the relative layout, layoutId for the layoutId
         */
        json?.let {
            val item = it[className]
            val string = item as? String
            string?.let {
                return mapOf("presenter" to string)
            }
            return item as? Map<String, String>
        }
        return null
    }

    public fun view(className: String): ObjectPresenterView? {
        val xib = xib(className)
        xib.let {
            val presenterClass = xib!!["presenter"]
            val xml = xib!!["xml"]
            val layoutId = xib!!["layoutId"]
            if (presenterClass != null && xml != null && layoutId != null) {
                val presenter = Class.forName(presenterClass!!).newInstance() as? ObjectPresenter
                presenter?.let {
                    val presenterView = ObjectPresenterView(context)
                    presenterView.inflate(layoutId.toInt())
                    presenterView.presenter = presenter
                    return  presenterView
                }
            }
        }
        return  null
    }
}