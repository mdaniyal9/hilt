package com.example.hilttestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {

    private val TAG: String = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "In onRestart")

    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "In onStart")
    }


    override fun onResume() {
        super.onResume()
        Log.e(TAG, "In onResume")
    }

    override fun onPause() {
        Log.e(TAG, "In onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e(TAG, "In onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e(TAG, "In onDestroy")
        super.onDestroy()
    }
}