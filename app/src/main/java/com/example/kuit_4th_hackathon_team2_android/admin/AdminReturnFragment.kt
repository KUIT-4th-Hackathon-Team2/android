package com.example.kuit_4th_hackathon_team2_android.admin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_4th_hackathon_team2_android.Retrofit.service.AdminReturnService
import com.example.kuit_4th_hackathon_team2_android.admin.model.ReservationData
import com.example.kuit_4th_hackathon_team2_android.admin.model.ReturnData
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentAdminReturnBinding
import com.example.kuit_4th_hackathon_team2_android.retrofit.RetrofitObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdminReturnFragment : Fragment() {

    private lateinit var returnBinding: FragmentAdminReturnBinding
    private lateinit var returnAdapter: AdminReturnAdapter
    private var returnDataList = ArrayList<ReservationData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        returnBinding = FragmentAdminReturnBinding.inflate(inflater, container, false)
        initAdapter()
        fetchReturnData()

        return returnBinding.root
    }

    private fun initAdapter() {
        returnAdapter = AdminReturnAdapter(returnDataList) { item ->
            deleteReturnItem(item)
        }
        with(returnBinding.rvAdminReturn) {
            adapter = returnAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun fetchReturnData() {
        val service = RetrofitObject.retrofit.create(AdminReturnService::class.java)
        val call = service.getReturnItem()
        call.enqueue(object : Callback<List<ReservationData>> {
            override fun onResponse(
                call: Call<List<ReservationData>>,
                response: Response<List<ReservationData>>
            ) {
                if (response.isSuccessful) {
                    val returnResponse = response.body()

                    if (!returnResponse.isNullOrEmpty()) {
                        showReturnInfo(returnResponse)
                    } else {
                        Log.e("empty value", "No data received from server")
                    }
                } else {
                    Log.e(
                        "server response fail",
                        "Server response failed with code: ${response.code()}"
                    )
                }
            }

            override fun onFailure(call: Call<List<ReservationData>>, t: Throwable) {
                if (t is java.net.UnknownHostException) {
                    Log.e("NetworkError", "Unable to resolve host: ${t.message}")
                } else {
                    Log.e("fetch failure", "Failed to fetch reservation items: ${t.message}")
                }
            }

        })
    }

    private fun deleteReturnItem(item: ReservationData) {
        val service = RetrofitObject.retrofit.create(AdminReturnService::class.java)
        val call = service.removeItem(item.rentalId) // 삭제 요청

        Log.d("Delete Request", "Attempting to delete item with rentalId: ${item.rentalId}")

        Log.d("Delete Request", "URL: ${RetrofitObject.retrofit.baseUrl()}rentals/${item.rentalId}")

        Log.d("Delete Request", "rentalId type: ${item.rentalId::class.java}")

        call.enqueue(object : Callback<List<ReservationData>> {

            override fun onResponse(
                call: Call<List<ReservationData>>,
                response: Response<List<ReservationData>>
            ) {
                if (response.isSuccessful) {
                    val returnResponse = response.body()
                    Log.d("delete success", "Item deleted successfully")
                    if(!returnResponse.isNullOrEmpty()){
                    showReturnInfo(returnResponse) // UI 업데이트
                        }
                } else {
                    Log.e("delete fail", "Failed to delete item with code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<ReservationData>>, t: Throwable) {
                Log.e("delete failure", "Failed to delete item: ${t.message}")
            }
        })
    }


    private fun showReturnInfo(returnList: List<ReservationData>) {
        returnDataList.clear()
        returnDataList.addAll(returnList)

        if (!::returnAdapter.isInitialized) {
            initAdapter()
        } else {
            returnAdapter.notifyDataSetChanged()
        }
    }
}