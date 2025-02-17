package com.example.bankapp.domain.repository

import com.example.bankapp.data.model.Account

interface AccountRepository {
    fun getAccounts(): List<Account>
}