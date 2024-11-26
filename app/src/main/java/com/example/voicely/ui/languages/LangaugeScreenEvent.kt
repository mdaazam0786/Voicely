package com.example.voicely.ui.languages

import android.content.Context

sealed class LangaugeScreenEvent {
    object onHindiClick : LangaugeScreenEvent()
    object onMarathiClick : LangaugeScreenEvent()
    object onGujratiClick : LangaugeScreenEvent()
    object onKannadaClick : LangaugeScreenEvent()
    object onTeluguClick : LangaugeScreenEvent()
    data class onTextFieldClick(val text: String) : LangaugeScreenEvent()
    data class onSpeakClick(val text: String, val context: Context) : LangaugeScreenEvent()
}