package com.example.bankapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TransactionDetail(
    val transactionId: String,
    val date: String,
    val amount: Double,
    val description: String,
    val category: String,
    val transactionType: String,
    val merchantName: String,
    val location: String,
    val paymentMethod: String
)
