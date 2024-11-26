package com.example.voicely

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.voicely.ui.basic.BasicScreen
import com.example.voicely.ui.core_words.CoreWordsScreen
import com.example.voicely.ui.getting_started.AdvancedScreen
import com.example.voicely.ui.getting_started.GettingStartedScreen
import com.example.voicely.ui.homescreen.HomeScreen
import com.example.voicely.ui.languages.LangaugeScreenEvent
import com.example.voicely.ui.languages.Languages
import com.example.voicely.ui.languages.gujrati.GujratiScreen
import com.example.voicely.ui.languages.hindi.HindiScreen
import com.example.voicely.ui.languages.kannda.KannadaScreen
import com.example.voicely.ui.languages.marathi.MarathiScreen
import com.example.voicely.ui.languages.telugu.TeluguScreen
import com.example.voicely.ui.quick.QuickScreen
import com.example.voicely.ui.theme.VoicelyTheme
import com.example.voicely.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VoicelyTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.HOME ){
                    composable(Routes.HOME){
                        HomeScreen(
                            onNavigate = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                    composable(Routes.QUICK){
                        QuickScreen(
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(Routes.BASIC){
                        BasicScreen(
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(Routes.GETTING_STARTED){
                        GettingStartedScreen(
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(Routes.ADVANCED){
                        AdvancedScreen(
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(Routes.CORE_WORDS){
                        CoreWordsScreen(
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(Routes.LANGUAGES){
                        Languages(
                            popBackStack = {
                                navController.popBackStack()
                            },
                            onNavigate = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                    composable(Routes.HINDI){
                        HindiScreen(
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(Routes.TELUGU){
                        TeluguScreen(
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(Routes.MARATHI){
                        MarathiScreen (
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(Routes.KANNADA){
                        KannadaScreen(
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(Routes.GUJRATI){
                        GujratiScreen(
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }

            }
        }
    }
    }
}

