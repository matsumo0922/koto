package me.matsumo.koto.core.setting.di

import me.matsumo.koto.core.setting.SettingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val settingModule = module {
    viewModelOf(::SettingViewModel)
}
