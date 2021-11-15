package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService.Constants.PAGINATION_PER_PAGE_COUNT
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.usecases.GetCryptosUseCase
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.presentation.cryptos.CryptosActions
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.presentation.cryptos.CryptosState
import com.mohamed.mostafa.cryptocurrencies.shared.domain.usecases.AddOrRemoveFromFavorites
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptosViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getCryptosUseCase: GetCryptosUseCase,
    private val addOrRemoveFromFavorites: AddOrRemoveFromFavorites,
) : ViewModel() {


    val state: MutableState<CryptosState> = mutableStateOf(CryptosState())


    fun onTriggerIntent(actions: CryptosActions) {
        when (actions) {
            is CryptosActions.GetCryptos -> {
                getCryptos()
            }
            is CryptosActions.GetNextPage -> {
                getNextPage()
            }
            is CryptosActions.AddOrRemoveFromFavorites -> {
                addOrRemoveFromFavorites(actions.id)
            }
        }
    }

    init {
        onTriggerIntent(CryptosActions.GetCryptos)
    }

    private fun getNextPage() {
        if (state.value.hasReachedMax) return
        state.value = state.value.copy(page = state.value.page.plus(1))
        getCryptos()
    }

    private fun getCryptos() = viewModelScope.launch {
        getCryptosUseCase.invoke(
            params = state.value.page,
            onLoading = { isLoading ->
                if (state.value.page == 1)
                    state.value = state.value.copy(isLoading = isLoading, errorMessage = null)
                else
                    state.value = state.value.copy(isLoadingMore = isLoading, errorMessage = null)
            },
            onSuccess = { cryptos ->
                println("GEMY Cryptos are $cryptos")
                addCryptos(cryptos)
            },
            onError = { message ->
                state.value = state.value.copy(errorMessage = message)
            }
        )
    }

    private fun addOrRemoveFromFavorites(id: String) = viewModelScope.launch {
        addOrRemoveFromFavorites.invoke(id)
    }

    private fun addCryptos(newCryptos: List<Crypto>) {
        if (newCryptos.size < PAGINATION_PER_PAGE_COUNT) {
            state.value = state.value.copy(hasReachedMax = true)
        }
        val cryptos = ArrayList(state.value.cryptos)
        cryptos.addAll(newCryptos)
        state.value = state.value.copy(cryptos = cryptos)
        println("new Cryptos are " + state.value.cryptos.size.toString())
    }
}