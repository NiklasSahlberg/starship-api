package com.example.starship.service

import com.example.starship.client.SwapiClient
import com.example.starship.dto.StarshipDTO
import com.example.starship.model.Starship
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class StarshipService(private val swapiClient: SwapiClient) {

    private val log = LoggerFactory.getLogger(StarshipService::class.java)

    fun getTopTenMostExpensiveStarships(): List<StarshipDTO> {
        return try {
            val response = swapiClient.getStarships() ?: run {
                log.warn("Received null response from SwapiClient")
                return emptyList()
            }

            response.results
                .filter { it.costInCredits != "unknown" }
                .sortedByDescending { it.costInCredits.toLong() }
                .take(10)
                .map { mapToStarshipDTO(it) }
        } catch (e: Exception) {
            log.error("Error fetching starships", e)
            emptyList()
        }
    }

    private fun mapToStarshipDTO(starship: Starship): StarshipDTO {
        return StarshipDTO(
            name = starship.name,
            model = starship.model,
            costInCredits = starship.costInCredits,
            crew = starship.amountOfCrewMembers,
            pilots = starship.pilots
        )
    }
}
