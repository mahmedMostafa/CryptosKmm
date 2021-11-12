package com.mohamed.mostafa.cryptocurrencies.data.local

import com.mohamed.mostafa.cryptocurrencies.data.cache.CryptosDatabase
import com.squareup.sqldelight.db.SqlDriver


expect class DriverFactory {
    fun createDriver(): SqlDriver
}

class DatabaseFactory(
    private val driverFactory: DriverFactory
) {
    fun createCryptosDatabase(): CryptosDatabase {
        return CryptosDatabase(driverFactory.createDriver())
    }
}