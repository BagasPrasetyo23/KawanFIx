package com.project.kawanfix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.android.synthetic.main.activity_signin.edtpassword
import kotlinx.android.synthetic.main.activity_signin.eye
import kotlinx.android.synthetic.main.activity_ubah_sandi.*

class UbahSandi : AppCompatActivity(),View.OnClickListener {
    private var mIsShowpass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        setFullScreen(window)
        LightStatusBar(window)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_sandi)

        val back : ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            finish()
        }
        val button : Button = findViewById(R.id.button)
        button.setOnClickListener(this)

        eye.setOnClickListener {
            mIsShowpass = !mIsShowpass
            edtshowpassword(mIsShowpass)
        }
        edtshowpassword(mIsShowpass)

        eye1.setOnClickListener {
            mIsShowpass = !mIsShowpass
            edtshowpassword1(mIsShowpass)
        }
        edtshowpassword1(mIsShowpass)

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
    private fun edtshowpassword1(isShow: Boolean) {
        if (isShow) {
            edtpassword1.transformationMethod = HideReturnsTransformationMethod.getInstance()
            eye1.setImageResource(R.drawable.ic_eye_off)
        } else {
            edtpassword1.transformationMethod = PasswordTransformationMethod.getInstance()
            eye1.setImageResource(R.drawable.ic_eye)
        }
        edtpassword1.setSelection(edtpassword.text.toString().length)
    }


    override fun onClick(v: View?) {
        if (v !=null){
            when(v.id){
                R.id.button->{
                    val intent = Intent(this,Signin::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}