package com.example.goldapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.goldapp.databinding.ActivityMainBinding
import com.example.goldapp.remote.time.TimeApiRepository
import com.example.goldapp.remote.time.TimeRequest
import com.example.goldapp.remote.detaModel.timeModel.DateModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        TimeApiRepository.instance.getTime(
            object : TimeRequest {
                override fun onSuccess(data: DateModel) {
                    val date =data .date
                    val text ="${date.l_value} ${date.j_value} ${date.F_value} ${date.Y_value}"
                    binding.txtTime.text=text
                }
                override fun onNotSuccess(message: String) {
                 Toast.makeText(this@MainActivity,message,Toast.LENGTH_SHORT).show()
                }
                override fun onError(error: String) {
                    Toast.makeText(this@MainActivity,error,Toast.LENGTH_SHORT).show()
                }
            }
        )
        binding.txtArz.setOnClickListener {
            binding.txtArz.setTextColor(Color.parseColor("#E7C376"))
            binding.txtGold.setTextColor(Color.parseColor("#787879"))
        }
        binding.txtGold.setOnClickListener {
            binding.txtArz.setTextColor(Color.parseColor("#787879"))
            binding.txtGold.setTextColor(Color.parseColor("#E7C376"))
        }
    }
}