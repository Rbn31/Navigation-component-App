package com.example.testegit.features.main.viewState

import com.example.testecarrefour.response.UsersResponse

sealed class MainViewState {
    object Loading : MainViewState()
    data class ShowLoading(val show: Boolean): MainViewState()
    data class Success(val users: List<UsersResponse>) : MainViewState()
    data class Error(val message: String) : MainViewState()
}
