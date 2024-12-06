package com.example.bankapp.domain.usecase

import com.example.bankapp.domain.repository.AccountRepository
import kotlinx.coroutines.flow.first

class GetAccountUseCase(
    private val repository: AccountRepository
) {
    suspend fun execute() = repository.getAccounts().first()
}