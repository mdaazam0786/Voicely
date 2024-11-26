package com.example.voicely.ui.advanced

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.voicely.ui.homescreen.TextToSpeechState
import com.example.voicely.util.Routes
import com.example.voicely.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class AdvancedScreenViewModel @Inject constructor()
    : ViewModel() {
    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var _state = mutableStateOf(TextToSpeechState())
    var state : State<TextToSpeechState> = _state

    private var textToSpeech : TextToSpeech? = null
    fun onAdvancedEvent(event : AdvancedScreenEvent){
        when(event){
            AdvancedScreenEvent.onBodyClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.BODY))
            }
            AdvancedScreenEvent.onFeelClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.FEELINGS))
            }
            is AdvancedScreenEvent.onPhrasesClick -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        text = event.text
                    )
                    textToSpeech(event.context)
                }
            }
            AdvancedScreenEvent.onQuestionsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.QUESTIONS))
            }
            AdvancedScreenEvent.onStarterPhrasesClick ->{
                sendUiEvent(UiEvent.Navigate(Routes.STARTER_PHRASES))
            }
            is AdvancedScreenEvent.onTextfieldClick -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        text = event.text
                    )
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
    private fun textToSpeech(context: Context){
        _state.value = state.value.copy(
            isButtonEnabled = false
        )
        textToSpeech = TextToSpeech(
            context
        ) {
            if (it == TextToSpeech.SUCCESS) {
                textToSpeech?.let { txtToSpeech ->
                    txtToSpeech.language = Locale.US
                    txtToSpeech.setSpeechRate(1.0f)
                    txtToSpeech.speak(
                        _state.value.text,
                        TextToSpeech.QUEUE_ADD,
                        null,
                        null
                    )
                }
            }
            _state.value = state.value.copy(
                isButtonEnabled = true
            )
        }
    }
}