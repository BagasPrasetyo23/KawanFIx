package com.project.kawanfix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class Editprofile : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        setFullScreen(window)
        LightStatusBar(window)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofile)

        val back : ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            finish()
        }
        val card : Button = findViewById(R.id.card)
        card.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v !=null){
            when(v.id){
                R.id.card ->{
                    val intent = Intent(this,profil::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}