package com.chakravyuh.githubsearch.Api

import com.chakravyuh.githubsearch.Model.usersItem
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers() : List<usersItem>
}