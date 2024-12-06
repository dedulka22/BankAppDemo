package com.example.bankapp.domain.repository

import com.example.bankapp.data.model.TransactionDetail
import kotlinx.coroutines.flow.Flow

interface TransactionDetailRepository {
    fun getTransactionDetail(transactionId: String): Flow<TransactionDetail>
}