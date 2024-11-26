package com.example.voicely.ui.languages.gujrati

import android.content.Context
import com.example.voicely.ui.languages.hindi.HindiScreenEvent

sealed class GujratiScreenEvent {
    data class onTextFieldClick(val text: String) : GujratiScreenEvent()
    data class onSpeakClick(val text: String, val context: Context) : GujratiScreenEvent()
}