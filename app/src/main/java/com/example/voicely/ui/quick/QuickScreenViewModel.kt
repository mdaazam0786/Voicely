package com.example.voicely.ui.quick

import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.View
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
class QuickScreenViewModel @Inject constructor() : ViewModel() {
    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var _state = mutableStateOf(TextToSpeechState())
    var state : State<TextToSpeechState> = _state

    private var textToSpeech : TextToSpeech? = null

    fun onQuickScreenEvent(event: QuickScreenEvent){
        when(event){
            QuickScreenEvent.onAboutMeClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ABOUT_ME))
            }
            QuickScreenEvent.onGreetingsAndMannerClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.GREETINGS_AND_MANNERS))
            }
            QuickScreenEvent.onNeedHelpClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.NEED_HELP))
            }
            is QuickScreenEvent.onPhraseClick -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        text = event.text
                    )
                    textToSpeech(event.context)
                }
            }
            QuickScreenEvent.onQuestionsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.QUESTIONS))
            }
            QuickScreenEvent.onRequestsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.REQUESTS))
            }
            QuickScreenEvent.onResponseClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.RESPONSE))
            }
            QuickScreenEvent.onStarterPhrasesClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.STARTER_PHRASES))
            }
            QuickScreenEvent.onUnderstandingsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.UNDERSTANDINGS))
            }
            QuickScreenEvent.onWishesClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.WISHES))
            }
            is QuickScreenEvent.onTextFieldClick -> {
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