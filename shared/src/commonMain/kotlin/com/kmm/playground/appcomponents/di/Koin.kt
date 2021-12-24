package com.kmm.playground.appcomponents.di

import com.kmm.playground.appcomponents.data.remote.CryptoApi
import com.kmm.playground.appcomponents.data.repository.CryptoRepository
import com.kmm.playground.appcomponents.data.repository.UserRepository
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(commonModule())
    }

fun initKoin() = initKoin() {}

fun commonModule() = module {
    single { UserRepository() }

    single { CryptoRepository() }
    single { CryptoApi(get()) }

    single { createJson() }
    single { createHttpClient(get()) }
}

fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }

fun createHttpClient(json: Json) = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer(json)
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.INFO
    }
}
