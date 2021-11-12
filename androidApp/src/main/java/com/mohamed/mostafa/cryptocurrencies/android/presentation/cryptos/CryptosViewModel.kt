package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.mostafa.cryptocurrencies.data.remote.ApiService.Constants.PAGINATION_PER_PAGE_COUNT
import com.mohamed.mostafa.cryptocurrencies.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.domain.usecases.GetCryptosUseCase
import com.mohamed.mostafa.cryptocurrencies.presentation.cryptos.CryptosIntent
import com.mohamed.mostafa.cryptocurrencies.presentation.cryptos.CryptosState
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptosViewModel @Inject constructor(
    private val getCryptosUseCase: GetCryptosUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {


    val state: MutableState<CryptosState> = mutableStateOf(CryptosState())


    fun onTriggerIntent(intent: CryptosIntent) {
        when (intent) {
            is CryptosIntent.GetCryptos -> {
                getCryptos()
            }
            is CryptosIntent.GetNextPage -> {
                getNextPage()
            }
        }
    }

    init {
        onTriggerIntent(CryptosIntent.GetCryptos)
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