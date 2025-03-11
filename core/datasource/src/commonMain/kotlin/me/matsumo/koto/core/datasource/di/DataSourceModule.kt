package me.matsumo.koto.core.datasource.di

import me.matsumo.koto.core.datasource.PreferenceHelper
import me.matsumo.koto.core.datasource.UserDataStore
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataSourceModule = module {
    singleOf(::UserDataStore)
}
