package data.model

data class VerseResponse(
    val verses: List<data.model.Verse>
)

data class Translation(
    val text: String,
    val language_name: String
)
