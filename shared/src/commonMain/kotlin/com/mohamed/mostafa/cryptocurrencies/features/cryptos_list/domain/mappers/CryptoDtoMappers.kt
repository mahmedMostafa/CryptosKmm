package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.mappers

import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.CryptoDto
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.PriceState

fun CryptoDto.toDomainModel(): Crypto {
    return Crypto(
        id = id,
        name = name,
        image = image,
        currentPrice = currentPrice,
        marketCapRank = marketCapRank,
        marketCap = marketCap,
        priceState = priceChange24h.toPriceState()
    )
}

fun Double?.toPriceState(): PriceState {
    if (this == null) return PriceState.STILL
    return if (this >= 0) PriceState.DID_GO_UP
    else PriceState.DID_GO_DOWN
}

fun ArrayList<CryptoDto>.toDomainList(): List<Crypto> {
    return map { it.toDomainModel() }
}