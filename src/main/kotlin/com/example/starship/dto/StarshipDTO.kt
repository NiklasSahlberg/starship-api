package com.example.starship.dto

data class StarshipDTO(
    val name: String,
    val model: String,
    val costInCredits: String,
    val crew: String,
    val pilots: List<String>
)