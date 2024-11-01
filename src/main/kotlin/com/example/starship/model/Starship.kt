package com.example.starship.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Starship(
    @JsonProperty("name") val name: String,
    @JsonProperty("model") val model: String,
    @JsonProperty("manufacturer") val manufacturer: String,
    @JsonProperty("cost_in_credits") val costInCredits: String,
    @JsonProperty("length") val length: String,
    @JsonProperty("max_atmosphering_speed") val maxAtmospheringSpeed: String,
    @JsonProperty("crew") val amountOfCrewMembers: String,
    @JsonProperty("passengers") val passengers: String,
    @JsonProperty("cargo_capacity") val cargoCapacity: String,
    @JsonProperty("consumables") val consumables: String,
    @JsonProperty("hyperdrive_rating") val hyperdriveRating: String,
    @JsonProperty("MGLT") val mglt: String,
    @JsonProperty("starship_class") val starshipClass: String,
    @JsonProperty("pilots") val pilots: List<String>,
    @JsonProperty("films") val films: List<String>,
    @JsonProperty("created") val created: String,
    @JsonProperty("edited") val edited: String,
    @JsonProperty("url") val url: String
)
