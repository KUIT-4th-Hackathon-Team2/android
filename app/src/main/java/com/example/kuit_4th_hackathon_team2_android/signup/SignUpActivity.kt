package com.example.kuit_4th_hackathon_team2_android.signup

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kuit_4th_hackathon_team2_android.databinding.ActivitySignUpBinding
import com.example.kuit_4th_hackathon_team2_android.retrofit.LoginResponseData
import com.example.kuit_4th_hackathon_team2_android.retrofit.RetrofitObject
import com.example.kuit_4th_hackathon_team2_android.retrofit.Service.LoginService
import com.example.kuit_4th_hackathon_team2_android.retrofit.ServicePool
import com.example.kuit_4th_hackathon_team2_android.retrofit.UserData
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private var canSignup = false
    private var isAdmin = "admin"

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
            if(binding.etSignUpUserName.text.toString().isEmpty()){
                canSignup = false
                binding.tvSignUpUserNameWarning.visibility = View.VISIBLE
            }
            else{
                binding.tvSignUpUserNameWarning.visibility = View.INVISIBLE
            }
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
                    isAdmin = "user"
                } else {
                    isAdmin = "admin"
                }
            }

            if (canSignup) {
                // 서버로 요청날려서 요청성공했는지 확인
//                initPostData()
                finish()
            }
        }
    }

//    private fun initPostData() {
//        val newUserData = UserData(
//            binding.etSignUpUserName.text.toString(),
//            binding.etSignUpId.text.toString(),
//            binding.etSignUpPassword.text.toString(),
//            isAdmin
//        )
//        val test = LoginResponseData(
//            "1",1,"1","1"
//        )
////        val service = RetrofitObject.retrofit.create(LoginService::class.java)
//        val service = ServicePool.loginService
//        val call = service.postUser(test)
//        call.enqueue(
//            object : retrofit2.Callback<LoginResponseData> {
//                override fun onResponse(
//                    call: retrofit2.Call<LoginResponseData>,
//                    response: Response<LoginResponseData>
//                ) {
//                    if (response.isSuccessful) {
//                        val userLoginData = response.body()
//                        if (userLoginData != null) {
//                            Log.d("성공", "잘들어감")
//                            finish()
//                        } else {
//                            Log.d("실패", "아이디 중복?")
//                        }
//                    } else {
//                        Log.d("실패", "상테코드 ${response.code()}")
//                    }
//                }
//
//                override fun onFailure(call: retrofit2.Call<LoginResponseData>, t: Throwable) {
//                    Log.d("실패", "완벽한 실패: ${t.toString()}")
//                    t.printStackTrace()
//                }
//            }
//        )
//        val call2 = service.getUser()
//        call2.enqueue(
//            object : retrofit2.Callback<LoginResponseData> {
//                override fun onResponse(
//                    call: Call<LoginResponseData>,
//                    response: Response<LoginResponseData>
//                ) {
//                    if (response.isSuccessful) {
//                        val userLoginData = response.body()
//                        if (userLoginData != null) {
//                            Log.d("성공", "잘들어감")
//                        } else {
//                            Log.d("실패", "아이디 중복?")
//                        }
//                    } else {
//                        Log.d("실패", "상테코드 ${response.code()}")
//                    }
//                }
//
//                override fun onFailure(call: Call<LoginResponseData>, t: Throwable) {
//                    Log.d("실패", "완벽한 실패: ${t.toString()}")
//                }
//            }
//        )
//    }

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
