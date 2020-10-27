package com.example.hilttestapp.di

import com.example.hilttestapp.repository.MainRepository
import com.example.hilttestapp.retrofit.BlogRetrofit
import com.example.hilttestapp.retrofit.NetworMapper
import com.example.hilttestapp.room.BlogDao
import com.example.hilttestapp.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networMapper: NetworMapper
    ):MainRepository{
        return MainRepository(blogDao, retrofit, cacheMapper, networMapper)
    }
}