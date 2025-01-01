package com.example.kuit_4th_hackathon_team2_android.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit_4th_hackathon_team2_android.R
import com.example.kuit_4th_hackathon_team2_android.databinding.ActivityHomeBinding
import com.example.kuit_4th_hackathon_team2_android.databinding.ActivityLoginBinding
import com.example.kuit_4th_hackathon_team2_android.home.HomeActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}