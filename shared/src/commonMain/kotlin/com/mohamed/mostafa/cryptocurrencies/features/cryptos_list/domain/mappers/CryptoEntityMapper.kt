package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.mappers

import com.mohamed.mostafa.cryptocurrencies.data.cache.Crypto_Entity
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.PriceState


fun Crypto_Entity.toDomainModel(): Crypto {
    return Crypto(
        id = id,
        name = name,
        symbol = symbol,
        description = description,
        marketCapRank = marketCapRank.toInt(),
        image = image,
        isFavorite = isFavorite,
        priceState = PriceState.valueOf(priceState)
    )
}

fun List<Crypto_Entity>.toDomainList(): List<Crypto> {
    return map { it.toDomainModel() }
}