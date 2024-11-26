package com.example.voicely.ui.getting_started

import android.content.Context

sealed class GettingStartedEvent {
    data class onPhraseClick(val context: Context, val text : String):GettingStartedEvent()
    data class onTextfieldClick(val text : String) : GettingStartedEvent()
    object onThingsClick : GettingStartedEvent()
    object onPoepleClick : GettingStartedEvent()
    object onBigClick : GettingStartedEvent()
    object onActionsClick : GettingStartedEvent()
}