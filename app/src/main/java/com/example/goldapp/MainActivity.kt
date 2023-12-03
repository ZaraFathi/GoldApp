package com.example.goldapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.goldapp.databinding.ActivityMainBinding
import com.example.goldapp.remote.TimeApiRepository
import com.example.goldapp.remote.TimeRequest
import com.example.goldapp.remote.detaModel.DateModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        TimeApiRepository.instance.getTime(
            object :TimeRequest{
                override fun onSuccess(data: DateModel) {
                    val date =data .date
                    val text ="${date.l_value} ${date.j_value} ${date.F_value} ${date.Y_value}"
                    binding.txtTime.text=text
                }

                override fun onNotSuccess(message: String) {

                }

                override fun onError(error: String) {

                }

            }
        )

    }
}