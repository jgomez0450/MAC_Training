package com.example.user.activitylifecycleandintent

import android.app.Application
import android.util.Log

class MyApplication : Application() {

    companion object {

        private val TAG = MyApplication::class.java.simpleName
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "onTerminate: ")

    }
}