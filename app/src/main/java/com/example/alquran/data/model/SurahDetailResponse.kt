package model

import com.example.alquran.data.model.Verse

data class SurahDetailResponse(
    val code: Int,
    val status: String,
    val data: SurahDetail
)

data class SurahDetail(
    val number: Int,
    val name: String,
    val englishName: String,
    val englishNameTranslation: String,
    val numberOfAyahs: Int,
    val revelationType: String,
    val ayahs: List<Verse> // pakai Verse dari data.model
)
