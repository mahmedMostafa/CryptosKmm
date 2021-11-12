package com.mohamed.mostafa.cryptocurrencies.domain.repository

import com.mohamed.mostafa.cryptocurrencies.domain.models.Crypto

interface CryptosRepository {

    suspend fun getCryptos(page : Int): List<Crypto>
}