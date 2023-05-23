package com.example.testecarrefour.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testecarrefour.core.ResultWrapper
import com.example.testecarrefour.repository.GitHubRepository
import com.example.testecarrefour.response.UsersResponse
import com.example.testegit.features.main.viewState.MainViewState
import kotlinx.coroutines.launch

class MainViewModel(private val repository: GitHubRepository) : ViewModel() {

    val state: MutableLiveData<MainViewState> = MutableLiveData()
    val gitList: MutableLiveData<ArrayList<UsersResponse>> = MutableLiveData()
    private val gitListData = arrayListOf<UsersResponse>()

    fun fetchGitList() {

        viewModelScope.launch {
            state.value = MainViewState.ShowLoading(true)

            when (val response = repository.getGitList()) {
                is ResultWrapper.Success -> {
                    gitListData.addAll(response.value)
                    gitList.value = gitListData
                }
                is ResultWrapper.Error -> state.value = state.value
            }

            state.value = MainViewState.ShowLoading(false)

        }
    }


}
