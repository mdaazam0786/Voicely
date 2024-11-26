package com.example.voicely.ui.core_words

import android.content.Context
import com.example.voicely.ui.getting_started.GettingStartedEvent

sealed class CoreWordsEvent {
    data class onPhrasesClick(val context: Context, val text : String): CoreWordsEvent()
    data class onTextfieldClick(val text : String) : CoreWordsEvent()
}