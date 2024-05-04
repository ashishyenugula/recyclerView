package com.ashish.myapplication.network


import com.ashish.myapplication.model.ResponseMain

import retrofit2.Response
import retrofit2.http.*

interface MainService {

    @GET("/api/articles")
    suspend fun searchImages(): Response<List<ResponseMain>>


}