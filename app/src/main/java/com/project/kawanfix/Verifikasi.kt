package com.project.kawanfix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_verifikasi.*

class Verifikasi : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        setFullScreen(window)
        LightStatusBar(window)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifikasi)
        val back : ImageButton = findViewById(R.id.back)
        back.setOnClickListener{
            finish()
        }
        val button : Button = findViewById(R.id.button)
        button.setOnClickListener(this)

        object : CountDownTimer(60000,1000) {
            override fun onTick(millisUntilFinished: Long) {
                textView.text = "00 : ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                finish()
            }

        }.start()
    }

    override fun onClick(v: View?) {
        if (v !=null){
            when(v.id){
                R.id.button->{
                    val intent = Intent(this,UbahSandi::class.java)
                    startActivity(intent)
                }
            }
        }
    }


}