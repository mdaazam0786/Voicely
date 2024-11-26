package com.example.voicely.ui.homescreen

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.voicely.util.Routes
import com.example.voicely.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {

    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var _state = mutableStateOf(TextToSpeechState())
    var state : State<TextToSpeechState> = _state

    private var textToSpeech : TextToSpeech? = null



    fun onHomeEvent(event: HomeScreenEvent) {
        when(event) {
            is HomeScreenEvent.onTextFieldClick -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        text = event.text
                    )
                }
            }

            HomeScreenEvent.onClearClick -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        text = ""
                    )
                }
            }

            is HomeScreenEvent.onSpeakClick -> {
                textToSpeech(event.context)
            }

            HomeScreenEvent.onAdvancedClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADVANCED))
            }
            HomeScreenEvent.onBasicClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.BASIC))
            }
            HomeScreenEvent.onCoreWordsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.CORE_WORDS))
            }
            HomeScreenEvent.onGettingStartedClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.GETTING_STARTED))
            }
            HomeScreenEvent.onOtherLanguageClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.LANGUAGES))
            }
            HomeScreenEvent.onQuickClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.QUICK))
            }
            HomeScreenEvent.onDeleteClick->{
                viewModelScope.launch {
                    val currentState = state.value
                    if(currentState.text.isNotBlank()){
                        _state.value = currentState.copy(
                            text =  currentState.text.dropLast(1)
                        )
                    }
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