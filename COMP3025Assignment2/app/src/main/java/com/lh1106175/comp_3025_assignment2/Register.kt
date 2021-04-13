package com.lh1106175.comp_3025_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lh1106175.comp_3025_assignment2.databinding.ActivityLoginBinding
import com.lh1106175.comp_3025_assignment2.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener{
            var intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}