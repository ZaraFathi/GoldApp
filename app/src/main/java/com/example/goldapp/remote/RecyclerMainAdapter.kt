package com.example.goldapp.remote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.goldapp.databinding.RecyclerMainItemBinding
import com.example.goldapp.remote.detaModel.ContentModel

class RecyclerMainAdapter(
    private val allData: ArrayList<ContentModel>,
    private val images: List<Int>
) : RecyclerView.Adapter<RecyclerMainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            RecyclerMainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = allData.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setData(data = allData[position], image = images[position])
    }

    inner class MainViewHolder(
        private val binding: RecyclerMainItemBinding
    ) : ViewHolder(binding.root) {

        fun setData(data: ContentModel, image: Int) {
            binding.txtLabel.text = data.label
            binding.txtPrice.text = formatNumberWithCommas((data.price / 10).toString())
            binding.imageView3.setImageDrawable(
                ContextCompat.getDrawable(binding.imageView3.context, image)
            )
        }

        fun formatNumberWithCommas(number: String): String {
            val reversedNumber = number.reversed()
            val chunkedReversedNumber = reversedNumber.chunked(3).joinToString(",")
            return chunkedReversedNumber.reversed()
        }
    }

}