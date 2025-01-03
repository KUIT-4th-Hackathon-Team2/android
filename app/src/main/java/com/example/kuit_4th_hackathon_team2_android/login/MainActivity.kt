package com.example.kuit_4th_hackathon_team2_android.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kuit_4th_hackathon_team2_android.databinding.ActivityLoginBinding
import com.example.kuit_4th_hackathon_team2_android.home.HomeActivity
import com.example.kuit_4th_hackathon_team2_android.retrofit.LoginRequestData
import com.example.kuit_4th_hackathon_team2_android.signup.SignUpActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var canLogin = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginSignIn.setOnClickListener {
//            checkingAccount()
            if (canLogin) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                binding.tvLoginWarning.visibility = View.INVISIBLE
            }

            finish()
        }

        binding.btnLoginSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkingAccount() {
//        val id = binding.etLoginId.text.toString()
//        val password = binding.etLoginPassword.toString()
//        val service = RetrofitObject.retrofit.create(LoginService::class.java)
//        val call = service.login(LoginRequestData(id, password))



        canLogin = true

    }
}