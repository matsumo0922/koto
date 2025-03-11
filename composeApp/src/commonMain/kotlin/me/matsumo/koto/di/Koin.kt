package me.matsumo.koto.di

import me.matsumo.koto.feature.home.di.homeModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(homeModule)
    }
}
