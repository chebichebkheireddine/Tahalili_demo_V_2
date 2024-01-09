package com.example.tahalili_demo_v_2

import Home
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tahalili_demo.Analyse
import com.example.tahalili_demo.Profile
import com.example.tahalili_demo.Search
import com.example.tahalili_demo_v_2.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> replaceFragment(Home())
                R.id.Search -> replaceFragment(Search())
                R.id.Analyse -> replaceFragment(Analyse())
                R.id.profile -> replaceFragment(Profile())
                else -> {
                    // Handle other cases if needed
                }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_tahalili, fragment)
        fragmentTransaction.commit()
    }
}