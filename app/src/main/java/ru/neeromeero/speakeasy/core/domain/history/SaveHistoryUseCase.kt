package ru.neeromeero.speakeasy.core.domain.history

import ru.neeromeero.speakeasy.core.data.TranslationHistory
import ru.neeromeero.speakeasy.core.data.TranslationHistoryDao
import javax.inject.Inject

class SaveHistoryUseCase @Inject constructor(
    private val translationHistoryDao: TranslationHistoryDao,
) {
    suspend fun save(sourceText: String, translatedText: String, ){
        translationHistoryDao.insertHistory(
            TranslationHistory(
                sourceText = sourceText,
                translatedText = translatedText,
                )
        )
    }
}