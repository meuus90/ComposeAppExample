package com.example.composeapp.di

import android.app.Application
import android.content.Context
import com.example.composeapp.BuildConfig
import com.example.composeapp.SampleRestAPI
import com.example.composeapp.datasource.RestAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.orhanobut.logger.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    companion object {
        const val timeout_read = 30L
        const val timeout_connect = 30L
        const val timeout_write = 30L
    }

    @Provides
    @Singleton
    fun provideAppContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val ok = OkHttpClient.Builder()
            .connectTimeout(timeout_connect, TimeUnit.SECONDS)
            .readTimeout(timeout_read, TimeUnit.SECONDS)
            .writeTimeout(timeout_write, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    if (isJSONValid(message))
                        Logger.json(message)
                    else
                        Timber.d("pretty $message")
                }

                fun isJSONValid(jsonInString: String): Boolean {
                    try {
                        JSONObject(jsonInString)
                    } catch (ex: JSONException) {
                        try {
                            JSONArray(jsonInString)
                        } catch (ex1: JSONException) {
                            return false
                        }
                    }

                    return true
                }

            })

            logging.level = HttpLoggingInterceptor.Level.BODY
            ok.addInterceptor(logging)
        }

        ok.addInterceptor(interceptor)
        return ok.build()
    }

    @Provides
    @Singleton
    fun provideGSon(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    //@Singleton
    fun provideRequestInterceptor(): Interceptor {
        return Interceptor {
            Timber.tag("NETWORK_LOGGER")

            val original = it.request()

            val requested = with(original) {
                val builder = newBuilder()

                builder.header("Accept", "application/json")
                    .build()
            }

            val response = it.proceed(requested)
            val body = response.body
            val bodyStr = body?.string()
            Timber.e("**http-num: ${response.code}")
            Timber.e("**http-body: $body")

            val cookies = HashSet<String>()
            for (header in response.headers("Set-Cookie")) {
                cookies.add(header)
            }

            if (!response.isSuccessful) {
                try {
                    //do something on error
                } catch (e: Exception) {

                }
            }

            val builder = response.newBuilder()

            builder.body(ResponseBody.create(body?.contentType(), bodyStr?.toByteArray()!!)).build()
        }
    }

    @Singleton
    @Provides
    fun provideRestAPI(gson: Gson, okHttpClient: OkHttpClient): RestAPI {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://google.com/api/")
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client(okHttpClient)
//            .build()
//
//        return retrofit.create(RestAPI::class.java)
        return SampleRestAPI()
    }
}