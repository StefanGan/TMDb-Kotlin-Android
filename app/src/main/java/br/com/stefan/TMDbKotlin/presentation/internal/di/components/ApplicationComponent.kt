package br.com.stefan.TMDbKotlin.presentation.internal.di.components

import android.app.Application
import android.content.Context
import br.com.stefan.TMDbKotlin.config.AndroidApplication
import br.com.stefan.TMDbKotlin.data.DataManager
import br.com.stefan.TMDbKotlin.presentation.internal.di.ApplicationContext
import br.com.stefan.TMDbKotlin.presentation.internal.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(app: AndroidApplication)

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun getDataManager(): DataManager
}
