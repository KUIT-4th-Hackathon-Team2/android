package com.example.kuit_4th_hackathon_team2_android.mypage

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit_4th_hackathon_team2_android.databinding.ItemMyPageBinding
import com.example.kuit_4th_hackathon_team2_android.mypage.model.MyPageData
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class MyPageAdapter(private val itemList: List<MyPageData>) :
    RecyclerView.Adapter<MyPageAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(
        private val binding: ItemMyPageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(item: MyPageData) {
            binding.tvItemMyPageName.text = item.productName
            binding.tvItemMyPageReturnDate.text = item.expirationDate
            val remainingDays = calculateRemainingDays(item.rentalTime, item.expirationDate)
            binding.tvItemRemainTime.text = remainingDays.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemMyPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateRemainingDays(rentalTime: String, expirationDate: String): Long {
        // ISO 8601 형식의 날짜 문자열을 LocalDateTime으로 변환
        val rentalDateTime = LocalDateTime.parse(rentalTime, DateTimeFormatter.ISO_DATE_TIME)

        // expirationDate를 LocalDate로 변환
        val expirationLocalDate = LocalDate.parse(expirationDate, DateTimeFormatter.ISO_DATE)

        // rentalTime의 날짜 부분만 추출
        val rentalDate = rentalDateTime.toLocalDate()

        // expirationDate와 rentalDate의 차이를 계산
        val daysRemaining = ChronoUnit.DAYS.between(rentalDate, expirationLocalDate)

        return daysRemaining
    }
}