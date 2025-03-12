package me.matsumo.koto.core.repository

import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import me.matsumo.koto.core.datasource.UserDataStore
import me.matsumo.koto.core.datasource.db.TranslationEntity
import me.matsumo.koto.core.datasource.db.getKotoDatabase
import me.matsumo.koto.core.domain.Language
import me.matsumo.koto.core.domain.Translation
import me.matsumo.koto.core.domain.TranslationService
import me.matsumo.koto.core.repository.translator.GoogleTranslator

class TranslationRepository(
    private val client: HttpClient,
    private val userDataStore: UserDataStore,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    private val scope = CoroutineScope(ioDispatcher + SupervisorJob())
    private val database = getKotoDatabase("history.db")
    private val dao = database.translationDao()

    private lateinit var googleTranslator: GoogleTranslator

    init {
        scope.launch {
            userDataStore.userData.collect {
                googleTranslator = GoogleTranslator(client, it.googleTranslateApiKey)
            }
        }
    }

    suspend fun translate(
        text: String,
        sourceLanguage: Language,
        targetLanguage: Language,
        service: TranslationService
    ): Translation {
        val translator = when (service) {
            TranslationService.Google -> googleTranslator
            TranslationService.DeepL -> googleTranslator
            TranslationService.ChatGPT -> googleTranslator
        }

        val result = translator.translate(sourceLanguage, targetLanguage, text)
        val translation = TranslationEntity(
            source = sourceLanguage.name,
            target = targetLanguage.name,
            sourceText = text,
            translatedText = result,
            reTranslatedText = "",
            service = service.name,
            createdAt = Clock.System.now().toString()
        )

        dao.insert(translation)

        return translation.toModel()
    }

    private fun Translation.toEntity() = TranslationEntity(
        source = source.name,
        target = target.name,
        sourceText = sourceText,
        translatedText = translatedText,
        reTranslatedText = reTranslatedText,
        service = service.name,
        createdAt = createdAt.toString()
    )

    private fun TranslationEntity.toModel() = Translation(
        source = Language.valueOf(source),
        target = Language.valueOf(target),
        sourceText = sourceText,
        translatedText = translatedText,
        reTranslatedText = reTranslatedText,
        service = TranslationService.valueOf(service),
        createdAt = Instant.parse(createdAt)
    )
}
