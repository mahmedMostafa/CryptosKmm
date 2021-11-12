package com.mohamed.mostafa.cryptocurrencies.android.di


import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiServiceImpl
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.KtorClientFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideRecipeService(
        httpClient: HttpClient,
    ): ApiService {
        return ApiServiceImpl(
            httpClient = httpClient,
        )
    }
}