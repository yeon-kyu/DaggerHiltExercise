package com.yeonkyu.daggerhiltexercise.di

import com.yeonkyu.daggerhiltexercise.network.ITunesClient
import com.yeonkyu.daggerhiltexercise.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        iTunesClient: ITunesClient
    ): MainRepository{
        return MainRepository(iTunesClient)
    }
}