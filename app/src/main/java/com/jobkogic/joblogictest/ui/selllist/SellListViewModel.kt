package com.jobkogic.joblogictest.ui.selllist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jobkogic.joblogictest.MainApp
import com.jobkogic.joblogictest.repository.UsersRepository
import com.jobkogic.joblogictest.roomdb.getDatabase
import com.jobkogic.joblogictest.users.BuyListResponse
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.io.IOException

class SellListViewModel() : ViewModel() {
    val userList = MutableLiveData<List<BuyListResponse>>()
    val loading = MutableLiveData<Boolean>()
    fun getAllData(){
        loading.postValue(true)
        GlobalScope.launch {
            val result = getDatabase(MainApp.context).appDao().getAllDataSet()
            userList.postValue(result)
            loading.postValue(false)
        }
    }
}