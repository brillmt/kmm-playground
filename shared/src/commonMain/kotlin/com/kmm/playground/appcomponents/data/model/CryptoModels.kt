package com.kmm.playground.appcomponents.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CryptoCoin(
    val id: String,
    val symbol: String,
    val name: String
)

@Serializable
data class CryptoResponse(val data: List<CryptoCoin>)