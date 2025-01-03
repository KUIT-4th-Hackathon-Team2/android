package com.example.kuit_4th_hackathon_team2_android.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_4th_hackathon_team2_android.R
import com.example.kuit_4th_hackathon_team2_android.admin.model.LentalData
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentAdminLentalBinding

class AdminLentalFragment : Fragment() {

    private lateinit var lentalBinding: FragmentAdminLentalBinding
    private lateinit var lentalAdapter: AdminLentalAdapter
    private var lentalDataList = ArrayList<LentalData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        lentalBinding = FragmentAdminLentalBinding.inflate(inflater,container,false)
        initLentalData()
        initLentalAdapter()

        return lentalBinding.root
    }

    private fun initLentalData() {
        lentalDataList.addAll(
            arrayListOf(
                LentalData("우산", "건구스(202512345)", "2025-01-01 19:00"),
                LentalData("우산", "건구스(202512345)", "2025-01-01 19:00"),
                LentalData("우산", "건구스(202512345)", "2025-01-01 19:00")
            )
        )
    }

    private fun initLentalAdapter() {
        lentalAdapter = AdminLentalAdapter(lentalDataList)
        lentalBinding.rvAdminLental.apply {
            adapter = lentalAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }
}