package com.rkpandey.kotlinrecyclerview.json

import android.content.Context
import org.json.JSONObject

object JsonLoader{
    fun load(context: Context, fileName: String): JSONObject? {
        val text = TextLoader.load(context, fileName)
        text?.let {
            return JSONObject(text)
        }
        return null
    }
}