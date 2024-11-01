package com.example.starship.dto

import com.example.starship.model.Starship

data class StarshipResponse(
    val results: List<Starship>
)