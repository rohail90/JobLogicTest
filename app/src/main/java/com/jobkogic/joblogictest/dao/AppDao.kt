package com.jobkogic.joblogictest.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jobkogic.joblogictest.users.BuyListResponse

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertItems(getUserRewardPointResponse: List<BuyListResponse>)

    @Query("SELECT * FROM BuyListResponse")
    fun getAllDataSet(): List<BuyListResponse>

}