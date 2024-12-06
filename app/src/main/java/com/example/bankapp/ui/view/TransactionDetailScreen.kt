package com.example.bankapp.ui.view

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.data.model.TransactionDetail
import com.example.bankapp.ui.viewmodel.TransactionDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionDetailScreen(
    viewModel: TransactionDetailViewModel,
    transactionId: String,
    onBack: () -> Unit
) {
    val transactionDetail by viewModel.transactionDetail.collectAsState()

    LaunchedEffect(transactionId) {
        viewModel.getTransactionDetail(transactionId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Transaction Detail", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0D47A1))
            )
        }
    ) { paddingValues ->
        transactionDetail?.let { TransactionDetailContent(it, paddingValues) }
    }
}

@Composable
fun TransactionDetailContent(
    transactionDetail: TransactionDetail,
    paddingValues: PaddingValues
) {
    var expanded by remember { mutableStateOf(false) }
    val cardElevation by animateDpAsState(
        targetValue = if (expanded) 8.dp else 4.dp,
        animationSpec = tween(durationMillis = 300)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
            .background(Color.White)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
                .clickable { expanded = !expanded },
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
                    text = "Transaction ID: ${transactionDetail.transactionId}",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 20.sp,
                        color = Color(0xFF0D47A1),
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                DetailRow(label = "Amount", value = "${transactionDetail.amount}")
                DetailRow(label = "Date", value = transactionDetail.date)
                DetailRow(label = "Description", value = transactionDetail.description)
                DetailRow(label = "Category", value = transactionDetail.category)
                DetailRow(label = "Transaction Type", value = transactionDetail.transactionType)
                DetailRow(label = "Merchant Name", value = transactionDetail.merchantName)
                DetailRow(label = "Location", value = transactionDetail.location)
                DetailRow(label = "Payment Method", value = transactionDetail.paymentMethod)
            }
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label:",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0D47A1)
            )
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color(0xFF0D47A1)
            )
        )
    }
}