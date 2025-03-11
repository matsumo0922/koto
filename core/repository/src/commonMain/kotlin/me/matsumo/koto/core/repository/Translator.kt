package me.matsumo.koto.core.repository

import me.matsumo.koto.core.domain.Language
import me.matsumo.koto.core.domain.TranslationService

interface Translator {
    suspend fun translate(
        source: Language,
        target: Language,
        text: String,
    )
}
