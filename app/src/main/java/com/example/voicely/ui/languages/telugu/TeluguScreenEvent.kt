package com.example.voicely.ui.languages.telugu

import android.content.Context
import com.example.voicely.ui.languages.hindi.HindiScreenEvent

sealed class TeluguScreenEvent {
    data class onTextFieldClick(val text: String) : TeluguScreenEvent()
    data class onSpeakClick(val text: String, val context: Context) : TeluguScreenEvent()
}