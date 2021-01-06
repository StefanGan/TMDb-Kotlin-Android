package br.com.stefan.TMDbKotlin.presentation.ui.home.search

import javax.inject.Inject

import br.com.stefan.TMDbKotlin.data.DataManager
import br.com.stefan.TMDbKotlin.data.network.APIConstants
import br.com.stefan.TMDbKotlin.presentation.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchPresenter<V : SearchMvpView> @Inject
internal constructor(dataManager: DataManager, compositeDisposable: CompositeDisposable) : BasePresenter<V>(dataManager, compositeDisposable), SearchMvpPresenter<V> {

    override fun getMoviesByTitle(title: String, page: Int) {
        var title = title
        if (page == APIConstants.INITIAL_PAGINATION_INDEX)
            mvpView!!.showLoading()

        title = title.replace(" ", "+")

        compositeDisposable.add(dataManager.getMoviesByTitle(title, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { nowPlayingMovies ->
                            val view = mvpView
                            view!!.hideLoading()

                            mvpView!!.showNowPlayingMovies(nowPlayingMovies)
                        }
                ) { throwable ->
                    val view = mvpView
                    view!!.hideLoading()

                    handlerThrowableError(view, throwable)
                }
        )
    }
}
