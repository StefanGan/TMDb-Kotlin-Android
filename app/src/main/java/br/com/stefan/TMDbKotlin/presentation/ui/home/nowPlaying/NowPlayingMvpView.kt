package br.com.stefan.TMDbKotlin.presentation.ui.home.nowPlaying

import br.com.stefan.TMDbKotlin.data.model.MoviesResponseModel
import br.com.stefan.TMDbKotlin.presentation.ui.base.MvpView

interface NowPlayingMvpView : MvpView {
    fun showNowPlayingMovies(nowPlayingMovies: MoviesResponseModel)
}
