package com.example.bankapp.domain.usecase

import com.example.bankapp.data.model.TransactionDetail
import com.example.bankapp.domain.repository.TransactionDetailRepository
import kotlinx.coroutines.flow.first

class GetTransactionDetailUseCase(
    private val repository: TransactionDetailRepository
) {
    suspend fun execute(transactionId: String): TransactionDetail =
        repository.getTransactionDetail(transactionId).first()
}