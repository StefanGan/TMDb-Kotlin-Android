package br.com.stefan.TMDbKotlin.presentation.internal.di.components

import br.com.stefan.TMDbKotlin.presentation.internal.di.PerActivity
import br.com.stefan.TMDbKotlin.presentation.internal.di.module.ActivityModule
import br.com.stefan.TMDbKotlin.presentation.ui.home.HomeActivity
import br.com.stefan.TMDbKotlin.presentation.ui.home.nowPlaying.NowPlayingFragment
import br.com.stefan.TMDbKotlin.presentation.ui.home.search.SearchFragment
import dagger.Component


@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: HomeActivity)
    fun inject(fragment: SearchFragment)
    fun inject(fragment: NowPlayingFragment)
}