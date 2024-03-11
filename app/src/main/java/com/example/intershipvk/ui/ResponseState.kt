package com.example.intershipvk.ui

sealed interface ResponseState<T>{

    data class Success <T>(val data:T):ResponseState<T>

    class Loading<T>:ResponseState<T>

    class Error<T>:ResponseState<T>
}