package com.example.bankapp.di

import com.example.bankapp.data.repository.AccountRepositoryImpl
import com.example.bankapp.data.repository.TransactionDetailRepositoryImpl
import com.example.bankapp.data.repository.TransactionRepositoryImpl
import com.example.bankapp.domain.repository.AccountRepository
import com.example.bankapp.domain.repository.TransactionDetailRepository
import com.example.bankapp.domain.repository.TransactionRepository
import com.example.bankapp.domain.usecase.GetAccountUseCase
import com.example.bankapp.domain.usecase.GetTransactionDetailUseCase
import com.example.bankapp.domain.usecase.GetTransactionsUseCase
import com.example.bankapp.ui.viewmodel.AccountViewModel
import com.example.bankapp.ui.viewmodel.TransactionDetailViewModel
import com.example.bankapp.ui.viewmodel.TransactionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    factoryOf(::AccountRepositoryImpl) bind AccountRepository::class
    single { GetAccountUseCase(get()) }
    viewModel { AccountViewModel(get()) }

    factoryOf(::TransactionRepositoryImpl) bind TransactionRepository::class
    single { GetTransactionsUseCase(get()) }
    viewModel { TransactionViewModel(get()) }

    factoryOf(::TransactionDetailRepositoryImpl) bind TransactionDetailRepository::class
    single { GetTransactionDetailUseCase(get()) }
    viewModel { TransactionDetailViewModel(get()) }

}