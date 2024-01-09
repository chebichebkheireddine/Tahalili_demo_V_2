package com.example.tahalili_demo_v_2

import retrofit2.Call
import retrofit2.http.GET

// Define your ApiService interface for Retrofit requests
interface ApiService {
    @GET("Labs")
    fun getData(): Call<List<Data>> // Adjust Data model according to API response
}

// Define your Data model based on the API response structure

