package com.chakravyuh.githubsearch.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // BASE URL : https://api.github.com/

    private fun getInstance() : Retrofit{

        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService() : ApiService{
        return getInstance().create(ApiService::class.java)
    }
}