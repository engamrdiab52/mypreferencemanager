package com.amrabdelhamiddiab.myprefrencemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amrabdelhamiddiab.myprefrencemanager.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var preferenceHelper: IPreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        preferenceHelper = PreferenceManager(applicationContext)
        val user = User(1000, "Yasmin", "Talia", "Amy")
        setContentView(binding.root)
        binding.buttonSave.setOnClickListener {
            val gson = Gson()
            val userServiceString = gson.toJson(user)
            preferenceHelper.saveService(userServiceString)
        }
        binding.buttonLoad.setOnClickListener {
            val userString = preferenceHelper.loadService()
            val gson = Gson()
            val userObject :User = gson.fromJson(userString, User::class.java)
            "1: ${userObject.myAge} 2: ${userObject.myFirstName} 3: ${userObject.myLastName} 4: ${userObject.myValue}".also { binding.textView.text = it }
        }
    }
}