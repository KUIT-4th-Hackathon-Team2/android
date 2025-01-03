package com.example.kuit_4th_hackathon_team2_android.reservation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_4th_hackathon_team2_android.Retrofit.RetrofitObject
import com.example.kuit_4th_hackathon_team2_android.Retrofit.service.ReservationItemService
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentReservationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReservationFragment : Fragment() {

    private lateinit var binding: FragmentReservationBinding
    private lateinit var reservationRVAdapter: ReservationRVAdapter
    private val reservationItem = arrayListOf<ReservationData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReservationBinding.inflate(inflater, container, false)
        initReservationRVAdapter()
        fetchReservationItemData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchReservationItemData()
    }

    private fun fetchReservationItemData() {
        val service = RetrofitObject.retrofit.create(ReservationItemService::class.java)
        val call = service.getReservationItems()
        call.enqueue(object : Callback<List<ReservationData>> {
            override fun onResponse(
                call: Call<List<ReservationData>>,
                response: Response<List<ReservationData>>
            ) {
                if (response.isSuccessful) {
                    val reservationResponse = response.body()

                    if (!reservationResponse.isNullOrEmpty()) {
                        showReservationInfo(reservationResponse)
                    } else {
                        Log.e("empty value", "No data received from server")
                    }
                } else {
                    Log.e("server response fail", "Server response failed with code: ${response.code()}")
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

    private fun showReservationInfo(reservationList: List<ReservationData>) {
        reservationItem.clear()
        reservationItem.addAll(reservationList)

        if(!::reservationRVAdapter.isInitialized) {
            initReservationRVAdapter()
        } else {
            reservationRVAdapter.notifyDataSetChanged()
        }
    }

    private fun initReservationRVAdapter() {
        reservationRVAdapter = ReservationRVAdapter(reservationItem)
        with(binding.rvReservation) {
            adapter = reservationRVAdapter
            layoutManager =
                LinearLayoutManager(requireContext())
        }
    }
}
