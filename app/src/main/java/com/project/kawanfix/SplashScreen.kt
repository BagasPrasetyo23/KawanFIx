package com.project.kawanfix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    private val Splash_Time:Long =1200
    override fun onCreate(savedInstanceState: Bundle?) {
        setFullScreen(window)
        LightStatusBar(window)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed(
            {
                val intent = Intent(this, Signin::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
            },
            Splash_Time,
        )
    }
}