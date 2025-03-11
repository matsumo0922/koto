package me.matsumo.koto.core.domain

import me.matsumo.koto.core.resources.Res
import me.matsumo.koto.core.resources.translation_service_chatgpt
import me.matsumo.koto.core.resources.translation_service_deepl
import me.matsumo.koto.core.resources.translation_service_google
import org.jetbrains.compose.resources.StringResource

enum class TranslationService(
    val iconUrl: String,
    val displayName: StringResource,
) {
    Google(
        iconUrl = "https://cdn.worldvectorlogo.com/logos/google-translate-logo.svg",
        displayName = Res.string.translation_service_google,
    ),
    DeepL(
        iconUrl = "https://cdn.worldvectorlogo.com/logos/deepl-1.svg",
        displayName = Res.string.translation_service_deepl,
    ),
    ChatGPT(
        iconUrl = "https://upload.wikimedia.org/wikipedia/commons/0/04/ChatGPT_logo.svg",
        displayName = Res.string.translation_service_chatgpt,
    ),
}
