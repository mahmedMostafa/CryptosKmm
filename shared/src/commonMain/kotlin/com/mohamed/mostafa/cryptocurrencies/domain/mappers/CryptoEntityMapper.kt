package com.mohamed.mostafa.cryptocurrencies.domain.mappers

import com.mohamed.mostafa.cryptocurrencies.data.cache.Crypto_Entity
import com.mohamed.mostafa.cryptocurrencies.domain.models.Crypto


fun Crypto_Entity.toDomainModel(): Crypto {
    return Crypto(
        id = id,
        name = name,
        description = description,
        marketCapRank = marketCapRank.toInt(),
        image = image,
    )
}

fun List<Crypto_Entity>.toDomainList(): List<Crypto> {
    return map { it.toDomainModel() }
}