package com.example.bankapp.data.repository

import com.example.bankapp.data.model.Account
import kotlinx.serialization.json.Json
import android.content.Context
import com.example.bankapp.domain.repository.AccountRepository
import com.example.bankapp.utils.readJsonFromAssets
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AccountRepositoryImpl(private val context: Context) : AccountRepository {

    override fun getAccounts(): Flow<List<Account>> = flow {
        val jsonString: String = readJsonFromAssets(context, "accounts.json")

        val accounts: List<Account> = Json.decodeFromString(jsonString)
        emit(accounts)
    }
}