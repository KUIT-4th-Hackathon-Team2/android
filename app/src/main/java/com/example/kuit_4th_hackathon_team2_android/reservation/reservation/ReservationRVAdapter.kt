package com.example.kuit_4th_hackathon_team2_android.reservation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit_4th_hackathon_team2_android.databinding.ItemUserReservationBinding

class ReservationRVAdapter(
    private val items : List<ReservationData>,
    private val reservationClickListener : (ReservationData) -> Unit = {}
) : RecyclerView.Adapter<ReservationRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding : ItemUserReservationBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(item : ReservationData) {
                    binding.tvItemName.text = item.name
                    val remainNumber = item.remainNumber
                    val rentalPeriod = item.rentalPeriod
                    binding.tvItemInfo.text = "대여 가능 수량 : $remainNumber / $rentalPeriod"

                    binding.tvItemAvailable.setOnClickListener {
                        binding.tvItemAvailable.visibility = View.GONE
                        binding.tvItemReservation.visibility = View.VISIBLE
                        binding.tvItemInfo.text = "대여 가능 수량 : ${remainNumber - 1} / $rentalPeriod"
                        binding.tvItemBorrowedState.visibility = View.VISIBLE
                    }

                    binding.tvItemReservation.setOnClickListener {
                        binding.tvItemAvailable.visibility = View.VISIBLE
                        binding.tvItemReservation.visibility = View.GONE
                        binding.tvItemInfo.text = "대여 가능 수량 : $remainNumber / $rentalPeriod"
                        binding.tvItemBorrowedState.visibility = View.GONE
                    }

                    if(remainNumber == 0) {
                        binding.tvItemAvailable.visibility = View.GONE
                        binding.tvItemReservation.visibility = View.GONE
                        binding.tvItemStateDisavailable.visibility = View.VISIBLE
                    }

                    binding.root.setOnClickListener {
                        reservationClickListener(item)
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserReservationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}