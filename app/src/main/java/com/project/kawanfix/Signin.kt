package com.project.kawanfix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_signin.*

class Signin : AppCompatActivity(),View.OnClickListener {
    private var mIsShowpass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        setFullScreen(window)
        LightStatusBar(window)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val lupasandi : TextView = findViewById(R.id.lupasandi)
        lupasandi.setOnClickListener(this)

        val daftar :TextView = findViewById(R.id.daftar)
        daftar.setOnClickListener(this)

        val button : Button = findViewById(R.id.button)
        button.setOnClickListener(this)

        eye.setOnClickListener {
            mIsShowpass = !mIsShowpass
            edtshowpassword(mIsShowpass)
        }
        edtshowpassword(mIsShowpass)
    }

    private fun edtshowpassword(isShow: Boolean) {
        if (isShow) {
            edtpassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            eye.setImageResource(R.drawable.ic_eye_off)
        } else {
            edtpassword.transformationMethod = PasswordTransformationMethod.getInstance()
            eye.setImageResource(R.drawable.ic_eye)
        }
        edtpassword.setSelection(edtpassword.text.toString().length)
    }

    override fun onClick(v: View?) {
        if (v !=null){
            when(v.id){
                R.id.lupasandi->{
                    val intent = Intent(this,LupaSandi::class.java)
                    startActivity(intent)
                }R.id.button->{
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }R.id.daftar->{
                    val intent = Intent(this,Register::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}