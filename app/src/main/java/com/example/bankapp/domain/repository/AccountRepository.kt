package com.example.bankapp.domain.repository

import com.example.bankapp.data.model.Account
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    fun getAccounts(): Flow<List<Account>>
}