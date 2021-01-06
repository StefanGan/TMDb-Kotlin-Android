package br.com.stefan.TMDbKotlin.data.network

import br.com.stefan.TMDbKotlin.data.model.MoviesDetailResponseModel
import br.com.stefan.TMDbKotlin.data.model.MoviesResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit service methods
 */
internal interface BackendApi {

    /**
     * Now Playing Movies
     * @param api_version
     * @param key
     * @param page
     * @return Now Playing Movies
     */
    @GET("/{api_version}/discover/movie?sort_by=release_date.desc&primary_release_date.lte=2021-12-31")
    fun nowPlayingMovies(
            @Path("api_version") api_version: Int,
            @Query("api_key") key: String,
            @Query("page") page: Int
    ): Observable<MoviesResponseModel>

    /**
     * Movies filtered by keywords on title
     * @param api_version
     * @param key
     * @param query
     * @param page
     * @return
     */
    @GET("/{api_version}/search/movie?language=en-US")
    fun getMoviesByTitle(
            @Path("api_version") api_version: Int,
            @Query("api_key") key: String,
            @Query("query") query: String,
            @Query("page") page: Int
    ): Observable<MoviesResponseModel>

    @GET("/{api_version}/movie/{movieId}?language=en-US")
    fun getMoviesDetailByTitle(
            @Path("api_version") api_version: Int,
            @Path("movieId") movieId: Int,
            @Query("api_key") key: String
    ): Observable<MoviesDetailResponseModel>
}
