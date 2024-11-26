package com.example.voicely.ui.basic

import android.content.Context
import com.example.voicely.ui.quick.QuickScreenEvent

sealed class BasicScreenEvent {
    object onPeopleClick : BasicScreenEvent()
    object onBigSmallClick : BasicScreenEvent()
    object onThingsClick : BasicScreenEvent()
    object onEatClick : BasicScreenEvent()
    object onPlayClick : BasicScreenEvent()
    object onGoClick : BasicScreenEvent()
    object onWearClick : BasicScreenEvent()
    object onColorsClick : BasicScreenEvent()
    object onSchoolClick : BasicScreenEvent()
    object onBodyClick : BasicScreenEvent()
    object onFeelingsClick : BasicScreenEvent()
    object onActionsClick : BasicScreenEvent()
    object onAnimalClick : BasicScreenEvent()
    object onCountingClick : BasicScreenEvent()
    data class onPhraseClick(val context: Context, val text : String) : BasicScreenEvent()
    data class onTextFieldClick(val text : String) : BasicScreenEvent()
}