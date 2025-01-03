package com.example.kuit_4th_hackathon_team2_android.admin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit_4th_hackathon_team2_android.admin.model.ReturnData
import com.example.kuit_4th_hackathon_team2_android.databinding.ItemAdminReturnBinding

class AdminReturnAdapter(private val itemList: List<ReturnData>) :
    RecyclerView.Adapter<AdminReturnAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(
        private val binding: ItemAdminReturnBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ReturnData) {
            binding.tvAdminReturnItemName.text = item.product
            binding.tvAdminReturnStudent.text = item.stdinfo
            binding.tvAdminReturnLentalDate.text = item.lentalDate
            binding.tvAdminReturnDate.text = item.returnDate

            binding.btnAdminReturn.setOnClickListener {
                //TODO
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ItemAdminReturnBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}