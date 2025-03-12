package me.matsumo.koto.core.repository.translator

import me.matsumo.koto.core.domain.Language

class ChatGptTranslator : Translator {
    override suspend fun translate(source: Language, target: Language, text: String): String {
        TODO()
    }
}
