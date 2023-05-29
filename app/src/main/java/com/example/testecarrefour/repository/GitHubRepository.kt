package com.example.testecarrefour.repository

import com.example.testecarrefour.core.ResultWrapper
import com.example.testecarrefour.response.UsersResponse

interface GitHubRepository {
    suspend fun getListUsers(): ResultWrapper<List<UsersResponse>>
    suspend fun getDetailsUsers(userName: String?): ResultWrapper<UsersResponse>
}