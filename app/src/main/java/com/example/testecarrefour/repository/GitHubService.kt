package com.example.testecarrefour.repository

import com.example.testecarrefour.response.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users")
   suspend fun getListUsers(
    ): List<UsersResponse>

    @GET("users/{userName}")
   suspend fun getDetailsUsers(
        @Path("userName") userName: String? = null
    ): UsersResponse
}