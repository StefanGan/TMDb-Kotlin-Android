package br.com.stefan.TMDbKotlin.presentation.internal.di

import kotlin.annotation.Retention
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext