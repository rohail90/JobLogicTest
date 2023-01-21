package com.redcloudtechnology.red101marketplace.red101_marketplace_features.modules.cart.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.jobkogic.joblogictest.databinding.CallListRvLayoutBinding
import com.jobkogic.joblogictest.users.CallListResponse

class CallListAdapter(private val splitExtendList: List<CallListResponse>, var context: Context) :
    RecyclerView.Adapter<CallListAdapter.MyViewHolder>() {

    inner class MyViewHolder(val viewDataBinding: CallListRvLayoutBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallListAdapter.MyViewHolder {
        val binding =
            CallListRvLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CallListAdapter.MyViewHolder, position: Int) {
        holder.viewDataBinding.idNumber.text = splitExtendList[position].id.toString()
        holder.viewDataBinding.userName.text = splitExtendList[position].name.toString()
        holder.viewDataBinding.userNumber.text = splitExtendList[position].userNumber.toString()
    }

    override fun getItemCount(): Int {
        return splitExtendList.size
    }
}