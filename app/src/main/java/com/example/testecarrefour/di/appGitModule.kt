package com.example.testecarrefour.di

import com.example.testecarrefour.repository.GitHubRepository
import com.example.testecarrefour.repository.MainRepository
import com.example.testecarrefour.viewmodel.MainViewModel
import org.koin.dsl.module

val appGitModule = module {
    single<GitHubRepository> { MainRepository() }
    factory {
        MainViewModel(get())
    }
}