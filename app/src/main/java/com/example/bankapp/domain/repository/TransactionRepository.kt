package com.example.bankapp.domain.repository

import com.example.bankapp.data.model.Transaction


interface TransactionRepository {
    fun getTransactions(accountId: String): List<Transaction>
}