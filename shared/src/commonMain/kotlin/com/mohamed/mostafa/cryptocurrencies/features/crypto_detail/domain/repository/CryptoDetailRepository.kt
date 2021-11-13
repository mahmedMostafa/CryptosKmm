package com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.domain.repository

import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto

interface CryptoDetailRepository {

    suspend fun getCryptoDetail(id: String): Crypto
}