package com.example.kuit_4th_hackathon_team2_android.admin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit_4th_hackathon_team2_android.admin.model.LentalData
import com.example.kuit_4th_hackathon_team2_android.admin.model.ProductData
import com.example.kuit_4th_hackathon_team2_android.admin.model.ReservationData
import com.example.kuit_4th_hackathon_team2_android.databinding.ItemAdminLentalBinding
import com.example.kuit_4th_hackathon_team2_android.databinding.ItemAdminProductBinding

class AdminProductAdapter (
    private val itemList: List<ReservationData>,
    private val onProductClick: (ReservationData) -> Unit
) :
    RecyclerView.Adapter<AdminProductAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(
        private val binding: ItemAdminProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ReservationData) {
            binding.tvAdminProduct.text = item.productName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemAdminProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.itemView.setOnClickListener{
            onProductClick(itemList[position])
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}