package com.example.voicely.ui.getting_started

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
class GettingStartedViewModel @Inject constructor()
    : ViewModel(){
    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var _state = mutableStateOf(TextToSpeechState())
    var state : State<TextToSpeechState> = _state

    private var textToSpeech : TextToSpeech? = null

    fun onGettingStartedEvent(event: GettingStartedEvent){
        when(event){
            GettingStartedEvent.onActionsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ACTIONS))
            }
            GettingStartedEvent.onBigClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.BIG))
            }
            is GettingStartedEvent.onPhraseClick -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        text = event.text
                    )
                    textToSpeech(event.context)
                }
            }
            GettingStartedEvent.onPoepleClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.PEOPLE))
            }
            is GettingStartedEvent.onTextfieldClick -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        text = event.text
                    )
                }
            }
            GettingStartedEvent.onThingsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.THINGS))
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