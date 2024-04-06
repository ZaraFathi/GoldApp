package com.example.goldapp

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goldapp.databinding.ActivityMainBinding
import com.example.goldapp.remote.RecyclerMainAdapter
import com.example.goldapp.remote.detaModel.ContentModel
import com.example.goldapp.remote.detaModel.DateModel
import com.example.goldapp.remote.detaModel.GoldModel
import com.example.goldapp.remote.golds.GoldApiRepository
import com.example.goldapp.remote.golds.GoldRequest
import com.example.goldapp.remote.time.TimeApiRepository
import com.example.goldapp.remote.time.TimeRequest


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val goldPrice = ArrayList<ContentModel>()
    private val currencyPrice = ArrayList<ContentModel>()
    private val goldImages = listOf(
        R.drawable.ic_104,
        R.drawable.ic_104,
        R.drawable.ic_104,
        R.drawable.ic_104,
        R.drawable.ic_104,
    )
    private val currencyImages = listOf(
        R.drawable.ic_dolar,
        R.drawable.ic_uro,
        R.drawable.ic_derham,
        R.drawable.ic_pond,
    )
    private fun updateWidget() {
        val widgetManager = AppWidgetManager.getInstance(this)
        val widgetIds = widgetManager.getAppWidgetIds(ComponentName(this, SimpleWidgetProvider::class.java))
        SimpleWidgetProvider().onUpdate(this, widgetManager, widgetIds)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateWidget()
        TimeApiRepository.instance.getTime(
            object : TimeRequest {
                override fun onSuccess(data: DateModel) {
                    val date = data.date
                    val text = "${date.l_value} ${date.j_value} ${date.F_value} ${date.Y_value}"
                    binding.txtTime.text = text
                }

                override fun onNotSuccess(message: String) {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }

                override fun onError(error: String) {
                    Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
                }
            }
        )
        getPrice()

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        binding.txtArz.setOnClickListener {
            binding.txtArz.setTextColor(Color.parseColor("#E7C376"))
            binding.txtGold.setTextColor(Color.parseColor("#787879"))
            setData(currencyPrice)
        }
        binding.txtGold.setOnClickListener {
            binding.txtArz.setTextColor(Color.parseColor("#787879"))
            binding.txtGold.setTextColor(Color.parseColor("#E7C376"))
            setData(goldPrice)
        }
    }

    private fun getPrice() {
        GoldApiRepository.instance.getGold(
            object : GoldRequest {
                override fun onSuccess(data: GoldModel) {
                    goldPrice.addAll(data.data.golds)
                    currencyPrice.addAll(data.data.currencies)
                    setData(goldPrice)
                }

                override fun onNotSuccess(message: String) {
                }

                override fun onError(error: String) {
                    Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    private fun setData(data: ArrayList<ContentModel>) {
        binding.recyclerView.adapter =
            RecyclerMainAdapter(
                allData = data,
                images = if (data.size == 4) currencyImages else goldImages
            )
    }
}