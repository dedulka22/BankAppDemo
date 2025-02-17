package com.example.bankapp.domain.usecase

import com.example.bankapp.data.model.TransactionDetail
import com.example.bankapp.domain.repository.TransactionDetailRepository

class GetTransactionDetailUseCase(
    private val repository: TransactionDetailRepository
) {
    fun execute(transactionId: String): TransactionDetail? =
        repository.getTransactionDetail(transactionId)
}