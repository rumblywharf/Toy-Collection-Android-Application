package com.lh1106175.comp_3025_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lh1106175.comp_3025_assignment2.databinding.ActivityMainBinding


class Main : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener{
            var intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.registerButon.setOnClickListener{
            var intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}