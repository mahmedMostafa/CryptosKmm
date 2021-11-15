package com.mohamed.mostafa.cryptocurrencies.android.di

import com.mohamed.mostafa.cryptocurrencies.core.datasource.local.cryptos.CryptoDao
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService
import com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.data.repository.CryptoDetailRepositoryImpl
import com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.domain.repository.CryptoDetailRepository
import com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.domain.usecases.GetCryptoDetailUseCase
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.data.repository.CryptoRepositoryImpl
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.repository.CryptosRepository
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.usecases.GetCryptosUseCase
import com.mohamed.mostafa.cryptocurrencies.features.events.data.repository.EventsRepositoryImpl
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.repository.EventsRepository
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases.GetEventTypes
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases.GetEvents
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
    fun provideCryptoDetailRepository(
        apiService: ApiService,
        cryptoCache: CryptoDao
    ): CryptoDetailRepository {
        return CryptoDetailRepositoryImpl(apiService, cryptoCache)
    }

    @Provides
    @ViewModelScoped
    fun provideEventsRepository(
        apiService: ApiService
    ): EventsRepository {
        return EventsRepositoryImpl(apiService)
    }


    @Provides
    @ViewModelScoped
    fun provideGetEventsUseCase(repository: EventsRepository): GetEvents {
        return GetEvents(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetEventTypesUseCase(repository: EventsRepository): GetEventTypes {
        return GetEventTypes(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetCryptosUseCase(repository: CryptosRepository): GetCryptosUseCase {
        return GetCryptosUseCase(repository)
    }


    @Provides
    @ViewModelScoped
    fun provideGetCryptoDetailUseCase(repository: CryptoDetailRepository): GetCryptoDetailUseCase {
        return GetCryptoDetailUseCase(repository)
    }
}