package com.example.kuit_4th_hackathon_team2_android.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit_4th_hackathon_team2_android.databinding.ItemMyPageBinding
import com.example.kuit_4th_hackathon_team2_android.mypage.model.MyPageData

class MyPageAdapter(private val itemList: List<MyPageData>) :
    RecyclerView.Adapter<MyPageAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(
        private val binding: ItemMyPageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyPageData) {
            binding.tvItemMyPageName.text = item.name
            binding.tvItemMyPageReturnDate.text = item.date
            binding.tvItemRemainTime.text = item.time.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemMyPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}