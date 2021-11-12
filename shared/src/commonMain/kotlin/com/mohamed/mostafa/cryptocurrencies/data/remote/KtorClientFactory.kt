package com.mohamed.mostafa.cryptocurrencies.data.remote

import io.ktor.client.*

expect class KtorClientFactory {

    fun build(): HttpClient
}