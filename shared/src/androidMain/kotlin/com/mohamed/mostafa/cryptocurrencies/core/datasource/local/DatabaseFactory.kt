package com.mohamed.mostafa.cryptocurrencies.core.datasource.local

import android.content.Context
import com.mohamed.mostafa.cryptocurrencies.data.cache.CryptosDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(CryptosDatabase.Schema, context, "cryptos.db")
    }
}