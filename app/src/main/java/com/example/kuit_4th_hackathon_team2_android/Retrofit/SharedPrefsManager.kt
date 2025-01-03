package com.example.kuit_4th_hackathon_team2_android.retrofit

import android.content.Context


object SharedPreferencesHelper {
    private const val PREF_NAME = "Cookie"

    // 쿠키 저장
    fun saveCookie(context: Context, cookie: String) {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("Cookie", cookie)
            commit()
        }
    }

    // 쿠키 불러오기
    fun loadCookie(context: Context): String? {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString("Cookie", null)
    }
}