package com.jobkogic.joblogictest.users
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CallListResponse (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String? = null,
    @SerializedName("number") val userNumber : String? = null,
)
@Entity
data class BuyListResponse (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String? = null,
    @SerializedName("quantity") val quantity : Int,
    @SerializedName("type") val type : Int,
)


//data class GetListResponseLocal (
//    @PrimaryKey(autoGenerate = true)
//    val Id:Int,
//    val name:String?,
//    val quantity: Int?,
//    val type: Int?)