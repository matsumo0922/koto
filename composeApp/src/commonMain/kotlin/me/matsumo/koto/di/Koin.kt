package me.matsumo.koto.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import me.matsumo.koto.KotoAppStateHolder
import me.matsumo.koto.core.datasource.di.dataSourceModule
import me.matsumo.koto.core.repository.di.repositoryModule
import me.matsumo.koto.core.setting.di.settingModule
import me.matsumo.koto.feature.home.di.homeModule
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        modules(mainModule)

        modules(dataSourceModule)
        modules(repositoryModule)

        modules(homeModule)
        modules(settingModule)
    }
}

val mainModule = module {
    single<CoroutineDispatcher> {
        Dispatchers.IO.limitedParallelism(24)
    }

    singleOf(::KotoAppStateHolder)
}
