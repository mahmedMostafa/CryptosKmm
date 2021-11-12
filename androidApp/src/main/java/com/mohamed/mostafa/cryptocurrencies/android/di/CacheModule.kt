package com.mohamed.mostafa.cryptocurrencies.android.di

import com.mohamed.mostafa.cryptocurrencies.android.MyApplication
import com.mohamed.mostafa.cryptocurrencies.data.cache.CryptosDatabase
import com.mohamed.mostafa.cryptocurrencies.core.datasource.local.DatabaseFactory
import com.mohamed.mostafa.cryptocurrencies.core.datasource.local.DriverFactory
import com.mohamed.mostafa.cryptocurrencies.core.datasource.local.cryptos.CryptoDao
import com.mohamed.mostafa.cryptocurrencies.core.datasource.local.cryptos.CryptosDaoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideCryptosDatabase(context: MyApplication): CryptosDatabase {
        return DatabaseFactory(driverFactory = DriverFactory(context)).createCryptosDatabase()
    }

    @Singleton
    @Provides
    fun provideCryptosCache(cryptosDatabase: CryptosDatabase): CryptoDao {
        return CryptosDaoImpl(cryptosDatabase)
    }
}