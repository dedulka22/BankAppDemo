package com.example.bankapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankapp.data.model.Transaction
import com.example.bankapp.domain.usecase.GetTransactionsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TransactionViewModel(
    private val getTransactionsUseCase: GetTransactionsUseCase
) : ViewModel() {

    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions

    fun getTransactionsForAccount(accountId: String): Flow<List<Transaction>> {
        viewModelScope.launch {
            _transactions.value = getTransactionsUseCase.execute(accountId)
        }
        return transactions
    }
}