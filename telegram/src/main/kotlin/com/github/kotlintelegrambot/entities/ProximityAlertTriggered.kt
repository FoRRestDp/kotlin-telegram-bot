package com.github.kotlintelegrambot.entities

public data class ProximityAlertTriggered(
    val traveler: User,
    val watcher: User,
    val distance: Int
)
