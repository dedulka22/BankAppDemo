package com.example.bankapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankapp.data.model.TransactionDetail
import com.example.bankapp.domain.usecase.GetTransactionDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TransactionDetailViewModel(
    private val getTransactionDetailUseCase: GetTransactionDetailUseCase
) : ViewModel() {

    private val _transactionDetail = MutableStateFlow<TransactionDetail?>(null)
    val transactionDetail: StateFlow<TransactionDetail?> = _transactionDetail

    fun getTransactionDetail(transactionId: String) {
        viewModelScope.launch {
            _transactionDetail.value = getTransactionDetailUseCase.execute(transactionId)
        }
    }
}