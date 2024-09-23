package com.skiffold.app.rbusiness.di

import android.content.Context
import androidx.room.Room
import com.skiffold.app.rbusiness.data.local.RBusinessRoomDB
import com.skiffold.app.rbusiness.data.local.dao.RBusinessDao
import com.skiffold.app.rbusiness.data.network.SimpleRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleApp {

    @Provides
    fun baseUrl() = "https://test.ru"

    @Provides
    fun logging() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun okHttpClient() = OkHttpClient.Builder().addInterceptor {
        val request = it.request().newBuilder()
            .addHeader("Authorization", Credentials.basic("Edinsssson", "edikli90")).build()
        it.proceed(request)
    }.addInterceptor(logging()).build()

    @Provides
    fun gson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(): SimpleRetrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl())
            .addConverterFactory(gson())
            .client(okHttpClient())
            .build()
            .create(SimpleRetrofit::class.java)

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context): RBusinessRoomDB =
        Room.databaseBuilder(
            context,
            RBusinessRoomDB::class.java,
            "rbusiness_db"
        ).build()

    @Provides
    @Singleton
    fun provideOpenSkyDao(appDataBaseOpenSky: RBusinessRoomDB): RBusinessDao {
        return appDataBaseOpenSky.openSkyDao()
    }
}