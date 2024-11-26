package com.example.voicely.ui.basic

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
class BasicScreenViewModel @Inject constructor()
    : ViewModel() {

    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var _state = mutableStateOf(TextToSpeechState())
    var state : State<TextToSpeechState> = _state

    private var textToSpeech : TextToSpeech? = null

    fun onBasicScreenEvent(event: BasicScreenEvent){
        when(event){
            BasicScreenEvent.onActionsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ACTIONS))
            }
            BasicScreenEvent.onAnimalClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ANIMALS))
            }
            BasicScreenEvent.onBigSmallClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.BIG))
            }
            BasicScreenEvent.onBodyClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.BODY))
            }
            BasicScreenEvent.onColorsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.COLORS))
            }
            BasicScreenEvent.onCountingClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.COUNTING))
            }
            BasicScreenEvent.onEatClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.EAT))
            }
            BasicScreenEvent.onFeelingsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.FEELINGS))
            }
            BasicScreenEvent.onGoClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.GO))
            }
            BasicScreenEvent.onPeopleClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.PEOPLE))
            }
            is BasicScreenEvent.onPhraseClick -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        text = event.text
                    )
                    textToSpeech(event.context)
                }
            }
            BasicScreenEvent.onPlayClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.PLAY))
            }
            BasicScreenEvent.onSchoolClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.SCHOOL))
            }
            is BasicScreenEvent.onTextFieldClick -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        text = event.text
                    )
                }
            }
            BasicScreenEvent.onThingsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.THINGS))
            }
            BasicScreenEvent.onWearClick -> {

                sendUiEvent(UiEvent.Navigate(Routes.WEAR))
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