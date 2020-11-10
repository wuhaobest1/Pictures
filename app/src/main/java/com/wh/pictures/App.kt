package com.wh.pictures

import android.app.Application
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        UnsplashPhotoPicker.init(
                this, // application
                "BNJoE6jZYza-rwszt52WJ1wRktQSS64JuaKvrMFPigI",
                "zBuCZg9jVDCTkqc0N-FYbi9v4PPl59Y3M79sgwdbiGw"
                /* optional page size */
        )
    }
}