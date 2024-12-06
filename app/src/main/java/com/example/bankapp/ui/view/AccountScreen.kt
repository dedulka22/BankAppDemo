package com.example.bankapp.ui.view

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.data.model.Account
import com.example.bankapp.ui.viewmodel.AccountViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(
    viewModel: AccountViewModel,
    onAccountClick: (Account) -> Unit
) {
    val accounts by viewModel.accounts.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bank Accounts", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0D47A1))
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            items(accounts) { account ->
                AccountItem(
                    account = account,
                    onClick = onAccountClick
                )
            }
        }
    }
}

@Composable
fun AccountItem(
    account: Account,
    onClick: (Account) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFBBDEFB)),
        onClick = { onClick(account) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = account.accountName,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 20.sp,
                    color = Color(0xFF0D47A1)
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Type: ${account.accountType}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFF0D47A1)
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Balance: ${account.balance} ${account.currency}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFF0D47A1)
                )
            )
        }
    }
}