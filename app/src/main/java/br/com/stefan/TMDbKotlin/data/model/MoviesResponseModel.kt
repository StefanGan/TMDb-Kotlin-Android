package br.com.stefan.TMDbKotlin.data.model

/**
 * Model MoviesResponseModel
 */
class MoviesResponseModel {

    val page: Int = 0
    var results: ArrayList<Movie>? = null
    val total_pages: Int = 0
    val total_results: Int = 0
}