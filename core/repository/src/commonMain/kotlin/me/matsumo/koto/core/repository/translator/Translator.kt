package me.matsumo.koto.core.repository.translator

import me.matsumo.koto.core.domain.Language

interface Translator {
    suspend fun translate(
        source: Language,
        target: Language,
        text: String,
    ): String
}
