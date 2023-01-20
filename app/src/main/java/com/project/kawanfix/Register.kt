package com.project.kawanfix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.*
import com.project.kawanfix.Util.RetrofitClient
import com.project.kawanfix.Util.UserBody
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        eye1.setOnClickListener {
            mIsShowpass = !mIsShowpass
            edtshowpassword1(mIsShowpass)
        }
        edtshowpassword1(mIsShowpass)
    }
    private fun edtshowpassword(isShow: Boolean){
        val password: EditText = findViewById(R.id.password)
        val eye : ImageView = findViewById(R.id.eye)
        if (isShow){
            password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            eye.setImageResource(R.drawable.ic_eye_off)
        }else{
            password.transformationMethod = PasswordTransformationMethod.getInstance()
            eye.setImageResource(R.drawable.ic_eye)
        }
        password.setSelection(password.text.toString().length)
    }

    private fun edtshowpassword1(isShow: Boolean){
        val password_confirmation: EditText = findViewById(R.id.password_confirmation)
        val eye1 : ImageView = findViewById(R.id.eye1)
        if (isShow){
            password_confirmation.transformationMethod = HideReturnsTransformationMethod.getInstance()
            eye1.setImageResource(R.drawable.ic_eye_off)
        }else{
            password_confirmation.transformationMethod = PasswordTransformationMethod.getInstance()
            eye1.setImageResource(R.drawable.ic_eye)
        }
        password_confirmation.setSelection(password_confirmation.text.toString().length)
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

    private fun signup(name: String, email: String, no_telp: String, password: String, password_confirmation: String) {
        val retIn = RetrofitClient.RetrofitInstance.getRetrofitInstance().create(RetrofitClient.ApiInterface::class.java)
        val registerInfo = UserBody(name, email, no_telp, password, password_confirmation)

        retIn.registerUser(registerInfo).enqueue(object :
            Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    this@Register,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 201) {
                    Toast.makeText(this@Register, "Registration success!", Toast.LENGTH_SHORT)
                        .show()

                }
                else{
                    Toast.makeText(this@Register, "Registration failed!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }
}