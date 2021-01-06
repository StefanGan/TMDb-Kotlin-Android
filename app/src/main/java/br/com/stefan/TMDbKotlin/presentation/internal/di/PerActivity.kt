package br.com.stefan.TMDbKotlin.presentation.internal.di

import kotlin.annotation.Retention
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

