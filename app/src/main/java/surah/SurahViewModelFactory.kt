package ui.surah

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import Repository

class SurahViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SurahViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SurahViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
