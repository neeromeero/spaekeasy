package ru.neeromeero.speakeasy.screen.translation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.neeromeero.speakeasy.ui.theme.TextInput
import ru.neeromeero.speakeasy.ui.theme.TranslateButton
import ru.neeromeero.speakeasy.ui.theme.TranslationResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TranslationScreen(
    viewModel: TranslationViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBar(
            title = { Text("")},
        )

        TextInput(
            language = uiState.value.sourceLang,
            text = uiState.value.inputText,
            onTextChange = {viewModel.updateInputText(it)},
            onClearText = {viewModel.clearInputText()},
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Spacer(Modifier.height(16.dp))

        TranslateButton(
            onTranslate = {viewModel.translateText()},
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Spacer(Modifier.height(16.dp))

        uiState.value.translatedText?.let {
            TranslationResult(
                result = it,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
        }
    }
}