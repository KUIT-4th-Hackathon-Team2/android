package com.example.kuit_4th_hackathon_team2_android.retrofit

import android.content.Context

class SessionManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("UserSession", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun saveSession(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun getSession(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun clearSession() {
        editor.clear()
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getString("user_id", null) != null
    }
}