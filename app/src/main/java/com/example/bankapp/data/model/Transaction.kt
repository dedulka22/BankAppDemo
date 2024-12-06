package com.example.bankapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Transaction(
    val transactionId: String,
    val accountId: String,
    val date: String,
    val amount: Double,
    val description: String,
    val category: String,
    val transactionType: String
)
