package com.example.starship.service

import com.example.starship.client.SwapiClient
import com.example.starship.dto.StarshipResponse
import com.example.starship.model.Starship
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class StarshipServiceTest {

    private lateinit var swapiClient: SwapiClient
    private lateinit var starshipService: StarshipService

    @BeforeEach
    fun setUp() {
        swapiClient = mock()
        starshipService = StarshipService(swapiClient)
    }

    @Test
    fun `should return top ten most expensive starships sorted by cost`() {
        val starships = listOf(
            createStarship(name = "Medium expensive", costInCredits = "200"),
            createStarship(name = "Most expensive", costInCredits = "300"),
            createStarship(name = "Least Expensive", costInCredits = "100")
        )

        val spaceshipResponse = StarshipResponse(results = starships)
        whenever(swapiClient.getStarships()).thenReturn(spaceshipResponse)

        val result = starshipService.getTopTenMostExpensiveStarships()

        assertEquals(3, result.size)
        assertEquals("Most expensive", result[0].name)
        assertEquals("300", result[0].costInCredits)
        assertEquals("Medium expensive", result[1].name)
        assertEquals("200", result[1].costInCredits)
        assertEquals("100", result[2].costInCredits)
        assertEquals("Least Expensive", result[2].name)

    }

    @Test
    fun `should return empty list when no starships are found`() {
        whenever(swapiClient.getStarships()).thenReturn(StarshipResponse(results = emptyList()))

        val result = starshipService.getTopTenMostExpensiveStarships()

        assertTrue(result.isEmpty())
    }

    @Test
    fun `should filter out unknown costInCredits`() {
        val starships = listOf(
            createStarship(name = "Has cost", costInCredits = "1000"),
            createStarship(name = "No cost", costInCredits =  "unknown")
        )

        val starshipResponse = StarshipResponse(results = starships)
        whenever(swapiClient.getStarships()).thenReturn(starshipResponse)

        val result = starshipService.getTopTenMostExpensiveStarships()

        assertEquals(1, result.size)
        assertEquals("Has cost", result[0].name)
        assertEquals("1000", result[0].costInCredits)
    }

    private fun createStarship(
        name: String = "Default Starship",
        model: String = "Default Model",
        manufacturer: String = "Default Manufacturer",
        costInCredits: String = "0",
        length: String = "0",
        maxAtmospheringSpeed: String = "n/a",
        amountOfCrewMembers: String = "0",
        passengers: String = "0",
        cargoCapacity: String = "0",
        consumables: String = "0",
        hyperdriveRating: String = "0.0",
        mglt: String = "0",
        starshipClass: String = "Default Class",
        pilots: List<String> = emptyList(),
        films: List<String> = emptyList(),
        created: String = "1970-01-01T00:00:00.000000Z",
        edited: String = "1970-01-01T00:00:00.000000Z",
        url: String = "https://example.com"
    ): Starship {
        return Starship(
            name = name,
            model = model,
            manufacturer = manufacturer,
            costInCredits = costInCredits,
            length = length,
            maxAtmospheringSpeed = maxAtmospheringSpeed,
            amountOfCrewMembers = amountOfCrewMembers,
            passengers = passengers,
            cargoCapacity = cargoCapacity,
            consumables = consumables,
            hyperdriveRating = hyperdriveRating,
            mglt = mglt,
            starshipClass = starshipClass,
            pilots = pilots,
            films = films,
            created = created,
            edited = edited,
            url = url
        )
    }
}

