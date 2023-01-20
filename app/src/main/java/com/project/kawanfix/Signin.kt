package com.project.kawanfix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.*
import com.project.kawanfix.Util.RetrofitClient
import com.project.kawanfix.Util.SignInBody
import kotlinx.android.synthetic.main.activity_signin.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    private fun signin(email: String, password: String){
        val retIn = RetrofitClient.RetrofitInstance.getRetrofitInstance().create(RetrofitClient.ApiInterface::class.java)
        val signInInfo = SignInBody(email, password)
        retIn.signin(signInInfo).enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    this@Signin,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                    Log.d("Login Berhasil", ResponseBody.toString())
                } else {
                    Log.d("Login Gagal", ResponseBody.toString())
                }
            }
        })
    }
}