package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.mappers

import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.CryptoDto
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto


fun CryptoDto.toDomainModel(): Crypto {
    return Crypto(
        id = id,
        name = name,
        image = image,
        currentPrice = currentPrice,
        marketCapRank = marketCapRank,
        marketCap = marketCap,
    )
}

fun ArrayList<CryptoDto>.toDomainList(): List<Crypto> {
    return map { it.toDomainModel() }
}