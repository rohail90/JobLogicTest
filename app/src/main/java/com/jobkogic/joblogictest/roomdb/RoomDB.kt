package com.jobkogic.joblogictest.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jobkogic.joblogictest.dao.AppDao
import com.jobkogic.joblogictest.users.BuyListResponse

@Database(entities = [BuyListResponse::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun appDao(): AppDao
}

private lateinit var INSTANCE : AppDatabase

fun getDatabase(context: Context): AppDatabase {
    synchronized(AppDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "database"
            ).build()
        }
    }

    return INSTANCE
}