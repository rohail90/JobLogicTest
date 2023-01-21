package com.jobkogic.joblogictest.ui.home

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.jobkogic.joblogictest.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
  private lateinit var binding: FragmentHomeBinding
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    binding = FragmentHomeBinding.inflate(inflater, container, false)
    binding.callList.setOnClickListener {
     findNavController().navigate(com.jobkogic.joblogictest.R.id.home_to_call_list)
    }

    binding.buyList.setOnClickListener {
      findNavController().navigate(com.jobkogic.joblogictest.R.id.home_to_buy_list)
    }

    binding.sellList.setOnClickListener({
      findNavController().navigate(com.jobkogic.joblogictest.R.id.home_to_sell_list)
    })

    return binding.root
  }
}