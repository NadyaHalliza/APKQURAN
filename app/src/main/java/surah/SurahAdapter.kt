package ui.surah

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alquran.databinding.ItemSurahBinding

import model.Surah

class SurahAdapter(
    private val onItemClick: (Surah) -> Unit
) : RecyclerView.Adapter<SurahAdapter.SurahViewHolder>() {

    private val list = ArrayList<Surah>()

    fun submitList(newList: List<Surah>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class SurahViewHolder(private val binding: ItemSurahBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(surah: Surah) {
            binding.tvSurahName.text = "${surah.number}. ${surah.englishNameTranslation}"
            binding.tvSurahArabic.text = surah.name


            // 🔥 Navigasi ke detail
            binding.root.setOnClickListener {
                onItemClick.invoke(surah)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val binding = ItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SurahViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}
