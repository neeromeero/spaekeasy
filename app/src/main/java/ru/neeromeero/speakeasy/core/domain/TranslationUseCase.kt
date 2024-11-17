package ru.neeromeero.speakeasy.core.domain

import ru.neeromeero.speakeasy.core.TranslationApi
import javax.inject.Inject

class TranslationUseCase @Inject constructor(
    private val translationApi: TranslationApi
) {
    suspend fun translate(){

    }
}