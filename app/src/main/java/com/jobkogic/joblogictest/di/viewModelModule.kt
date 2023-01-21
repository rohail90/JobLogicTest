package com.jobkogic.joblogictest.di

import com.jobkogic.joblogictest.ui.calllist.CallListViewModel
import com.jobkogic.joblogictest.ui.home.HomeViewModel
import com.jobkogic.joblogictest.ui.buylist.BuyListViewModel
import com.jobkogic.joblogictest.ui.selllist.SellListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CallListViewModel(get()) }
    viewModel { HomeViewModel()}
    viewModel { BuyListViewModel(get()) }
    viewModel { SellListViewModel() }
}

