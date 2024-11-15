package ru.neeromeero.speakeasy.core.di

import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import okhttp3.Call
import retrofit2.Retrofit
import ru.neeromeero.speakeasy.core.TranslationApi

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpCallFactory: Lazy<Call.Factory>): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .build()
    }

    @Provides
    @Singleton
    fun provideTranslationApi(retrofit: Retrofit): TranslationApi{
        return retrofit.create(TranslationApi::class.java)
    }
}