package com.example.voicely.ui.advanced

import android.content.Context

sealed class AdvancedScreenEvent {
    data class onTextfieldClick(val text : String) : AdvancedScreenEvent()
    data class onPhrasesClick(val context: Context, val text : String) : AdvancedScreenEvent()
    object onStarterPhrasesClick : AdvancedScreenEvent()
    object onQuestionsClick : AdvancedScreenEvent()
    object onBodyClick : AdvancedScreenEvent()
    object onFeelClick : AdvancedScreenEvent()
}