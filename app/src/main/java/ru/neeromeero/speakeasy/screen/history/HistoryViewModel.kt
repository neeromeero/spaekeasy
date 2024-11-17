package ru.neeromeero.speakeasy.screen.history

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.neeromeero.speakeasy.core.data.TranslationHistory
import ru.neeromeero.speakeasy.core.data.TranslationHistoryDao
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val translationHistoryDao: TranslationHistoryDao,
): ViewModel() {
    fun getHistory(): Flow<List<TranslationHistory>>{
        return translationHistoryDao.getTranslationHistory()
    }
}