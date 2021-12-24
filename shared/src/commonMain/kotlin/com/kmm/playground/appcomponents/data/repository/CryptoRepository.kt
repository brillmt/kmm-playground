package com.kmm.playground.appcomponents.data.repository

import com.kmm.playground.appcomponents.data.model.CryptoResponse
import com.kmm.playground.appcomponents.data.remote.CryptoApi
import com.kmm.playground.appcomponents.util.CommonFlow
import com.kmm.playground.appcomponents.util.asCommonFlow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CryptoRepository : KoinComponent {
    private val cryptoApi: CryptoApi by inject()

    fun getCoins(): CommonFlow<CryptoResponse> {
        return flow {
            try {
                emit(cryptoApi.fetchAll())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.asCommonFlow()
    }
}
/**


IMPLEMENT DATABASE

 **/