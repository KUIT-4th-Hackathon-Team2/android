package com.example.kuit_4th_hackathon_team2_android.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.lifecycleScope
import com.example.kuit_4th_hackathon_team2_android.Retrofit.RetrofitObject



import com.example.kuit_4th_hackathon_team2_android.databinding.ActivityLoginBinding
import com.example.kuit_4th_hackathon_team2_android.home.HomeActivity
import com.example.kuit_4th_hackathon_team2_android.login.model.LoginData
import com.example.kuit_4th_hackathon_team2_android.login.model.ResponseData



import kotlinx.coroutines.launch

import com.example.kuit_4th_hackathon_team2_android.retrofit.Service.LoginService
import com.example.kuit_4th_hackathon_team2_android.retrofit.SharedPreferencesHelper
import com.example.kuit_4th_hackathon_team2_android.signup.SignUpActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var canLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginSignIn.setOnClickListener {
            checkingAccount()


        }

        binding.btnLoginSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }


    private fun checkingAccount() {
        val id = binding.etLoginId.text.toString().toLong()
        val password = binding.etLoginPassword.text.toString()
        val service = RetrofitObject.retrofit.create(LoginService::class.java)


        val call = service.postLoginData(LoginData(id, password))
        call.enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                if (response.isSuccessful) {
                    val reservationResponse = response.body()
                    val cookie = response.headers().values("Set-Cookie")
                    val regex = "(JSESSIONID=[^;]+)".toRegex() // JSESSIONID 키와 값을 추출하는 정규식
                    val cookieResult = regex.find(cookie.toString())?.value.toString()
                    Log.e("fetch failure", cookieResult)
                    SharedPreferencesHelper.saveCookie(this@MainActivity, cookieResult)
                    RetrofitObject.setCookie(cookieResult)
                    canLogin = true


                    val intent = Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Log.e(
                        "server response fail",
                        "Server response failed with code: ${response.code()}"
                    )
                    binding.tvLoginWarning.visibility = View.VISIBLE
                }
            }


            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                if (t is java.net.UnknownHostException) {
                    Log.e("NetworkError", "Unable to resolve host: ${t.message}")
                } else {
                    Log.e("fetch failure", "Failed to fetch reservation items: ${t.message}")
                }
                binding.tvLoginWarning.visibility = View.VISIBLE
            }


        }
        )

    }
}