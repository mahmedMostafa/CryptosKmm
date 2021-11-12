package com.mohamed.mostafa.cryptocurrencies.core.datasource.remote


import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService.Constants.BASE_URL
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.CryptoDto
import io.ktor.client.*
import io.ktor.client.request.*

class ApiServiceImpl(
    private val httpClient: HttpClient,
) : ApiService {

    override suspend fun getCryptos(page: Int, perPage: Int): ArrayList<CryptoDto> {
        return httpClient.get {
            url("$BASE_URL/coins/markets?sparkline=true")
            parameter("vs_currency", "usd")
            parameter("order", "market_cap_desc")
            parameter("page", page)
            parameter("per_page", perPage)
        }
    }
}