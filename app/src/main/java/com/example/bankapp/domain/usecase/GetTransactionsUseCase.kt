package com.example.bankapp.domain.usecase

import com.example.bankapp.data.model.Transaction
import com.example.bankapp.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.first

class GetTransactionsUseCase(
    private val repository: TransactionRepository
) {
    suspend fun execute(accountId: String): List<Transaction> = repository.getTransactions(accountId).first()
}