package br.com.stefan.TMDbKotlin.config

import android.app.Application
import br.com.stefan.TMDbKotlin.presentation.internal.di.components.ApplicationComponent
import br.com.stefan.TMDbKotlin.presentation.internal.di.components.DaggerApplicationComponent
import br.com.stefan.TMDbKotlin.presentation.internal.di.module.ApplicationModule

class AndroidApplication: Application() {

    companion object {
        lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        component.inject(this)
    }
}