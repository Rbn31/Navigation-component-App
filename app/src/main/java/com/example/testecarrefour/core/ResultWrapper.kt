package com.example.testecarrefour.core

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class Error(val error: String): ResultWrapper<Nothing>()
}

sealed class ResultWrapperDB<out T> {
    data class Success<out T>(val value: T): ResultWrapperDB<T>()
    data class Error(val error: String): ResultWrapperDB<Nothing>()
}