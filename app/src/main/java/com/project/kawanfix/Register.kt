package com.project.kawanfix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity(),View.OnClickListener {
    private var mIsShowpass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        setFullScreen(window)
        LightStatusBar(window)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button :  Button = findViewById(R.id.button)
        button.setOnClickListener(this)
        val masuk : TextView = findViewById(R.id.masuk)
        masuk.setOnClickListener(this)
        val back: ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            finish()
        }
        eye.setOnClickListener {
            mIsShowpass = !mIsShowpass
            edtshowpassword(mIsShowpass)
        }
        edtshowpassword(mIsShowpass)
    }
    private fun edtshowpassword(isShow: Boolean){
        val edtpassword: EditText = findViewById(R.id.edtpassword)
        val eye : ImageView = findViewById(R.id.eye)
        if (isShow){
            edtpassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            eye.setImageResource(R.drawable.ic_eye_off)
        }else{
            edtpassword.transformationMethod = PasswordTransformationMethod.getInstance()
            eye.setImageResource(R.drawable.ic_eye)
        }
        edtpassword.setSelection(edtpassword.text.toString().length)
    }

    override fun onClick(v: View?) {
        if (v !=null){
            when(v.id){
                R.id.button->{
                    val intent = Intent(this,Signin::class.java)
                    startActivity(intent)
                }R.id.masuk->{
                    val intent = Intent(this,Signin::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}