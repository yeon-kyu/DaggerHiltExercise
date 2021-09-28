package com.yeonkyu.daggerhiltexercise.di

import com.yeonkyu.daggerhiltexercise.network.ITunesClient
import com.yeonkyu.daggerhiltexercise.repository.MainRepository
import com.yeonkyu.daggerhiltexercise.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

// abstract class 로 할 경우 아래와 같이 사용 가능
//    @Binds
//    abstract fun providesMainRepository(
//        impl: MainRepositoryImpl
//    ): MainRepository

    @Provides
    @Singleton
    fun provideMainRepository(
        itunesClient: ITunesClient
    ): MainRepository{
        return MainRepositoryImpl(itunesClient)
    }
}