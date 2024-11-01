package com.example.starship

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpaceshipApiApplication

fun main(args: Array<String>) {
	runApplication<SpaceshipApiApplication>(*args)
}
