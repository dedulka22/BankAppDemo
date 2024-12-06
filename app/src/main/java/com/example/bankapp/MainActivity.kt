package com.example.bankapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.bankapp.ui.navigation.NavGraph
import com.example.bankapp.ui.viewmodel.AccountViewModel
import com.example.bankapp.ui.viewmodel.TransactionDetailViewModel
import com.example.bankapp.ui.viewmodel.TransactionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val accountViewModel: AccountViewModel by viewModel()
    private val transactionViewModel: TransactionViewModel by viewModel()
    private val transactionDetailViewModel: TransactionDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Surface(color = MaterialTheme.colorScheme.background) {
                NavGraph(
                    navController = navController,
                    accountViewModel = accountViewModel,
                    transactionViewModel = transactionViewModel,
                    transactionDetailViewModel = transactionDetailViewModel
                )
            }
        }
    }
}