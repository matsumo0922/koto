package me.matsumo.koto.core.domain

import androidx.compose.ui.text.intl.Locale
import me.matsumo.koto.core.resources.Res
import me.matsumo.koto.core.resources.language_ar
import me.matsumo.koto.core.resources.language_auto
import me.matsumo.koto.core.resources.language_de
import me.matsumo.koto.core.resources.language_en
import me.matsumo.koto.core.resources.language_es
import me.matsumo.koto.core.resources.language_fr
import me.matsumo.koto.core.resources.language_it
import me.matsumo.koto.core.resources.language_ja
import me.matsumo.koto.core.resources.language_ko
import me.matsumo.koto.core.resources.language_ru
import me.matsumo.koto.core.resources.language_zh
import org.jetbrains.compose.resources.StringResource

enum class Language(
    val locale: Locale,
    val displayName: StringResource
) {
    AUTO(
        locale = Locale.current,
        displayName = Res.string.language_auto,
    ),
    JAPANESE(
        locale = Locale("ja"),
        displayName = Res.string.language_ja,
    ),
    ENGLISH(
        locale = Locale("en"),
        displayName = Res.string.language_en,
    ),
    SPANISH(
        locale = Locale("es"),
        displayName = Res.string.language_es,
    ),
    FRENCH(
        locale = Locale("fr"),
        displayName = Res.string.language_fr,
    ),
    GERMAN(
        locale = Locale("de"),
        displayName = Res.string.language_de,
    ),
    CHINESE(
        locale = Locale("zh"),
        displayName = Res.string.language_zh,
    ),
    KOREAN(
        locale = Locale("ko"),
        displayName = Res.string.language_ko,
    ),
    ITALIAN(
        locale = Locale("it"),
        displayName = Res.string.language_it,
    ),
    RUSSIAN(
        locale = Locale("ru"),
        displayName = Res.string.language_ru,
    ),
    ARABIC(
        locale = Locale("ar"),
        displayName = Res.string.language_ar,
    ),
}
