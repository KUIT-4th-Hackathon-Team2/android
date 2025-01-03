package com.example.kuit_4th_hackathon_team2_android.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_4th_hackathon_team2_android.admin.model.ReturnData
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentAdminReturnBinding

class AdminReturnFragment : Fragment() {

    private lateinit var returnBinding: FragmentAdminReturnBinding
    private lateinit var returnAdapter: AdminReturnAdapter
    private var returnDataList = ArrayList<ReturnData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        returnBinding = FragmentAdminReturnBinding.inflate(inflater,container,false)
/*        initLentalData()
        initLentalAdapter()*/

        return returnBinding.root
    }

/*    private fun initLentalData() {
        returnDataList.addAll(
            arrayListOf(
                ReturnData("우산", "건구스(202512345)", "2025-01-01 19:00", "2025-01-15"),
                ReturnData("우산", "건구스(202512345)", "2025-01-01 19:00", "2025-01-15"),
                ReturnData("우산", "건구스(202512345)", "2025-01-01 19:00", "2025-01-15")
            )
        )
    }

    private fun initLentalAdapter() {
        returnAdapter = AdminReturnAdapter(returnDataList)
        returnBinding.rvAdminReturn.apply {
            adapter = returnAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }*/
}