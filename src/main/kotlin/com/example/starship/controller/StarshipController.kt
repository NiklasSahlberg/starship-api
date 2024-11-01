package com.example.starship.controller

import com.example.starship.dto.StarshipDTO
import com.example.starship.service.StarshipService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/starships")
class StarshipController(private val starshipService: StarshipService) {

    @GetMapping("most-expensive")
    fun getMostExpensiveStarships():ResponseEntity<List<StarshipDTO>> {
        val starships = starshipService.getTopTenMostExpensiveStarships()
        return if (starships.isNotEmpty()) {
            ResponseEntity.ok(starships)
        } else {
            ResponseEntity.noContent().build()
        }
    }
}