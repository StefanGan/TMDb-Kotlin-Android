package br.com.stefan.TMDbKotlin.presentation.ui.home.search

import br.com.stefan.TMDbKotlin.data.model.MoviesResponseModel
import br.com.stefan.TMDbKotlin.presentation.ui.base.MvpView

interface SearchMvpView : MvpView {
    fun showNowPlayingMovies(nowPlayingMovies: MoviesResponseModel)
}
