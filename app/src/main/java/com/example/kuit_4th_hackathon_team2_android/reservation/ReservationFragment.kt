package com.example.kuit_4th_hackathon_team2_android.reservation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit_4th_hackathon_team2_android.R
import com.example.kuit_4th_hackathon_team2_android.databinding.FragmentReservationBinding

class ReservationFragment : Fragment() {

    private lateinit var binding: FragmentReservationBinding
    private lateinit var reservationRVAdapter: ReservationRVAdapter
    private val reservationItem = arrayListOf<ReservationData>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReservationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initReservationItem()
        initReservationRVAdapter()
    }

    private fun initReservationRVAdapter() {
        reservationRVAdapter = ReservationRVAdapter(requireContext(), reservationItem)
        with(binding.rvReservation) {
            adapter = reservationRVAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }


    private fun initReservationItem() {
        reservationItem.addAll(
            arrayListOf(
                ReservationData(
                    "1",
                    "우산",
                    30,
                    40
                ),
                ReservationData(
                    "2",
                    "C타입 충전기",
                    0,
                    40
                ),
                ReservationData(
                    "3",
                    "노트북 거치대",
                    0,
                    40
                ),
                ReservationData(
                    "4",
                    "휴지",
                    0,
                    40
                ),
                ReservationData(
                    "5",
                    "보조배터리",
                    10,
                    40
                )
            )
        )
    }

}