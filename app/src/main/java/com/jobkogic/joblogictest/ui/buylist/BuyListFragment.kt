package com.jobkogic.joblogictest.ui.buylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jobkogic.joblogictest.databinding.FragmentBuylistLayoutBinding
import com.redcloudtechnology.red101marketplace.red101_marketplace_features.modules.cart.adapters.BuyListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class BuyListFragment : Fragment() {

  private val buyListViewModel: BuyListViewModel by viewModel()
  private lateinit var binding: FragmentBuylistLayoutBinding
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    binding = FragmentBuylistLayoutBinding.inflate(inflater, container, false)
    return binding.root
  }
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    initObserver()
    recyclerviewVisibility()
  }

  private fun recyclerviewVisibility() {
    buyListViewModel.loading.observe(viewLifecycleOwner, Observer {
      binding.showProgressbar.visibility = if (it) View.VISIBLE else View.GONE
    })
  }

  private fun initObserver () {
    buyListViewModel.buyGetUserList()
    buyListViewModel.userList.observe(viewLifecycleOwner) { listUser ->
      binding.recyclerviewBuyList.apply {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = BuyListAdapter(listUser, context);
      }
    }
  }
}