package com.mohamed.mostafa.cryptocurrencies.core.datasource.remote

import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.CryptoDetailDto
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.CryptoDto
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.EventsResponse
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.EventTypeDto


interface ApiService {

    suspend fun getCryptos(
        page: Int,
        perPage: Int = PAGINATION_PER_PAGE_COUNT
    ): ArrayList<CryptoDto>

    suspend fun getCryptoDetail(
        id: String
    ): CryptoDetailDto

    suspend fun getEventTypes(): EventTypeDto

    suspend fun getEvents(
        eventType: String,
    ): EventsResponse

    companion object Constants {
        const val BASE_URL = "https://api.coingecko.com/api/v3/"
        const val PAGINATION_PER_PAGE_COUNT = 30
    }
}