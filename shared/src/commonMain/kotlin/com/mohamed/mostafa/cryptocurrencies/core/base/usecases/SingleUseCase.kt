package com.mohamed.mostafa.cryptocurrencies.core.base.usecases

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class SingleUseCase<Type, in Params> where Type : Any {

    abstract suspend fun buildUseCase(params: Params? = null): Type

    suspend fun invoke(
        params: Params? = null,
        onSuccess: (data: Type) -> Unit,
        onLoading: (isLoading: Boolean) -> Unit,
        onError: ((message: String) -> Unit)? = null,
    ) {
        onLoading(true)
        try {
            val data = buildUseCase(params)
            onSuccess(data)
        } catch (t: Throwable) {
            t.printStackTrace()
            onError?.invoke(t.message.toString())//TODO Error Handling
        } finally {
            onLoading(false)
        }
    }
}