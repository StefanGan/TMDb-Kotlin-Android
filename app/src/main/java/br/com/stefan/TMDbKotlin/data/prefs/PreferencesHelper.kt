package br.com.stefan.TMDbKotlin.data.prefs;

import br.com.stefan.TMDbKotlin.data.model.Movie

interface PreferencesHelper {
    fun saveMovies(movies: ArrayList<Movie>)
    fun retrieveMovies(): ArrayList<Movie>
    fun clearPreferences()
}
