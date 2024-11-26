package com.example.voicely.ui.languages.hindi

import android.content.Context
import com.example.voicely.ui.languages.LangaugeScreenEvent

sealed class HindiScreenEvent {
    data class onTextFieldClick(val text: String) : HindiScreenEvent()
    data class onSpeakClick(val text: String, val context: Context) : HindiScreenEvent()
}