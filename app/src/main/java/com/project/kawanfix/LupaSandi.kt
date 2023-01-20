package com.project.kawanfix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class LupaSandi : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen(window)
        LightStatusBar(window)
        setContentView(R.layout.activity_lupa_sandi)
        val button : Button = findViewById(R.id.button)
        button.setOnClickListener(this)
        val back : ImageButton = findViewById(R.id.back)
        back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       if (v!=null){
           when(v.id){
               R.id.button->{
                   val intent = Intent(this,Verifikasi::class.java)
                   startActivity(intent)
               }
               R.id.back->{
                   val intent = Intent(this,Signin::class.java)
                   startActivity(intent)
               }
           }
       }
    }
}