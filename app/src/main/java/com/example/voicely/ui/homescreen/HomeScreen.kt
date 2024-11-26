package com.example.voicely.ui.homescreen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.voicely.R
import com.example.voicely.ui.languages.hindi.HindiScreenEvent
import com.example.voicely.util.UiEvent

@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
    onNavigate : (UiEvent.Navigate)->Unit
){

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        homeScreenViewModel.uiEvent.collect{event->
            when(event){

                is UiEvent.Navigate -> onNavigate(event)

                else -> Unit
            }

        }

    }
    Box(modifier = Modifier.fillMaxSize()){

        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Welcome To Voicely", fontWeight = FontWeight.ExtraBold, fontSize = 32.sp, modifier = Modifier.padding(vertical = 26.dp, horizontal = 16.dp))
            TextField(
                value = homeScreenViewModel.state.value.text,
                onValueChange = {
                    homeScreenViewModel.onHomeEvent(HomeScreenEvent.onTextFieldClick(it))
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .border(0.dp, color = Color.Transparent)
                ,
                placeholder = {
                    Text(text = "Enter Something...")
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                trailingIcon = {
                    IconButton(onClick = {
                        homeScreenViewModel.onHomeEvent(HomeScreenEvent.onSpeakClick(context))
                    },
                        modifier = Modifier.size(40.dp)) {
                        Icon(painter = painterResource(id = R.drawable.speak), contentDescription = null)
                    }
                }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .clickable {
                            homeScreenViewModel.onHomeEvent(HomeScreenEvent.onQuickClick)
                        },
                    colors = CardDefaults.cardColors(Color(0xff658afc))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Text(text = "Quick", color = Color.White, fontFamily = FontFamily(Font(R.font.poppins_regular)))
                    }
                }
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .clickable {
                            homeScreenViewModel.onHomeEvent(HomeScreenEvent.onGettingStartedClick)
                        },
                    colors = CardDefaults.cardColors(Color(0xff658afc))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Text(text = "Getting Started",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)), textAlign = TextAlign.Center)
                    }
                }
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .clickable {
                            homeScreenViewModel.onHomeEvent(HomeScreenEvent.onBasicClick)
                        },
                    colors = CardDefaults.cardColors(Color(0xff658afc))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Text(text = "Basic", color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .clickable {
                            homeScreenViewModel.onHomeEvent(HomeScreenEvent.onAdvancedClick)
                        },
                    colors = CardDefaults.cardColors(Color(0xff658afc))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Text(text = "Advanced", color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                    }
                }
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .clickable {
                            homeScreenViewModel.onHomeEvent(HomeScreenEvent.onCoreWordsClick)
                        },
                    colors = CardDefaults.cardColors(Color(0xff658afc))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Text(text = "Core Words", color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                    }
                }
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .clickable {
                            homeScreenViewModel.onHomeEvent(HomeScreenEvent.onOtherLanguageClick)
                        },
                    colors = CardDefaults.cardColors(Color(0xff658afc))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Text(text = "Languages", color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                    }
                }
            }
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth() // For a horizontal line
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(onClick = {
                    homeScreenViewModel.onHomeEvent(HomeScreenEvent.onSpeakClick(context))
                },
                    modifier = Modifier.size(100.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.mic) ,contentDescription = null)
                }
            }

        }
    }
}