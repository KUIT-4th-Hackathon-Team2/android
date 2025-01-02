package com.example.kuit_4th_hackathon_team2_android.mypage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentMypageBinding
import com.example.kuit_4th_hackathon_team2_android.mypage.model.MyPageData


class MyPageFragment : Fragment() {
    private lateinit var binding: FragmentMypageBinding
    private lateinit var myPageAdapter: MyPageAdapter
    private var myPageDataList= ArrayList<MyPageData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding =FragmentMypageBinding.inflate(inflater,container,false)

        initData()
        initMyPageAdapter()



        return binding.root
    }

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

}