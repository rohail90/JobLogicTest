package com.jobkogic.joblogictest

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.jobkogic.joblogictest.di.RetrofitModule
import com.jobkogic.joblogictest.di.apiModule
import com.jobkogic.joblogictest.di.repositoryModule
import com.jobkogic.joblogictest.di.viewModelModule
import com.jobkogic.joblogictest.roomdb.AppDatabase
import com.jobkogic.joblogictest.utility.Constant
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MainApp : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: MainApp
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
       context = applicationContext
        if(Constant.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApp)
            modules(listOf(
                //databaseModule,
                viewModelModule,
                apiModule,
                repositoryModule,
                RetrofitModule
            ))

        }
        instance = this
    }
    fun getAppContext(): Context {
        return context
    }
}