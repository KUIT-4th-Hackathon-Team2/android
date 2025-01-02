package com.example.kuit_4th_hackathon_team2_android.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit_4th_hackathon_team2_android.databinding.ActivityLoginBinding
import com.example.kuit_4th_hackathon_team2_android.home.HomeActivity
import com.example.kuit_4th_hackathon_team2_android.signup.SignUpActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var canLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginSignIn.setOnClickListener {
            checkingAccount()
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

        // 로그인 기능 구현해야함

        canLogin = true

    }
}