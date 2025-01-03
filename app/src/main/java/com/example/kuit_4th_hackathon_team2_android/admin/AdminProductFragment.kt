package com.example.kuit_4th_hackathon_team2_android.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_4th_hackathon_team2_android.admin.model.ProductData
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentAdminProductBinding

class AdminProductFragment : Fragment() {

    private lateinit var productBinding: FragmentAdminProductBinding
    private lateinit var productAdapter: AdminProductAdapter
    private var productDataList = ArrayList<ProductData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        productBinding = FragmentAdminProductBinding.inflate(inflater,container,false)
        initProductData()
        initLentalAdapter()

        return productBinding.root
    }

    private fun initProductData() {
        productDataList.addAll(
            arrayListOf(
                ProductData("우산", "14", "30"),
                ProductData("우산", "14", "30"),
                ProductData("충전기", "14", "30")
            )
        )
    }

    private fun initLentalAdapter() {
        productAdapter = AdminProductAdapter(productDataList)
        productBinding.rvAdminProductList.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }
}