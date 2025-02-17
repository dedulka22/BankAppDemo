package com.example.bankapp.domain.usecase

import com.example.bankapp.domain.repository.AccountRepository

class GetAccountUseCase(
    private val repository: AccountRepository
) {
    fun execute() = repository.getAccounts()
}