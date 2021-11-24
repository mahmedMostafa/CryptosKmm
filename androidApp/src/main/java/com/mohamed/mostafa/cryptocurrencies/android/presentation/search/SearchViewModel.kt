package com.mohamed.mostafa.cryptocurrencies.android.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.models.SearchSort
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.usecases.SearchCryptos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@FlowPreview
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchCryptos: SearchCryptos,
) : ViewModel() {

    val sortState = MutableStateFlow<SearchSort>(SearchSort.ByPrice)
    val queryState = MutableStateFlow("")

    val cryptos = combine(
        sortState,
        queryState
            .filter { it.isNotBlank() }
            .debounce(500)
            .distinctUntilChanged()
    ) { sort, query ->
        println("triggered a new search")
        searchCryptos.invoke(query, sort)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList(),
    )

    fun onDoneClick() {
        //only reset the states to trigger the search again
        queryState.value = queryState.value
    }

    fun onQueryChange(query: String) {
        queryState.value = query
    }
}