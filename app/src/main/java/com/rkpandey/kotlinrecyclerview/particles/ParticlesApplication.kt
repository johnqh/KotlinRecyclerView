package com.rkpandey.kotlinrecyclerview.particles
import android.app.Application
import android.content.res.Configuration
import android.util.Log
import com.rkpandey.kotlinrecyclerview.R
import com.rkpandey.kotlinrecyclerview.presenters.LayoutCache
import com.rkpandey.kotlinrecyclerview.presenters.XibLoader

class ParticlesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        XibLoader.context = getApplicationContext()

        val r = R.layout()

        LayoutCache.parse(r)
    }

    override fun onConfigurationChanged ( newConfig : Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}