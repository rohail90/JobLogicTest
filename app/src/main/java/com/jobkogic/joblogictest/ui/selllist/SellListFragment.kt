package com.jobkogic.joblogictest.ui.selllist
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jobkogic.joblogictest.MainApp
import com.jobkogic.joblogictest.databinding.FragmentCalllistLayoutBinding
import com.jobkogic.joblogictest.databinding.FragmentSellListLayoutBinding
import com.jobkogic.joblogictest.roomdb.getDatabase
import com.jobkogic.joblogictest.ui.buylist.BuyListViewModel
import com.jobkogic.joblogictest.users.BuyListResponse
import com.jobkogic.joblogictest.users.CallListResponse
import com.redcloudtechnology.red101marketplace.red101_marketplace_features.modules.cart.adapters.BuyListAdapter
import com.redcloudtechnology.red101marketplace.red101_marketplace_features.modules.cart.adapters.CallListAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
class SellListFragment : Fragment() {
    private lateinit var binding: FragmentSellListLayoutBinding
    private val sellListViewModel: SellListViewModel by viewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSellListLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerviewVisibility()
        initObserver()
    }

    private fun recyclerviewVisibility() {
        sellListViewModel.loading.observe(viewLifecycleOwner, Observer {
            binding.showProgressbar.visibility = if (it) View.VISIBLE else View.GONE
        })
    }

    private fun initObserver () {
        sellListViewModel.getAllData()
        sellListViewModel.userList.observe(viewLifecycleOwner) { listUser ->
            binding.recyclerviewSellList.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = BuyListAdapter(listUser, context);
            }
        }
    }
}