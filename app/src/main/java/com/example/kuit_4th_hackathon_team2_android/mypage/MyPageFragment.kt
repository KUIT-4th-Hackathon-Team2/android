package com.example.kuit_4th_hackathon_team2_android.mypage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.kuit_4th_hackathon_team2_android.Retrofit.service.MyPageService
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentMypageBinding
import com.example.kuit_4th_hackathon_team2_android.mypage.model.MyPageData
import com.example.kuit_4th_hackathon_team2_android.retrofit.RetrofitObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyPageFragment : Fragment() {
    private lateinit var binding: FragmentMypageBinding
    private lateinit var myPageAdapter: MyPageAdapter
    private var myPageDataList= ArrayList<MyPageData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding =FragmentMypageBinding.inflate(inflater,container,false)

        /*initData()
        initMyPageAdapter()*/

        binding = FragmentMypageBinding.inflate(inflater,container,false)
        initAdapter()
        fetchMyPageData()


        return binding.root
    }

    private fun initAdapter() {
        myPageAdapter = MyPageAdapter(myPageDataList)
        with(binding.rvMyPage) {
            adapter = myPageAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun fetchMyPageData() {
        val service = RetrofitObject.retrofit.create(MyPageService::class.java)
        val call = service.getRentalItem(1)
        call.enqueue(object : Callback<List<MyPageData>> {
            override fun onResponse(
                call: Call<List<MyPageData>>,
                response: Response<List<MyPageData>>
            ) {
                if (response.isSuccessful) {
                    val rentalResponse = response.body()

                    if (!rentalResponse.isNullOrEmpty()) {//
                        binding.tvMyPageNoBorrow.visibility=View.GONE
                        showMyPageInfo(rentalResponse)
                    } else {
                        Log.e("empty value", "No data received from server")
                            binding.tvMyPageNoBorrow.visibility=View.VISIBLE
                    }
                } else {
                    Log.e("server response fail", "Server response failed with code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<MyPageData>>, t: Throwable) {
                if (t is java.net.UnknownHostException) {
                    Log.e("NetworkError", "Unable to resolve host: ${t.message}")
                } else {
                    Log.e("fetch failure", "Failed to fetch reservation items: ${t.message}")
                }
            }

        })
    }

    private fun showMyPageInfo(mypageList : List<MyPageData>){
        myPageDataList.clear()
        myPageDataList.addAll(mypageList)

        if(!::myPageAdapter.isInitialized){
            initAdapter()
        }else {
            myPageAdapter.notifyDataSetChanged()
        }
    }
/*

    private fun initData() {
        myPageDataList.addAll(
            arrayListOf(
                MyPageData(
                    "우산","2024.12.31",2
                ),
                MyPageData(
                    "우산","2024.12.31",2
                ),
                MyPageData(
                    "우산","2024.12.31",2
                ),
                MyPageData(
                    "우산","2024.12.31",2
                ),
                MyPageData(
                    "우산","2024.12.31",2
                ),
                MyPageData(
                    "우산","2024.12.31",2
                ),
                MyPageData(
                    "우산","2024.12.31",2
                ),
                MyPageData(
                    "우산","2024.12.31",2
                )
            )
        )
    }

    private fun initMyPageAdapter() {

        if(myPageDataList.size!=0){
            binding.tvMyPageNoBorrow.visibility=View.GONE
        }
        else{
            binding.tvMyPageNoBorrow.visibility=View.VISIBLE
        }

        myPageAdapter = MyPageAdapter(myPageDataList)
        binding.rvMyPage.apply {
            adapter = myPageAdapter
            layoutManager = LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }
*/

}