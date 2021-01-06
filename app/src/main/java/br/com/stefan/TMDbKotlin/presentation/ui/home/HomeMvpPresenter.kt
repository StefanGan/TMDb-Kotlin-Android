package br.com.stefan.TMDbKotlin.presentation.ui.home

import br.com.stefan.TMDbKotlin.presentation.internal.di.PerActivity
import br.com.stefan.TMDbKotlin.presentation.ui.base.MvpPresenter

@PerActivity
interface HomeMvpPresenter<V : HomeMvpView> : MvpPresenter<V> {
    fun clearMoviesFromPreferences()
}
