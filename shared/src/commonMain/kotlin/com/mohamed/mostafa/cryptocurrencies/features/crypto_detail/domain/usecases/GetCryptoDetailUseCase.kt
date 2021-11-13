package com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.domain.usecases

import com.mohamed.mostafa.cryptocurrencies.core.base.usecases.SingleUseCase
import com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.domain.repository.CryptoDetailRepository
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto

class GetCryptoDetailUseCase(
    private val repository: CryptoDetailRepository,
) : SingleUseCase<Crypto, String>() {

    override suspend fun buildUseCase(params: String?): Crypto {
        return repository.getCryptoDetail(params ?: "")
    }
}