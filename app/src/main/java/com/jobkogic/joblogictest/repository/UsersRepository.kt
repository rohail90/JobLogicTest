package com.jobkogic.joblogictest.repository
import com.jobkogic.joblogictest.requests.UserServices

class UsersRepository(private val userServices: UserServices) {
    suspend fun repoGetListUsers() = userServices.callListUsers()
    suspend fun repoBuyListUser() = userServices.buyListUsers()
}