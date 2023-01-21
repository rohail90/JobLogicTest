package com.jobkogic.joblogictest.ui.home
import androidx.lifecycle.*
import com.jobkogic.joblogictest.repository.UsersRepository
import com.jobkogic.joblogictest.users.CallListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class HomeViewModel() : ViewModel() {
    val userList = MutableLiveData<List<CallListResponse>>()
    val errorMessage = MutableLiveData<String>()

}