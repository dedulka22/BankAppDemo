package com.example.bankapp.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bankapp.ui.view.AccountScreen
import com.example.bankapp.ui.view.TransactionDetailScreen
import com.example.bankapp.ui.view.TransactionScreen
import com.example.bankapp.ui.viewmodel.AccountViewModel
import com.example.bankapp.ui.viewmodel.TransactionDetailViewModel
import com.example.bankapp.ui.viewmodel.TransactionViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    accountViewModel: AccountViewModel,
    transactionViewModel: TransactionViewModel,
    transactionDetailViewModel: TransactionDetailViewModel
) {
    NavHost(navController = navController, startDestination = "accounts") {
        composable("accounts") {
            AccountScreen(accountViewModel) { account ->
                navController.navigate("account/${account.accountId}")
            }
        }
        composable("account/{accountId}") { backStackEntry ->
            val accountId = backStackEntry.arguments?.getString("accountId")
            Log.d("NavGraph", "Navigating to account with ID: $accountId")
            if (accountId != null) {
                TransactionScreen(
                    accountId = accountId,
                    onClickItem = { transaction ->
                        navController.navigate("transactionDetail/${transaction.transactionId}")
                    },
                    viewModel = transactionViewModel,
                    onBack = { navController.popBackStack() }
                )
            } else {
                Log.e("NavGraph", "accountId is null")
            }
        }
        composable("transactionDetail/{transactionId}") { backStackEntry ->
            val transactionId = backStackEntry.arguments?.getString("transactionId")
            Log.d("NavGraph", "Navigating to transaction detail with ID: $transactionId")
            if (transactionId != null) {
                TransactionDetailScreen(
                    viewModel = transactionDetailViewModel,
                    transactionId = transactionId,
                    onBack = { navController.popBackStack() }
                )
            } else {
                Log.e("NavGraph", "transactionId is null")
            }
        }
    }
}