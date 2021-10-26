package com.example.demo.client

import com.example.demo.model.Boleto
import kotlinx.coroutines.suspendCancellableCoroutine
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

object BoletoClient {

    val client = WebClient
        .builder()
        .baseUrl("https://dff8335c-88c3-457a-abf9-ba9d05938cf1.mock.pstmn.io")
        .build()

    suspend fun getPagamentos() = client
        .get()
        .uri("/api/pagamentos")
        .retrieve()
        .bodyToMono<List<Boleto>>().await()
}

suspend fun <T> Mono<T>.await(): T = suspendCancellableCoroutine { coroutine ->
    this.doOnSuccess {
        coroutine.resume(it)
    }.doOnError {
        coroutine.resumeWithException(it)
    }.subscribe()
}