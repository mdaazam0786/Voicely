package com.example.voicely.ui.languages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.voicely.R
import com.example.voicely.ui.quick.QuickScreenEvent
import com.example.voicely.util.Routes
import com.example.voicely.util.UiEvent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Languages(
    languageViewModel: LanguageViewModel = hiltViewModel(),
    popBackStack: () -> Unit,
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        languageViewModel.uiEvent.collect{event->
            when(event){

                is UiEvent.Navigate -> onNavigate(event)

                else -> Unit
            }

        }

    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Other Languages", fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)
            },
                navigationIcon = {
                    IconButton(onClick = { popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null )
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize(),
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(it)
            ) {
                stickyHeader {
                    TextField(
                        value = languageViewModel.state.value.text,
                        onValueChange = {
                            languageViewModel.onLanguageEvent(LangaugeScreenEvent.onTextFieldClick(it))
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .border(0.dp, color = Color.Transparent),
                        placeholder = {
                            Text(text = "Enter Something...")
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        trailingIcon = {
                            IconButton(onClick = {
                                languageViewModel.onLanguageEvent(LangaugeScreenEvent.onSpeakClick(languageViewModel.state.value.text, context))
                            },
                                modifier = Modifier.size(40.dp)) {
                                Icon(painter = painterResource(id = R.drawable.speak), contentDescription = null)
                            }
                        }

                    )
                }
                items(1){
                    Text(text = "More Places To Go", modifier = Modifier.padding(16.dp), fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceAround){
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    onNavigate(UiEvent.Navigate(Routes.HINDI))
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))

                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Hindi",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    languageViewModel.onLanguageEvent(LangaugeScreenEvent.onTeluguClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))

                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Telugu",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    languageViewModel.onLanguageEvent(LangaugeScreenEvent.onKannadaClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))

                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Kannada",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceAround){
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    languageViewModel.onLanguageEvent(LangaugeScreenEvent.onMarathiClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))

                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Marathi",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    languageViewModel.onLanguageEvent(LangaugeScreenEvent.onGujratiClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))

                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Gujrati",color = Color.White,fontFamily = FontFamily(
                                    Font(R.font.poppins_regular)
                                )
                                )
                            }
                        }
                    }
                }
            }
        }

    )


}