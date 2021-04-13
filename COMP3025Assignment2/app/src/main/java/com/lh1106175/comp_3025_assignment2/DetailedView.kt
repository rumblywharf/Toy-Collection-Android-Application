package com.lh1106175.comp_3025_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.lh1106175.comp_3025_assignment2.databinding.ActivityDetailedViewBinding
import com.lh1106175.comp_3025_assignment2.databinding.ActivityGalleryBinding
import com.google.firebase.firestore.FirebaseFirestore

class DetailedView : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance().collection("actionFiguresDB")
    private lateinit var binding: ActivityDetailedViewBinding
    private val authDb = FirebaseAuth.getInstance();

    private fun logout(){
        authDb.signOut()
        finish()
        var intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (authDb.currentUser == null){
            logout()
        }

        binding.backButton.setOnClickListener{
            //DONT SAVE TO THE DATABASE JUST RETURN TO THE GALLERY
            var intent = Intent(this, Gallery::class.java)
            startActivity(intent)
        }
        binding.uploadImageButton.setOnClickListener{
            //upload an image and set it to the figure picture
        }
        binding.nextButton.setOnClickListener{
            //SAVE THE DATA TO THE DATABASE AND RETURN TO THE GALLERY
            if(binding.boxConditionTextfield.text.toString().isNotEmpty() &&
                    binding.nameTextfield.text.toString().isNotEmpty() &&
                    binding.pricePaidTextField.text.toString().isNotEmpty() &&
                    binding.sellingPriceTextfield.text.toString().isNotEmpty() &&
                    binding.typeTextfield.text.toString().isNotEmpty())
            {
                var actionFigures = actionFigures()
                actionFigures.boxCondition = binding.boxConditionTextfield.text.toString()
                actionFigures.name = binding.nameTextfield.text.toString()
                actionFigures.pricePaid = binding.pricePaidTextField.text.toString()
                actionFigures.sellingPrice = binding.sellingPriceTextfield.text.toString()
                actionFigures.type = binding.typeTextfield.text.toString()

                actionFigures.id = db.document().id

                db.document(actionFigures.id!!).set(actionFigures).addOnSuccessListener {
                    Toast.makeText(this, "Operation successful! Your information has been stored!", Toast.LENGTH_LONG).show()
                }
                    .addOnFailureListener{
                        Toast.makeText(this, "There was an error with storing your data- sorry about that!", Toast.LENGTH_LONG).show()
                    }




                var intent = Intent(this, Gallery::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "You must fill ALL boxes before procceding", Toast.LENGTH_LONG).show()
            }

        }

    }
}