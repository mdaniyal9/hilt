package com.example.hilttestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


class ThirdActivity : AppCompatActivity(), LifecycleObserver {

    private val TAG: String = "ThirdActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        ReduceComplexComponent().registerLifecycle(lifecycle)
    }
}

class ReduceComplexComponent : LifecycleObserver{

    fun registerLifecycle(lifecycle: Lifecycle){
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        Log.e("OnCreate","ON_CREATE")
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//    fun any() {
//        Log.e("OnAny","ON_ANY")
//    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        Log.e("OnStart","ON_START")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        Log.e("OnResume","ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() {
        Log.e("onPause","ON_PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        Log.e("onStop","ON_STOP")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        Log.e("onDestroy","ON_DESTROY")
    }
}
