package com.example.voicely.ui.languages.marathi

import android.content.Context
import com.example.voicely.ui.languages.hindi.HindiScreenEvent

sealed class MarathiScreenEvent {
    data class onTextFieldClick(val text: String) : MarathiScreenEvent()
    data class onSpeakClick(val text: String, val context: Context) : MarathiScreenEvent()
}