package com.example.starship.controller

import com.example.starship.dto.StarshipDTO
import com.example.starship.service.StarshipService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@ExtendWith(SpringExtension::class)
@WebMvcTest(StarshipController::class)
class StarshipControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var starshipService: StarshipService

    @Test
    fun `should return top 10 most expensive spaceships`() {
        val mockStarships = listOf(
            StarshipDTO(name = "Expensive Ship 1", costInCredits = "5000000", crew = "10", model = "death star", pilots = emptyList()),
            StarshipDTO(name = "Expensive Ship 2", costInCredits = "4000000", crew = "15", model = "mega death star", pilots = emptyList()),
            StarshipDTO(name = "Expensive Ship 3", costInCredits = "3000000", crew = "25", model = "super mega death star", pilots = emptyList()),
        )

        whenever(starshipService.getTopTenMostExpensiveStarships()).thenReturn(mockStarships)

        mockMvc.get("/api/v1/starships/most-expensive")
            .andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    jsonPath("$.size()") { value(3) }
                    jsonPath("$[0].name") { value("Expensive Ship 1") }
                    jsonPath("$[1].name") { value("Expensive Ship 2") }
                    jsonPath("$[2].name") { value ("Expensive Ship 3") }
                }
            }
    }

    @Test
    fun `should return no content when no starships available`() {
        whenever(starshipService.getTopTenMostExpensiveStarships()).thenReturn(emptyList())

        mockMvc.get("/api/v1/starships/most-expensive")
            .andExpect {
                status { isNoContent() }
            }
    }
}
