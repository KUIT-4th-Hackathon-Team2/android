package com.example.kuit_4th_hackathon_team2_android.admin

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_4th_hackathon_team2_android.R
import com.example.kuit_4th_hackathon_team2_android.admin.model.LentalData
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentAdminBinding
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentAdminLentalBinding

class AdminFragment : Fragment() {

    private lateinit var binding : FragmentAdminBinding
    private lateinit var lentalBinding: FragmentAdminLentalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun showLentalFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_frm, AdminLentalFragment())
            .commit()
    }

    private fun showReturnFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_frm, AdminReturnFragment())
            .commit()
    }

    private fun showProductFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_frm, AdminProductFragment())
            .commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        lentalBinding = FragmentAdminLentalBinding.inflate(inflater,container,false)

        binding = FragmentAdminBinding.inflate(layoutInflater)

        binding.clAdminMenu1.setOnClickListener {
            showLentalFragment()
        }
        binding.clAdminMenu2.setOnClickListener {
            showReturnFragment()
        }
        binding.clAdminMenu3.setOnClickListener {
            showProductFragment()
        }

        return binding.root
    }


}