package com.example.bankapp.domain.repository

import com.example.bankapp.data.model.Transaction
import kotlinx.coroutines.flow.Flow


interface TransactionRepository {
    fun getTransactions(accountId: String): Flow<List<Transaction>>
}