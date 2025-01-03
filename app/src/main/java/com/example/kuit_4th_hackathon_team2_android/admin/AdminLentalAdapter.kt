package com.example.kuit_4th_hackathon_team2_android.admin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit_4th_hackathon_team2_android.admin.model.LentalData
import com.example.kuit_4th_hackathon_team2_android.databinding.ItemAdminLentalBinding

class AdminLentalAdapter (private val itemList: List<LentalData>,
    private val onClickConfirm : (LentalData) -> Unit) :
    RecyclerView.Adapter<AdminLentalAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(
        private val binding: ItemAdminLentalBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LentalData) {
            binding.tvAdminLentalItemName.text = item.productName
            binding.tvAdminLentalStudent.text = item.userName+" ("+item.studentNum+")"
            binding.tvAdminLentalDate.text = item.registerTime

            binding.btnAdminLental.setOnClickListener {
                onClickConfirm(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemAdminLentalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}