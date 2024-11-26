package com.example.voicely.ui.basic

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.voicely.ui.quick.QuickScreenEvent
import com.example.voicely.ui.quick.QuickScreenViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun BasicScreen(
    basicScreenViewModel: BasicScreenViewModel = hiltViewModel(),
    popBackStack: () -> Unit,
) {
    val basicPhrases = listOf(
        "I",
        "You",
        "Like",
        "Want",
        "Do",
        "That",
        "Not",
        "Stop",
        "Help Me",
        "Gone"
    )
    val context = LocalContext.current


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Basic", fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)
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
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                stickyHeader {
                    TextField(
                        value = basicScreenViewModel.state.value.text,
                        onValueChange = {
                            basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onTextFieldClick(it))
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
                                basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onPhraseClick(context,basicScreenViewModel.state.value.text))
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
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onPeopleClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "People",color = Color.White,fontFamily = FontFamily(
                                    Font(R.font.poppins_regular)
                                )
                                )
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onBigSmallClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Big,Small..",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onThingsClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Things",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
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
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onEatClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Eat",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onPlayClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Play",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onGoClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Go",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
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
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onWearClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Wear",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onColorsClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Colors",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onSchoolClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "School",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
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
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onBodyClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Body",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onFeelingsClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Feelings",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onActionsClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Actions",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
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
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onAnimalClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Animals,Birds and Plants",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)),textAlign = TextAlign.Center)
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    basicScreenViewModel.onBasicScreenEvent(BasicScreenEvent.onCountingClick)
                                },
                            colors = CardDefaults.cardColors(Color(0xff658afc))
                        ) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                                Text(text = "Counting",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                            }
                        }
                    }
                    Text(text = "Phrases", modifier = Modifier.padding(16.dp), fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
                    SimpleVerticalGridBasic(items = basicPhrases, context = context)
                }
            }
        }
    )
}
@Composable
fun SimpleVerticalGridBasic(
    items: List<String>,
    context: Context,
    basicScreenViewModel: BasicScreenViewModel = hiltViewModel(),
) {
    Column {
        items.chunked(3).forEach { rowItems ->
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                rowItems.forEach { item ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clickable {
                                basicScreenViewModel.onBasicScreenEvent(
                                    BasicScreenEvent.onPhraseClick(
                                        context,
                                        item
                                    )
                                )
                            },
                        colors = CardDefaults.cardColors(Color(0xff71d268))
                    ) {
                        Box(modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = item,
                                color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular))
                            )
                        }
                    }
                }
            }
        }
    }
}