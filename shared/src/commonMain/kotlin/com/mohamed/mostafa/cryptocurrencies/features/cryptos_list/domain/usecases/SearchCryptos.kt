package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.usecases

import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.models.SearchSort
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.repository.CryptosRepository
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter


class SearchCryptos(
    private val repository: CryptosRepository,
) {
    suspend operator fun invoke(query: String, sort: SearchSort): List<Crypto> {
        return repository.searchCryptos(query, sort)
    }
}