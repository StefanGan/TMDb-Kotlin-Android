package br.com.stefan.TMDbKotlin.presentation.internal.di.module

import android.app.Application
import android.content.Context
import br.com.stefan.TMDbKotlin.config.AndroidApplication
import br.com.stefan.TMDbKotlin.data.AppDataManager
import br.com.stefan.TMDbKotlin.data.DataManager
import br.com.stefan.TMDbKotlin.data.network.ApiHelper
import br.com.stefan.TMDbKotlin.data.network.AppApiHelper
import br.com.stefan.TMDbKotlin.data.prefs.AppPreferencesHelper
import br.com.stefan.TMDbKotlin.data.prefs.PreferencesHelper
import br.com.stefan.TMDbKotlin.presentation.internal.di.ApplicationContext
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import javax.inject.Singleton
import dagger.Provides
import dagger.Module
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
class ApplicationModule(val application: AndroidApplication) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = (HttpLoggingInterceptor.Level.BODY)
        builder.addInterceptor(httpLoggingInterceptor)

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/")
                .client(builder.build())
                .build()
    }
}