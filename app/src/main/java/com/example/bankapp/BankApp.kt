package com.example.bankapp

import android.app.Application
import com.example.bankapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BankApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BankApp)
            modules(appModule)
        }
    }
}