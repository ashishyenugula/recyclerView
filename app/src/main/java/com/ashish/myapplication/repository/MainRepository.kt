package com.ashish.myapplication.repository


import com.ashish.myapplication.model.ResponseMain
import com.ashish.myapplication.network.MainService


class MainRepository constructor(private val service: MainService) {



    suspend fun getAllImages(): NetworkState<List<ResponseMain>> {
        val response = service.searchImages()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response)
            }
        } else {
            NetworkState.Error(response)
        }
    }
}