package com.example.alquran

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.alquran.databinding.ActivityMainBinding
import com.example.alquran.data.api.RetrofitClient
import kotlinx.coroutines.launch
import model.SurahResponse

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "API_RESULT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSurahList()
    }

    private fun getSurahList() {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.apiService.getSurahList()
                if (response.isSuccessful) {
                    val body: SurahResponse? = response.body()
                    val surahList = body?.data ?: emptyList()
                    Log.d(TAG, "Jumlah Surah: ${surahList.size}")
                    for (surah in surahList) {
                        Log.d(TAG, "${surah.number} - ${surah.name} (${surah.englishNameTranslation})")
                    }
                } else {
                    Log.e(TAG, "Gagal: ${response.code()} - ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception: ${e.message}")
            }
        }
    }
}
