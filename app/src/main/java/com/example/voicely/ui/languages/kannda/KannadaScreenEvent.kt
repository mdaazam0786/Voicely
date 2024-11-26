package com.example.voicely.ui.languages.kannda

import android.content.Context
import com.example.voicely.ui.languages.hindi.HindiScreenEvent

sealed class KannadaScreenEvent {
    data class onTextFieldClick(val text: String) : KannadaScreenEvent()
    data class onSpeakClick(val text: String, val context: Context) : KannadaScreenEvent()
}