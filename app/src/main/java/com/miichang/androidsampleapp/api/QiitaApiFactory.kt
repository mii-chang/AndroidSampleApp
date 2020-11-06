package com.miichang.androidsampleapp.api

import android.util.Log
import com.miichang.androidsampleapp.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object QiitaApiFactory {
    fun create(): QiitaApi = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(
            OkHttpClient.Builder().apply {
                addInterceptor(
                    HttpLoggingInterceptor(
                        object : HttpLoggingInterceptor.Logger {
                            override fun log(message: String) {
                                Log.d("Application/OkHttp", message)
                            }
                        }
                    ).apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
                addNetworkInterceptor(
                    HttpLoggingInterceptor(
                        object : HttpLoggingInterceptor.Logger {
                            override fun log(message: String) {
                                Log.d("Network/OkHttp", message)
                            }
                        }
                    ).apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
            }.build()
        )
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()
        .create(QiitaApi::class.java)
}
