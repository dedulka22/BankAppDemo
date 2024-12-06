package com.example.bankapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val accountId: String,
    val accountName: String,
    val accountType: String,
    val balance: Double,
    val currency: String
)
