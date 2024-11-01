package com.example.starship.client

import com.example.starship.dto.StarshipResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException

@Component
class SwapiClient(
    webClientBuilder: WebClient.Builder,
    @Value("\${swapi.url}") private val url: String
) {

    private val log = LoggerFactory.getLogger(SwapiClient::class.java)
    private val webClient: WebClient = webClientBuilder.build()

    fun getStarships(): StarshipResponse? {
        return try {
            webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(StarshipResponse::class.java)
                .block()
        } catch (e: WebClientResponseException) {
            log.error("Error fetching starships from SWAPI at $url", e)
            null
        }
    }
}
