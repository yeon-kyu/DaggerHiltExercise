package com.yeonkyu.daggerhiltexercise.di

import com.yeonkyu.daggerhiltexercise.BuildConfig
import com.yeonkyu.daggerhiltexercise.network.ITunesClient
import com.yeonkyu.daggerhiltexercise.network.ITunesSearchService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    const val BASE_URL = "https://itunes.apple.com/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                })
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideITunesService(retrofit: Retrofit): ITunesSearchService {
        return retrofit.create(ITunesSearchService::class.java)
    }

    @Provides
    @Singleton
    fun provideITunesClient(iTunesService: ITunesSearchService): ITunesClient{
        return ITunesClient(iTunesService)
    }
}