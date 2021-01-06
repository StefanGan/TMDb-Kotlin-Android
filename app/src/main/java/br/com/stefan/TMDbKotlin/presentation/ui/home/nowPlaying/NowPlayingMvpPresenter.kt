package br.com.stefan.TMDbKotlin.presentation.ui.home.nowPlaying

import br.com.stefan.TMDbKotlin.data.model.Movie
import br.com.stefan.TMDbKotlin.presentation.internal.di.PerActivity
import br.com.stefan.TMDbKotlin.presentation.ui.base.MvpPresenter

@PerActivity
interface NowPlayingMvpPresenter<V : NowPlayingMvpView> : MvpPresenter<V> {
    val moviesFromPreference: ArrayList<Movie>
    fun getNowPlayingMovies(averageVote: Double, page: Int)
    fun saveMoviesOnPreferences(results: ArrayList<Movie>)
}
