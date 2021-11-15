package com.mohamed.mostafa.cryptocurrencies.shared.domain.usecases

import com.mohamed.mostafa.cryptocurrencies.core.base.usecases.SingleUseCase
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.repository.CryptosRepository

class AddOrRemoveFromFavorites constructor(
    private val repository: CryptosRepository,
) {

    suspend operator fun invoke(id: String) {
        repository.addOrRemoveFromFavorites(id)
    }
}