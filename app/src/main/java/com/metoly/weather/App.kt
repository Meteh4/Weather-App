package com.metoly.weather
import android.app.Application
import com.metoly.weather.network.Api
import com.metoly.weather.network.HeaderInterceptor
import com.metoly.weather.repository.WeatherRepo
import com.metoly.weather.repository.WeatherRepoImpl
import okhttp3.OkHttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(module {
                single {
                    val client = OkHttpClient.Builder()
                        .addInterceptor(HeaderInterceptor())
                        .build()
                    Retrofit
                        .Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .baseUrl("http://dataservice.accuweather.com/")
                        .build()
                }
                single {
                    val retrofit:Retrofit = get()
                    retrofit.create(Api::class.java)
                }
                single {
                    val api:Api = get()
                    WeatherRepoImpl(api)
                } bind WeatherRepo::class
            })
        }
    }
}