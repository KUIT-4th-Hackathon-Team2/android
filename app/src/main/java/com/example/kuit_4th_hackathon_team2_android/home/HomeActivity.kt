package com.example.kuit_4th_hackathon_team2_android.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit_4th_hackathon_team2_android.R
import com.example.kuit_4th_hackathon_team2_android.admin.AdminFragment
import com.example.kuit_4th_hackathon_team2_android.databinding.ActivityHomeBinding
import com.example.kuit_4th_hackathon_team2_android.mypage.MyPageFragment
import com.example.kuit_4th_hackathon_team2_android.reservation.reservation.ReservationFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navItem: NavigationItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigation()
    }
    private fun initBottomNavigation() {
        binding.mainBottomNav.selectedItemId = R.id.myPage
        navItem = NavigationItem.MY_PAGE

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frm, MyPageFragment())
            .commitAllowingStateLoss()

        binding.mainBottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.myPage -> {
                    navItem = NavigationItem.MY_PAGE

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_frm, MyPageFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.reservation -> {
                    navItem = NavigationItem.RESERVATION

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_frm, ReservationFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.admin -> {
                    navItem = NavigationItem.RESERVATION

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_frm, AdminFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

            }
            false
        }
    }

    enum class NavigationItem {
        MY_PAGE, RESERVATION, ADMIN;

        fun setSelectedItemId(): Int {
            return when (this) {
                MY_PAGE -> R.id.myPage
                RESERVATION -> R.id.reservation
                ADMIN -> R.id.admin
            }
        }
    }
}