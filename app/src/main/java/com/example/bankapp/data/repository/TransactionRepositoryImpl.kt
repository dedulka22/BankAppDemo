package com.example.bankapp.data.repository

import android.content.Context
import com.example.bankapp.data.model.Transaction
import com.example.bankapp.domain.repository.TransactionRepository
import com.example.bankapp.utils.readJsonFromAssets
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class TransactionRepositoryImpl(private val context: Context): TransactionRepository {

    override fun getTransactions(accountId: String): Flow<List<Transaction>> = flow {
        val jsonString: String = readJsonFromAssets(context, "transactions.json")

        val allTransactions: List<Transaction> = Json.decodeFromString(jsonString)
        val filteredTransactions = allTransactions.filter { it.accountId == accountId }
        emit(filteredTransactions)
    }
}