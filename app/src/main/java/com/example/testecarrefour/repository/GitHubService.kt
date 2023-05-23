package com.example.testecarrefour.repository

import com.example.testecarrefour.response.UsersResponse
import retrofit2.http.GET

interface GitHubService {
    @GET("users")
   suspend fun getUsers(): List<UsersResponse>
}