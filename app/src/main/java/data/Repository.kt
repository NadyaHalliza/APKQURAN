import data.QuranApiService
import model.SurahDetailResponse
import model.SurahResponse

class Repository(private val api: QuranApiService) {

    suspend fun getSurahList(): SurahResponse? {
        val response = api.getSurahList()
        return if (response.isSuccessful) response.body() else null
    }

    suspend fun getSurahDetail(id: Int): SurahDetailResponse? {
        val response = api.getSurahDetail(id)
        return if (response.isSuccessful) response.body() else null
    }
}
