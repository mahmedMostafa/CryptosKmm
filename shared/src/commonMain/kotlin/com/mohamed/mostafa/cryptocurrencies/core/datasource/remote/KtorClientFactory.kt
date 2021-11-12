package com.mohamed.mostafa.cryptocurrencies.core.datasource.remote

import io.ktor.client.*

expect class KtorClientFactory {

    fun build(): HttpClient
}