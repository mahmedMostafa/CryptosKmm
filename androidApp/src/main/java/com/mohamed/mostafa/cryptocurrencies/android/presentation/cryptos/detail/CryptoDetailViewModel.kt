package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.domain.usecases.GetCryptoDetailUseCase
import com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.presentation.CryptoDetailIntents
import com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.presentation.CryptoDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val getCryptoDetailUseCase: GetCryptoDetailUseCase,
    private val saveStateHandle: SavedStateHandle,
) : ViewModel() {

    val state = mutableStateOf(CryptoDetailState())

    init {
        saveStateHandle.get<String>("cryptoId")?.let { id ->
            println("Crypto id is $id")
            onTriggerIntent(CryptoDetailIntents.GetCryptoDetail(id))
        }
    }

    fun onTriggerIntent(intent: CryptoDetailIntents) {
        when (intent) {

            is CryptoDetailIntents.GetCryptoDetail -> {
                getCryptoDetail(id = intent.id)
            }
        }
    }

    private fun getCryptoDetail(id: String) = viewModelScope.launch {
        getCryptoDetailUseCase.invoke(
            params = id,
            onLoading = { isLoading ->
                state.value = state.value.copy(isLoading = isLoading)
            },
            onSuccess = { crypto ->
                state.value = state.value.copy(crypto = crypto)
            },
            onError = { message ->
                state.value = state.value.copy(errorMessage = message)
            }
        )
    }
}