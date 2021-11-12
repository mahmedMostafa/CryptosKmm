package com.mohamed.mostafa.cryptocurrencies.core.datasource.local

import com.mohamed.mostafa.cryptocurrencies.data.cache.CryptosDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(CryptosDatabase.Schema, "cryptos.db")
    }
}