package com.mohamed.mostafa.cryptocurrencies.domain.mappers

import com.mohamed.mostafa.cryptocurrencies.data.remote.models.CryptoDto
import com.mohamed.mostafa.cryptocurrencies.domain.models.Crypto


fun CryptoDto.toDomainModel(): Crypto {
    return Crypto(
        id = id,
        name = name,
        image = image,
        currentPrice = currentPrice,
        marketCapRank = marketCapRank
    )
}

fun ArrayList<CryptoDto>.toDomainList(): List<Crypto> {
    return map { it.toDomainModel() }
}