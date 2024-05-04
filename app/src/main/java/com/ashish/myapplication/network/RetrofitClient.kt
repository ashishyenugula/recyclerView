package com.ashish.myapplication.network



import com.ashish.myapplication.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


    private val retrofitClient: Retrofit.Builder by lazy {

        val levelType: Level


        if (BuildConfig.DEBUG)
            levelType = Level.BODY else levelType = Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(
            levelType
        )

        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl("https://dev.to")
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: MainService by lazy {
        retrofitClient
            .build()
            .create(MainService::class.java)
    }

}