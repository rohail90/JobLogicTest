package com.redcloudtechnology.red101marketplace.red101_marketplace_features.modules.cart.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.jobkogic.joblogictest.databinding.BuyListRvLayoutBinding
import com.jobkogic.joblogictest.databinding.CallListRvLayoutBinding
import com.jobkogic.joblogictest.users.BuyListResponse
import com.jobkogic.joblogictest.users.CallListResponse

class BuyListAdapter(private val splitExtendList: List<BuyListResponse>, var context: Context) :
    RecyclerView.Adapter<BuyListAdapter.MyViewHolder>() {

    inner class MyViewHolder(val viewDataBinding: BuyListRvLayoutBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyListAdapter.MyViewHolder {
        val binding =
            BuyListRvLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyListAdapter.MyViewHolder, position: Int) {
        holder.viewDataBinding.idNumber.text = splitExtendList[position].id.toString()
        holder.viewDataBinding.userName.text = splitExtendList[position].name
        holder.viewDataBinding.quantity.text = splitExtendList[position].quantity.toString()
        holder.viewDataBinding.type.text = splitExtendList[position].type.toString()
    }

    override fun getItemCount(): Int {
        return splitExtendList.size
    }
}