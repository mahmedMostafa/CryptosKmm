package com.mohamed.mostafa.cryptocurrencies.core.datasource.remote

import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.CryptoDto


interface ApiService {

    suspend fun getCryptos(
        page: Int,
        perPage: Int = PAGINATION_PER_PAGE_COUNT
    ): ArrayList<CryptoDto>


    companion object Constants {
        const val BASE_URL = "https://api.coingecko.com/api/v3/"
        const val PAGINATION_PER_PAGE_COUNT = 30
    }
}