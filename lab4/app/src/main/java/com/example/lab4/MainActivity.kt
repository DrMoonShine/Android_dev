package com.example.lab4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    private var temp = "Статусы:"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        temp += "\nActivity create"
        binding.mainText.text = temp

        binding.contacts.setOnClickListener{
            val intent = Intent(this, Contacts::class.java)
            startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()
        temp += "\nActivity Start"
        binding.mainText.text = temp
    }



    override fun onResume() {
        super.onResume()
        temp +="\nActivity Resume"
        binding.mainText.text = temp
    }

    override fun onPause() {
        super.onPause()
        temp += "\nActivity Pause"
        binding.mainText.text = temp
    }

    override fun onStop() {

        super.onStop()
        temp += "\nActivity Stop"
        binding.mainText.text = temp
    }
}