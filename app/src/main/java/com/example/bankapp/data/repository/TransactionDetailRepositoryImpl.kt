package com.example.bankapp.data.repository

import android.content.Context
import com.example.bankapp.data.model.TransactionDetail
import com.example.bankapp.domain.repository.TransactionDetailRepository
import com.example.bankapp.utils.readJsonFromAssets
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class TransactionDetailRepositoryImpl(private val context: Context) : TransactionDetailRepository {

    override fun getTransactionDetail(transactionId: String): Flow<TransactionDetail> = flow {
        val jsonString: String = readJsonFromAssets(context, "transactionDetail.json")

        val allTransactions: List<TransactionDetail> = Json.decodeFromString(jsonString)
        val transactionDetail = allTransactions.find { it.transactionId == transactionId }
            ?: throw NoSuchElementException("Transaction with ID $transactionId not found")

        emit(transactionDetail)
    }
}