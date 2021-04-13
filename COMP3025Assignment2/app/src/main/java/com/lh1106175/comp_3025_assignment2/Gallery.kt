package com.lh1106175.comp_3025_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.lh1106175.comp_3025_assignment2.databinding.ActivityGalleryBinding
import com.lh1106175.comp_3025_assignment2.databinding.ActivityRegisterBinding
import com.google.firebase.firestore.FirebaseFirestore

class Gallery : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding
    val db = FirebaseFirestore.getInstance().collection("actionFiguresDB")
    private val authDb = FirebaseAuth.getInstance();

    private fun logout(){
        authDb.signOut()
        finish()
        var intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (authDb.currentUser == null){
            logout()
        }

        binding.addNewButton.setOnClickListener{
            var intent = Intent(this, DetailedView::class.java)
            startActivity(intent)
        }

        binding.nextPageButton.setOnClickListener{
            //ADD 1 TO THE ID OF THE PRODUCT AND LOOP THROUGH TO FILL IT ALL OUT

            //RELOAD THE PAGE
            var intent = Intent(this, Gallery::class.java)
            startActivity(intent)
        }
        db.get().addOnSuccessListener { documents ->
            for (document in documents) {
                val actionfigure = document.toObject(actionFigures::class.java)
                binding.textViewr1c1.text = actionfigure.name

                if (binding.textViewr1c1.text.isNotEmpty())
                    binding.textViewr1c2.text = actionfigure.name

                else if (binding.textViewr1c2.text.isNotEmpty())
                    binding.textViewr1c3.text = actionfigure.name

                else if (binding.textViewr1c3.text.isNotEmpty())
                    binding.textViewr2c1.text = actionfigure.name

                else if (binding.textViewr2c1.text.isNotEmpty())
                    binding.textViewr2c2.text = actionfigure.name

                else if (binding.textViewr2c2.text.isNotEmpty())
                    binding.textViewr2c3.text = actionfigure.name

                else if (binding.textViewr2c3.text.isNotEmpty())
                    binding.textViewr3c1.text = actionfigure.name

                else if (binding.textViewr3c1.text.isNotEmpty())
                    binding.textViewr3c2.text = actionfigure.name

                else if (binding.textViewr3c2.text.isNotEmpty())
                    binding.textViewr3c3.text = actionfigure.name

                else if (binding.textViewr3c3.text.isNotEmpty())
                    binding.textViewr4c1.text = actionfigure.name

                else if (binding.textViewr4c1.text.isNotEmpty())
                    binding.textViewr4c2.text = actionfigure.name

                else if (binding.textViewr4c2.text.isNotEmpty())
                    binding.textViewr4c3.text = actionfigure.name

                else if (binding.textViewr4c3.text.isNotEmpty())
                    binding.textViewr5c1.text = actionfigure.name

                else if(binding.textViewr5c1.text.isNotEmpty())
                    binding.textViewr5c2.text = actionfigure.name

                else if(binding.textViewr5c2.text.isNotEmpty())
                    binding.textViewr5c3.text = actionfigure.name

                else if(binding.textViewr5c3.text.isNotEmpty())
                    binding.textViewr6c1.text = actionfigure.name

                else if(binding.textViewr6c1.text.isNotEmpty())
                    binding.textViewr6c2.text = actionfigure.name

                else if(binding.textViewr6c2.text.isNotEmpty())
                    binding.textViewr6c3.text = actionfigure.name

                else if(binding.textViewr6c3.text.isNotEmpty())
                    binding.textViewr7c1.text = actionfigure.name

                else if(binding.textViewr7c1.text.isNotEmpty())
                    binding.textViewr7c2.text = actionfigure.name

                else if(binding.textViewr7c2.text.isNotEmpty())
                    binding.textViewr7c3.text = actionfigure.name

                else if(binding.textViewr7c3.text.isNotEmpty())
                    binding.textViewr8c1.text = actionfigure.name

                else if(binding.textViewr8c1.text.isNotEmpty())
                    binding.textViewr8c2.text = actionfigure.name

                else if(binding.textViewr8c2.text.isNotEmpty())
                    binding.textViewr8c3.text = actionfigure.name

                else if(binding.textViewr8c3.text.isNotEmpty())
                    binding.textViewr9c1.text = actionfigure.name

                else if(binding.textViewr9c1.text.isNotEmpty())
                    binding.textViewr9c2.text = actionfigure.name

                else if(binding.textViewr9c2.text.isNotEmpty())
                    binding.textViewr9c3.text = actionfigure.name

            }
        }
    }
}