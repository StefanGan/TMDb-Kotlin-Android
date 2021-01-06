package br.com.stefan.TMDbKotlin.presentation.ui.base

/**
 * Interfac to interact with FragNavController
 */
interface FragManagerListerner {
    fun pushFragment(fragment: BaseFragment)
    fun popFragment()
}
