package nsu.ritersport.focususerrs

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FocusUsersApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}