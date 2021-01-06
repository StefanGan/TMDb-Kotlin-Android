package br.com.stefan.TMDbKotlin.presentation.ui.home.search

import br.com.stefan.TMDbKotlin.presentation.ui.base.MvpPresenter
import javax.inject.Singleton

@Singleton
interface SearchMvpPresenter<V : SearchMvpView> : MvpPresenter<V> {
    fun getMoviesByTitle(title: String, page: Int)
}
