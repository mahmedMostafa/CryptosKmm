package com.mohamed.mostafa.cryptocurrencies.core.datasource.remote


import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService.Constants.BASE_URL
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.CryptoDetailDto
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.CryptoDto
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.EventTypeDto
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.EventsResponse
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

    override suspend fun getCryptoDetail(id: String): CryptoDetailDto {
        return httpClient.get {
            url("$BASE_URL/coins/$id")
            parameter("localization", false)
            parameter("tickers", false)
            parameter("community_data", false)
            parameter("developer_data", false)
            parameter("sparkline", false)
        }
    }

    override suspend fun getEventTypes(): EventTypeDto {
        return httpClient.get {
            url("$BASE_URL/events/types")
        }
    }

    override suspend fun getEvents(eventType: String): EventsResponse {
        return httpClient.get {
            url("$BASE_URL/events")
            parameter("type", eventType)
        }
    }
}