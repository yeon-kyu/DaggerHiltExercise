package com.yeonkyu.daggerhiltexercise.di

import com.yeonkyu.daggerhiltexercise.network.ITunesClient
import com.yeonkyu.daggerhiltexercise.repository.MainRepository
import com.yeonkyu.daggerhiltexercise.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

//    @Provides
//    @ViewModelScoped
//    fun provideMainRepository(
//        iTunesClient: ITunesClient
//    ): MainRepository{
//        return MainRepository(iTunesClient)
//    }

    @Binds
    abstract fun providesMainRepository(
        impl: MainRepositoryImpl
    ): MainRepository
}