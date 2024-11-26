package com.example.voicely.ui.quick

import android.content.Context
import com.example.voicely.ui.homescreen.HomeScreenEvent

sealed class QuickScreenEvent {
    data class onPhraseClick(val context: Context, val text : String) : QuickScreenEvent()
    data class onTextFieldClick(val text : String) : QuickScreenEvent()
    object onGreetingsAndMannerClick : QuickScreenEvent()
    object onWishesClick : QuickScreenEvent()
    object onNeedHelpClick : QuickScreenEvent()
    object onRequestsClick : QuickScreenEvent()
    object onUnderstandingsClick : QuickScreenEvent()
    object onQuestionsClick : QuickScreenEvent()
    object onAboutMeClick : QuickScreenEvent()
    object onStarterPhrasesClick : QuickScreenEvent()
    object onResponseClick : QuickScreenEvent()

}