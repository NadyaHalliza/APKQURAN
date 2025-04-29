package com.example.alquran.data.model

data class VerseResponse(
    val verses: List<Verse>
)

data class Translation(
    val text: String,
    val language_name: String
)
