package com.example.testecarrefour.repository

import com.example.testecarrefour.core.ResultWrapper
import com.example.testecarrefour.network.call
import com.example.testecarrefour.response.UsersResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository: GitHubRepository {

    override suspend fun getListUsers(): ResultWrapper<List<UsersResponse>> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GitHubService::class.java)

        return call{
            service.getListUsers()
        }
    }

    override suspend fun getDetailsUsers(userName: String?): ResultWrapper<UsersResponse> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GitHubService::class.java)

        return call{
            service.getDetailsUsers(userName)
        }
    }
}
