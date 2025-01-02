package com.example.kuit_4th_hackathon_team2_android.signup

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kuit_4th_hackathon_team2_android.R
import com.example.kuit_4th_hackathon_team2_android.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private var canSignup = false
    private var isAdmin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initCheckingPassword()
        initCheckingCheckBox()

        initCheckingSignUp()

    }

    private fun initCheckingSignUp() {
        binding.btnSignUpSignUp.setOnClickListener {
            canSignup = true
            if (binding.etSignUpId.text.toString().isEmpty()) {
                canSignup = false
                binding.tvSignUpIdWarning.text = "아이디를 입력하세요."
                binding.tvSignUpIdWarning.visibility = View.VISIBLE
            } else {
                binding.tvSignUpIdWarning.visibility = View.INVISIBLE
            }

            if (binding.etSignUpPassword.text.toString() == binding.etSignUpPasswordCheck.text.toString()) {
                binding.tvSignUpPasswordWarning.visibility = View.INVISIBLE
            } else {
                canSignup = false
                binding.tvSignUpPasswordWarning.text = "입력하신 비밀번호가 일치하지 않습니다."
                binding.tvSignUpPasswordWarning.visibility = View.VISIBLE
            }
            val inputText = binding.etSignUpPasswordCheck.text.toString()
            if (inputText.isEmpty()) {
                canSignup = false
                binding.tvSignUpPasswordWarning.text = "비밀번호 확인란이 비어 있습니다."
                binding.tvSignUpPasswordWarning.visibility = View.VISIBLE
            }

            if (!binding.cbSignUpUser.isChecked && !binding.cbSignUpAdmin.isChecked) {
                canSignup = false
                binding.tvSignUpAuthorityWarning.text = "계정 권한을 선택하세요."
                binding.tvSignUpAuthorityWarning.visibility = View.VISIBLE
            } else {
                binding.tvSignUpAuthorityWarning.visibility = View.INVISIBLE
                if (binding.cbSignUpUser.isChecked) {
                    isAdmin = false
                } else {
                    isAdmin = true
                }
            }

            if (canSignup) {
                finish()
            }

        }
    }

    private fun initCheckingCheckBox() {
        binding.cbSignUpAdmin.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.cbSignUpUser.isChecked = false
            }
        }

        binding.cbSignUpUser.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.cbSignUpAdmin.isChecked = false
            }
        }
    }

    private fun initCheckingPassword() {
        binding.etSignUpPasswordCheck.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val imm =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager // 키보드 닫기
                imm.hideSoftInputFromWindow(binding.etSignUpPasswordCheck.windowToken, 0)
                true
            } else {
                false
            }
        }
    }
}