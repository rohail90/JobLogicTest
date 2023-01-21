package com.jobkogic.joblogictest.requests
import com.jobkogic.joblogictest.users.BuyListResponse
import com.jobkogic.joblogictest.users.CallListResponse
import com.redcloudtechnology.red101marketplace.red101_marketplace_features.network.api.EndPoints
import retrofit2.http.GET
import retrofit2.http.Headers
interface UserServices {
    @Headers("Accept: application/json")
    @GET(EndPoints.CALL_LIST_DATA)
    suspend fun callListUsers(): List<CallListResponse>

    @GET(EndPoints.BUY_LIST_DATA)
    suspend fun buyListUsers(): List<BuyListResponse>
}