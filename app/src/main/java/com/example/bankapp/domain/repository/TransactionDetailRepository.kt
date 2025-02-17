package com.example.bankapp.domain.repository

import com.example.bankapp.data.model.TransactionDetail

interface TransactionDetailRepository {
    fun getTransactionDetail(transactionId: String): TransactionDetail?
}