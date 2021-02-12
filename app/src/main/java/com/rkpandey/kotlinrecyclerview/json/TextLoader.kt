package com.rkpandey.kotlinrecyclerview.json

import android.content.Context
import java.io.InputStream

object TextLoader{
    fun load(context: Context, fileName: String): String? {
        var json: String? = null
        try {
            val  inputStream: InputStream = context.assets.open(fileName)
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}