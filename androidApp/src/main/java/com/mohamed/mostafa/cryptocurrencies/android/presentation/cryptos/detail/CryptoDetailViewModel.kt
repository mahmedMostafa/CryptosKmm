package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val state: SavedStateHandle,
) : ViewModel() {

    init {
        state.get<String>("cryptoId")?.let { id ->
            println("Crypto id is $id")
        }
    }
}