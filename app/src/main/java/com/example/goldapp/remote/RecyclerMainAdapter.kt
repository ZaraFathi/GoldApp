package com.example.goldapp.remote

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.goldapp.databinding.RecyclerMainItemBinding


class RecyclerMainAdapter (

):RecyclerView.Adapter<RecyclerMainAdapter.MainViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

   inner class MainViewHolder(
    private val binding:RecyclerMainItemBinding
):ViewHolder(binding.root){

    fun getData(){

    }
}

}