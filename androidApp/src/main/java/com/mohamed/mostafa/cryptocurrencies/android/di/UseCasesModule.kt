package com.mohamed.mostafa.cryptocurrencies.android.di

import com.mohamed.mostafa.cryptocurrencies.data.local.cryptos.CryptoDao
import com.mohamed.mostafa.cryptocurrencies.data.remote.ApiService
import com.mohamed.mostafa.cryptocurrencies.data.repository.CryptoRepositoryImpl
import com.mohamed.mostafa.cryptocurrencies.domain.repository.CryptosRepository
import com.mohamed.mostafa.cryptocurrencies.domain.usecases.GetCryptosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.ktor.client.*


@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {


    @Provides
    @ViewModelScoped
    fun provideCryptosRepository(
        apiService: ApiService,
        cryptoCache: CryptoDao
    ): CryptosRepository {
        return CryptoRepositoryImpl(apiService, cryptoCache)
    }

    @Provides
    @ViewModelScoped
    fun provideGetCryptosUseCase(repository: CryptosRepository): GetCryptosUseCase {
        return GetCryptosUseCase(repository)
    }
}