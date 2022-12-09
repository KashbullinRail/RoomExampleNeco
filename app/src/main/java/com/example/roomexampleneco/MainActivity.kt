package com.example.roomexampleneco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.roomexampleneco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbRoom = MainDataBase.getDataBase(this@MainActivity)

        dbRoom.getDao().getAllItem().asLiveData().observe(this){ list ->
            binding.tvView.text = ""
            list.forEach {
                val text = "Id:${it.id}  Name:${it.name} Price:${it.price}\n"
                binding.tvView.append(text)
            }
        }

        with(binding){
            btnSave.setOnClickListener {
                val itemDbRoom = ItemEntity(
                    null,
                    etName.text.toString(),
                    etPrice.text.toString()
                    )

                Thread {
                    dbRoom.getDao().insertItem(itemDbRoom)
                }.start()

            }
        }



    }
}