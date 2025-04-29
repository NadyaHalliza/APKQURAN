package ui.surah

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import Repository
import model.SurahDetailResponse
import com.example.alquran.data.model.Verse
import kotlinx.coroutines.launch
import model.Surah
import model.SurahDetail

class SurahViewModel(private val repository: Repository) : ViewModel() {

    private val _verses = MutableLiveData<List<Verse>>()
    val verses: LiveData<List<Verse>> get() = _verses

    fun fetchVerses(surahId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getSurahDetail(surahId)
                response?.let {
                    _verses.value = it.data.ayahs
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    private val _surahList = MutableLiveData<List<Surah>>()
    val surahList: LiveData<List<Surah>> get() = _surahList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _surahDetail = MutableLiveData<SurahDetail>() // bukan SurahDetailResponse
    val surahDetail: LiveData<SurahDetail> get() = _surahDetail


    fun fetchSurahDetail(surahId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getSurahDetail(surahId)
                response?.let {
                    _surahDetail.value = it.data // ✅

                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    fun fetchSurahs() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val data = repository.getSurahList()
                _surahList.value = data?.data ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}