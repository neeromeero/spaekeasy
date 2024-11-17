package ru.neeromeero.speakeasy.core.domain.translation

import ru.neeromeero.speakeasy.core.TranslationApi
import ru.neeromeero.speakeasy.core.TranslationResponse
import ru.neeromeero.speakeasy.core.domain.LanguageCode
import javax.inject.Inject

class TranslationUseCase @Inject constructor(
    private val translationApi: TranslationApi
) {
    suspend fun translate(sl: LanguageCode, dl: LanguageCode, text: String): TranslationResponse{
        return translationApi.translate(
            sourceLanguage = sl.code,
            destinationLanguage = dl.code,
            text = text
        )
    }
}