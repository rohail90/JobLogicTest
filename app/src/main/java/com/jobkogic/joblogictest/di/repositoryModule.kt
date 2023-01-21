package com.jobkogic.joblogictest.di

import com.jobkogic.joblogictest.repository.UsersRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { UsersRepository(get()) }
}