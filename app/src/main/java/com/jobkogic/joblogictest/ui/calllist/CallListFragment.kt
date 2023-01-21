package com.jobkogic.joblogictest.ui.calllist
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jobkogic.joblogictest.databinding.FragmentCalllistLayoutBinding
import com.redcloudtechnology.red101marketplace.red101_marketplace_features.modules.cart.adapters.CallListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class CallListFragment : Fragment() {

    private val callListViewModel: CallListViewModel by viewModel()
    private lateinit var binding: FragmentCalllistLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalllistLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initObserver()
        recyclerviewVisibility()
    }

    private fun recyclerviewVisibility() {
        callListViewModel.loading.observe(viewLifecycleOwner, Observer {
            binding.showProgressbar.visibility = if (it) View.VISIBLE else View.GONE
        })
    }

    private fun initObserver () {
        callListViewModel.vmGetUserList()
        callListViewModel.userList.observe(viewLifecycleOwner) { listUser ->
            binding.recyclerview.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = CallListAdapter(listUser, context);
            }
        }
    }
}