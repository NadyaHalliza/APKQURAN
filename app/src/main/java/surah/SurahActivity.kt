package ui.surah

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alquran.databinding.ActivitySurahBinding
import Repository
import data.detail.SurahDetailActivity
import data.api.RetrofitClient
import ui.surah.SurahAdapter
import ui.surah.SurahViewModel
import ui.surah.SurahViewModelFactory

class SurahActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySurahBinding
    private lateinit var adapter: SurahAdapter

    private val viewModel: SurahViewModel by viewModels {
        SurahViewModelFactory(Repository(RetrofitClient.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔥 Adapter dengan klik listener
        adapter = SurahAdapter { surah ->
            val intent = Intent(this, SurahDetailActivity::class.java)
            intent.putExtra("surah_id", surah.number)
            startActivity(intent)
        }

        binding.rvSurah.layoutManager = LinearLayoutManager(this)
        binding.rvSurah.adapter = adapter

        viewModel.surahList.observe(this) {
            adapter.submitList(it)
        }

        viewModel.isLoading.observe(this) {
            binding.progressBar.visibility = if (it) android.view.View.VISIBLE else android.view.View.GONE
        }

        viewModel.fetchSurahs()
    }
}
