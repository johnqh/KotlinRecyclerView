package com.rkpandey.kotlinrecyclerview.particles
import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.sudobility.platformparticles.xml.XibLoader
import com.sudobility.platformparticles.presenter.LayoutCache

class ParticlesApplication : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: ParticlesApplication? = null

        fun shared() : ParticlesApplication {
            return instance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        XibLoader.context = getApplicationContext()

        val layoutId = LayoutCache.layoutId("activity_main")
//        val r = R.layout()

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    public fun layoutId(layout: String): Int {
        return resources.getIdentifier(layout, "layout", packageName)
    }
}
