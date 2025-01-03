package com.example.kuit_4th_hackathon_team2_android.admin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_4th_hackathon_team2_android.Retrofit.RetrofitObject
import com.example.kuit_4th_hackathon_team2_android.Retrofit.service.AdminProductService
import com.example.kuit_4th_hackathon_team2_android.admin.model.ProductData
import com.example.kuit_4th_hackathon_team2_android.admin.model.ReservationData
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentAdminProductBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdminProductFragment : Fragment() {

    private lateinit var productBinding: FragmentAdminProductBinding
    private lateinit var productAdapter: AdminProductAdapter
    private var productDataList = ArrayList<ProductData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        productBinding = FragmentAdminProductBinding.inflate(inflater,container,false)
        //initProductData()
        initAdapter()
        fetchReservationInfo()

        return productBinding.root
    }

    private fun initAdapter() {
        productAdapter = AdminProductAdapter(productDataList)

        with(productBinding.rvAdminProductList) {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun fetchReservationInfo() {
        val service = RetrofitObject.retrofit.create(AdminProductService::class.java)
        val call = service.getProductItem()

        call.enqueue(object : Callback<List<ProductData>> {
            override fun onResponse(
                call: Call<List<ProductData>>,
                response: Response<List<ProductData>>
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

            override fun onFailure(call: Call<List<ProductData>>, t: Throwable) {
                Log.e("delete failure", "Failed to delete item: ${t.message}")
            }

        })
    }

    private fun showReturnInfo(returnList: List<ProductData>) {
        productDataList.clear()
        productDataList.addAll(returnList)

        if (!::productAdapter.isInitialized) {
            initAdapter()
        } else {
            productAdapter.notifyDataSetChanged()
        }
    }

/*    private fun initProductData() {
        productDataList.addAll(
            arrayListOf(
                ProductData("우산", "14", "30", ),
                ProductData("우산", "14", "30"),
                ProductData("충전기", "14", "30")
            )
        )
    }*/

/*    private fun initLentalAdapter() {
        productAdapter = AdminProductAdapter(productDataList)
        productBinding.rvAdminProductList.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }*/

    /*private fun fetchReservationInfo(){
        val service = RetrofitObject.retrofit.create(ReservationService::class.java)
        val call = service.getReservation()

        call.enqueue(
            object : retrofit2.Callback<List<ReservationData>> {
                override fun onResponse(
                    call: Call<List<ReservationData>>,
                    response: Response<List<ReservationData>>
                ) {
                    if (response.isSuccessful) {
                        val productResponse = response.body()

                        //데이터가 성공적으로 받아와졌을 때
                        if (!productResponse.isNullOrEmpty()) {
                            showReservationInfo(productResponse)
                        } else {
                            Log.d("실패1", "실패1") //빈값을 받아온 경우
                        }
                    } else {
                        Log.d("실패2", "실패2") //서버 응답이 실패했을 때 (상태코드 5**)
                    }
                }

                override fun onFailure(call: Call<List<ReservationData>>, t: Throwable) { //응답 실패시
                    Log.d("실패3", "실패3") //네트워크 오류
                }


            }
        )
    }

    private fun showReservationInfo(productList : List<ReservationData>) {
        productAdapter = AdminProductAdapter(productList) { selectedProduct ->
            showEditFragment(selectedProduct)
        }

        productBinding.rvAdminProductList.adapter = productAdapter
        productBinding.rvAdminProductList.layoutManager = LinearLayoutManager(context)
    }

    private fun showEditFragment(product : ReservationData){

    }*/
}