package com.example.bankapp.ui.view

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.data.model.Transaction
import com.example.bankapp.ui.viewmodel.TransactionViewModel
import com.example.bankapp.utils.formatDateString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionScreen(
    accountId: String,
    onClickItem: (Transaction) -> Unit,
    viewModel: TransactionViewModel,
    onBack: () -> Unit,
) {
    val transactions by viewModel.getTransactionsForAccount(accountId).collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Transactions for Account ID: $accountId", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0D47A1))
            )
        }
    ) { paddingValues ->
        when {
            transactions.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No transactions found for account ID: $accountId",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            else -> {
                LazyColumn(
                    contentPadding = paddingValues,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    items(transactions) { transaction ->
                        TransactionItem(
                            transaction = transaction,
                            onClickItem = onClickItem
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TransactionItem(
    transaction: Transaction,
    onClickItem: (Transaction) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val cardElevation by animateDpAsState(
        targetValue = if (expanded) 8.dp else 4.dp,
        animationSpec = tween(durationMillis = 300)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClickItem(transaction) }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(cardElevation),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFBBDEFB))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = transaction.description,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 20.sp,
                        color = Color(0xFF0D47A1),
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Category: ${transaction.category}",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFF0D47A1)
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Amount: ${transaction.amount} (${transaction.transactionType})",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = if (transaction.transactionType == "Credit")
                            Color(0xFF0D47A1)
                        else
                            Color(0xFFD32F2F)
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Date: ${transaction.date.formatDateString()}",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFF0D47A1)
                    )
                )
            }
        }
    }
}