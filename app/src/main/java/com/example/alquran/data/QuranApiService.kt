package com.example.alquran.data

import model.SurahResponse
import model.SurahDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface QuranApiService {

    @GET("surah")
    suspend fun getSurahList(): Response<SurahResponse>

    @GET("surah/{id}")
    suspend fun getSurahDetail(
        @Path("id") surahId: Int
    ): Response<SurahDetailResponse>

}
