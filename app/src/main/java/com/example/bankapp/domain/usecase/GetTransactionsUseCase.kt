package com.example.bankapp.domain.usecase

import com.example.bankapp.data.model.Transaction
import com.example.bankapp.domain.repository.TransactionRepository

class GetTransactionsUseCase(
    private val repository: TransactionRepository
) {
    fun execute(accountId: String): List<Transaction> = repository.getTransactions(accountId)
}