package com.example.bankapp.data.repository

import com.example.bankapp.data.model.Account
import kotlinx.serialization.json.Json
import android.content.Context
import com.example.bankapp.domain.repository.AccountRepository
import com.example.bankapp.utils.readJsonFromAssets


class AccountRepositoryImpl(private val context: Context) : AccountRepository {

    override fun getAccounts(): List<Account> =
        Json.decodeFromString(readJsonFromAssets(context, "accounts.json"))
}