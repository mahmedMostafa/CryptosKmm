package com.mohamed.mostafa.cryptocurrencies.domain.usecases

import com.mohamed.mostafa.cryptocurrencies.core.base.usecases.SingleUseCase
import com.mohamed.mostafa.cryptocurrencies.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.domain.repository.CryptosRepository
import kotlinx.coroutines.delay

class GetCryptosUseCase(
    private val repository: CryptosRepository
) : SingleUseCase<List<Crypto>, Int>() {

    override suspend fun buildUseCase(params: Int?): List<Crypto> {
        delay(1000)//Just to test the loading
        return repository.getCryptos(page = params ?: 1)
    }
}