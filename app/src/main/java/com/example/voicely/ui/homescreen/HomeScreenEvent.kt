package com.example.voicely.ui.homescreen

import android.content.Context

sealed class HomeScreenEvent {
    data class onTextFieldClick(val text : String) : HomeScreenEvent()
    data class onSpeakClick(val context: Context) : HomeScreenEvent()
    object onClearClick : HomeScreenEvent()
    object onQuickClick : HomeScreenEvent()
    object onGettingStartedClick : HomeScreenEvent()
    object onBasicClick : HomeScreenEvent()
    object onAdvancedClick : HomeScreenEvent()
    object onCoreWordsClick : HomeScreenEvent()
    object onOtherLanguageClick : HomeScreenEvent()
    object onDeleteClick : HomeScreenEvent()
}