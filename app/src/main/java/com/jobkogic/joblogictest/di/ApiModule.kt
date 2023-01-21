package com.jobkogic.joblogictest.di
import com.jobkogic.joblogictest.requests.UserServices
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(UserServices::class.java) }
}