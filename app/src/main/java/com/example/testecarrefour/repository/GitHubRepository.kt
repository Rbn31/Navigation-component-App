package com.example.testecarrefour.repository

import com.example.testecarrefour.core.ResultWrapper
import com.example.testecarrefour.response.UsersResponse

interface GitHubRepository {
    suspend fun getGitList(): ResultWrapper<List<UsersResponse>>
}