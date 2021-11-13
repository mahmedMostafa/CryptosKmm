package com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.domain.mappers

import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.CryptoDetailDto
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto

fun CryptoDetailDto.toDomainModel(): Crypto {
    return Crypto(
        id = id,
        name = name,
        description = description,
        currentPrice = currentPrice?.usd,
        image = image,
        marketCap = marketCap?.usd,
        marketCapRank = marketCapRank,
    )
}