package com.kmm.playground.appcomponents.data.remote

import com.kmm.playground.appcomponents.data.model.CryptoResponse
import io.ktor.client.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent

private const val BASE_URL = "https://api.coinlore.net/api/tickers"

class CryptoApi(
    private val client: HttpClient
) : KoinComponent {

    suspend fun fetchAll() = client.get<CryptoResponse>(BASE_URL)
}
