package com.example.rxjavajsonplaceholderapi.api_call

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JsonplaceholderRetrofitInstance {

    var retrofit: Retrofit? = null
    private val JSON_PLACEHOLDER_URL by lazy { "https://jsonplaceholder.typicode.com" }

    val instance: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(JSON_PLACEHOLDER_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!

        }
}