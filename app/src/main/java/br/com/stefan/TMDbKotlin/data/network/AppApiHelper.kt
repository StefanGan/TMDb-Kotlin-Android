package br.com.stefan.TMDbKotlin.data.network

import java.io.IOException

import javax.inject.Inject

import br.com.stefan.TMDbKotlin.data.model.ErrorResponse
import br.com.stefan.TMDbKotlin.data.model.MoviesDetailResponseModel
import br.com.stefan.TMDbKotlin.data.model.MoviesResponseModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit

/**
 * Implementation of helper for Retrofit Api
 */
class AppApiHelper @Inject
internal constructor(private val retrofit: Retrofit) : ApiHelper {

    private val backendApi: BackendApi = retrofit.create(BackendApi::class.java)

    override fun getNowPlayingMovies(page: Int): Observable<MoviesResponseModel> {
        return backendApi.nowPlayingMovies(3, APIConstants.API_KEY, page)
    }

    override fun getMoviesByTitle(query: String, page: Int): Observable<MoviesResponseModel> {
        return backendApi.getMoviesByTitle(3, APIConstants.API_KEY, query, page)
    }

    override fun getMoviesDetailByTitle(movieId : Int): Observable<MoviesDetailResponseModel> {
        return backendApi.getMoviesDetailByTitle(3 ,movieId,APIConstants.API_KEY )
    }

    override fun parseError(response: Response<*>): ErrorResponse {
        val converter = retrofit.responseBodyConverter<ErrorResponse>(ErrorResponse::class.java, arrayOfNulls(0))
        try {
            return converter.convert(response.errorBody()!!)
        } catch (e: IOException) {
            return ErrorResponse()
        }

    }
}
