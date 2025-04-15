package surah

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alquran.databinding.ItemVerseBinding
import data.model.Verse

class VerseAdapter : RecyclerView.Adapter<VerseAdapter.VerseViewHolder>() {

    private val list = ArrayList<Verse>()

    fun submitList(newList: List<Verse>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class VerseViewHolder(private val binding: ItemVerseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(verse: Verse) {
            binding.tvArabic.text = verse.text
            binding.tvVerseNumber.text = verse.numberInSurah.toString()


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseViewHolder {
        val binding = ItemVerseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VerseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VerseViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}
