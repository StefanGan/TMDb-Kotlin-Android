package br.com.stefan.TMDbKotlin.data.model

/**
 * Error Response base on TheMovieDB error json structure
 */
class ErrorResponse {

    var statusMessage: String? = null
    var statusCode: Int = 0
}
