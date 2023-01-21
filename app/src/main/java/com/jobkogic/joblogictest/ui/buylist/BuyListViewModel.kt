package com.jobkogic.joblogictest.ui.buylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jobkogic.joblogictest.MainApp
import com.jobkogic.joblogictest.repository.UsersRepository
import com.jobkogic.joblogictest.roomdb.getDatabase
import com.jobkogic.joblogictest.users.BuyListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class BuyListViewModel(private val usersRepository: UsersRepository) : ViewModel() {
    val userList = MutableLiveData<List<BuyListResponse>>()
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    fun buyGetUserList () {
        loading.postValue(true)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = usersRepository.repoBuyListUser()
                    insertData(result)
                    userList.postValue(result)
                    loading.postValue(false)
                } catch (throwable: Throwable) {
                    when (throwable) {
                        is IOException -> {
                            errorMessage.postValue("Network Error")
                        }
                        is HttpException -> {
                            val codeError = throwable.code()
                            val errorMessageResponse = throwable.message()
                            errorMessage.postValue("Error $errorMessageResponse : $codeError")
                        }
                        else -> {
                            errorMessage.postValue("Uknown error")
                        }
                    }
                }
            }
        }
    }

    fun insertData(model: List<BuyListResponse>){
        GlobalScope.launch {
            getDatabase(MainApp.context).appDao().insertItems(model)
        }
    }
}