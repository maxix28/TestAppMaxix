package com.example.testappmaxix.di

import android.content.Context
import android.content.SharedPreferences
import com.example.testappmaxix.data.DefaultRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModules{
    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
    }
    @Provides
    @Singleton
    fun provideDefaultRepo(sharedPreferences: SharedPreferences): DefaultRepository {
        return DefaultRepository(sharedPreferences)
    }
}