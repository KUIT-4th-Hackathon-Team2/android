package com.example.kuit_4th_hackathon_team2_android.retrofit

import android.content.Context
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class LoginInterceptor(private val cookies: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

        // SharedPreferences에서 쿠키 불러오기
        val cookie = cookies
        if (cookie.isNotEmpty()) {
            // 쿠키를 헤더에 추가
            request.addHeader("Cookie", cookie)
        }
        Log.d("interceptor", cookies.toString())

        return chain.proceed(request.build())
    }
}