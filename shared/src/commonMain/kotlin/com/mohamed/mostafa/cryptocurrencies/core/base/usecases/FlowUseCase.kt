package com.mohamed.mostafa.cryptocurrencies.core.base.usecases

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

abstract class FlowUseCase<T, in Params> where T : Any {

    abstract suspend fun buildUseCase(params: Params? = null): T

    fun invoke(
        params: Params? = null,
        onLoading: (isLoading: Boolean) -> Unit,
        onError: (message: String) -> Unit
    ) = flow {
        val data = buildUseCase(params)
        emit(data)
    }.catch { t -> onError(t.message.toString()) }
        .onStart { onLoading(true) }
        .onCompletion { onLoading(false) }
}