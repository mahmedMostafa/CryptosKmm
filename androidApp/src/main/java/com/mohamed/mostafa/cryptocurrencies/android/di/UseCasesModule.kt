package com.mohamed.mostafa.cryptocurrencies.android.di

import com.mohamed.mostafa.cryptocurrencies.core.datasource.local.cryptos.CryptoDao
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.data.repository.CryptoRepositoryImpl
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.repository.CryptosRepository
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.usecases.GetCryptosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


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