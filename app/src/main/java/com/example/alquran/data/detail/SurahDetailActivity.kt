package com.example.alquran.data.detail
// Update test dari Ghilman

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alquran.databinding.ActivityDetailBinding
import Repository
import ui.surah.SurahViewModel
import ui.surah.SurahViewModelFactory
import surah.VerseAdapter
import com.example.alquran.data.api.RetrofitClient
import com.example.alquran.R

class SurahDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: SurahViewModel by viewModels {
        SurahViewModelFactory(Repository(RetrofitClient.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val surahId = intent.getIntExtra("surah_id", 1)

        val adapter = VerseAdapter()
        binding.rvVerses.layoutManager = LinearLayoutManager(this)
        binding.rvVerses.adapter = adapter

        viewModel.verses.observe(this) {
            adapter.submitList(it)

        }

        viewModel.fetchVerses(surahId)

        // Di SurahDetailActivity.kt
        viewModel.surahDetail.observe(this) {
            binding.tvSurahTitle.text = it.englishNameTranslation
        }


    }
}
