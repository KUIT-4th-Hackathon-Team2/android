package com.example.kuit_4th_hackathon_team2_android.admin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_4th_hackathon_team2_android.retrofit.RetrofitObject
import com.example.kuit_4th_hackathon_team2_android.retrofit.Service.AdminRentalService
import com.example.kuit_4th_hackathon_team2_android.admin.model.LentalData
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentAdminLentalBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdminLentalFragment : Fragment() {

    private lateinit var lentalBinding: FragmentAdminLentalBinding
    private lateinit var lentalAdapter: AdminLentalAdapter
    private var lentalDataList = ArrayList<LentalData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        lentalBinding = FragmentAdminLentalBinding.inflate(inflater,container,false)
        initAdapter()
        fetchRentalData()

        return lentalBinding.root
    }

/*    private fun initLentalData() {
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
    }*/

    private fun initAdapter() {
        lentalAdapter = AdminLentalAdapter(lentalDataList)
        with(lentalBinding.rvAdminLental) {
            adapter = lentalAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun fetchRentalData() {
        val service = RetrofitObject.retrofit.create(AdminRentalService::class.java)
        val call = service.getRentalItem()
        call.enqueue(object : Callback<List<LentalData>> {
            override fun onResponse(
                call: Call<List<LentalData>>,
                response: Response<List<LentalData>>
            ) {
                if (response.isSuccessful) {
                    val rentalResponse = response.body()

                    if (!rentalResponse.isNullOrEmpty()) {
                        showRentalInfo(rentalResponse)
                    } else {
                        Log.e("empty value", "No data received from server")
                    }
                } else {
                    Log.e("server response fail", "Server response failed with code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<LentalData>>, t: Throwable) {
                if (t is java.net.UnknownHostException) {
                    Log.e("NetworkError", "Unable to resolve host: ${t.message}")
                } else {
                    Log.e("fetch failure", "Failed to fetch reservation items: ${t.message}")
                }
            }

        })
    }

    private fun showRentalInfo(rentalList : List<LentalData>) {
        lentalDataList.clear()
        lentalDataList.addAll(rentalList)

        if(!::lentalAdapter.isInitialized){
            initAdapter()
        }else {
            lentalAdapter.notifyDataSetChanged()
        }
    }


}