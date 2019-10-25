package com.sunchildapps.pruebavalid.service.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitClient {
    companion object {
        private const val API_KEY = "829751643419a7128b7ada50de590067"
        private const val API_KEY_ARG = "api_key"
        private const val BASE_URL = "http://ws.audioscrobbler.com/"

        private const val COUNTRY_ARG = "country"
        private const val COUNTRY_VALUE = "colombia"

        private const val FORMAT_ARG = "format"
        private const val FORMAT_VALUE = "json"

        private const val LIMIT_ARG = "limit"
        private const val LIMIT_VALUE = "50"

        private val interceptor = HttpLoggingInterceptor()

        private val httpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val defaultRequest = chain.request()
            val defaultHttpUrl = defaultRequest.url()
            val httpUrl = defaultHttpUrl.newBuilder()
                .addQueryParameter(API_KEY_ARG, API_KEY)
                .addQueryParameter(FORMAT_ARG, FORMAT_VALUE)
                .addQueryParameter(COUNTRY_ARG, COUNTRY_VALUE)
                .addQueryParameter(LIMIT_ARG, LIMIT_VALUE)
                .build()

            val requestBuilder = defaultRequest.newBuilder().url(httpUrl)

            chain.proceed(requestBuilder.build())
        }.addInterceptor(
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        )
    }

    private fun createService(okHttpClient: OkHttpClient): RestApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(RestApi::class.java)
    }

    fun createService(): RestApi {
        val okHttpClient = httpClient.build()
        return createService(okHttpClient)
    }
}