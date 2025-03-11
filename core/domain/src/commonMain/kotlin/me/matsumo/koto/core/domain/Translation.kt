package me.matsumo.koto.core.domain

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class Translation(
    val source: Language,
    val target: Language,
    val sourceText: String,
    val translatedText: String,
    val reTranslatedText: String,
    val createdAt: Instant,
)
