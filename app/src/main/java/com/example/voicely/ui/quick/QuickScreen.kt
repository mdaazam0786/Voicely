package com.example.voicely.ui.quick

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.voicely.R
import com.example.voicely.util.UiEvent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun QuickScreen(
    quickScreenViewModel: QuickScreenViewModel = hiltViewModel(),
    popBackStack: () -> Unit,
) {
    val quickPhrases = listOf(
        "Yes",
        "No",
        "Stop",
        "I can't find the picture",
        "I want to spell",
        "Please make a schedule",
        "All Done",
        "I want to go to the toilet",
        "I mean something else",
        "Ask me yes no questions",
        "Already Happened",
        "It's an emergency",
        "Call 911",
    )
    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Quick", fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)
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
                    value = quickScreenViewModel.state.value.text,
                    onValueChange = {
                        quickScreenViewModel.onQuickScreenEvent(QuickScreenEvent.onTextFieldClick(it))
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
                            quickScreenViewModel.onQuickScreenEvent(QuickScreenEvent.onPhraseClick(context, quickScreenViewModel.state.value.text))
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
                                quickScreenViewModel.onQuickScreenEvent(QuickScreenEvent.onAboutMeClick)
                            },
                        colors = CardDefaults.cardColors(Color(0xff658afc))
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Text(text = "About Me",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .clickable {
                                quickScreenViewModel.onQuickScreenEvent(QuickScreenEvent.onWishesClick)
                            },
                        colors = CardDefaults.cardColors(Color(0xff658afc))
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Text(text = "Wishes",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .clickable {
                                quickScreenViewModel.onQuickScreenEvent(QuickScreenEvent.onNeedHelpClick)
                            },
                        colors = CardDefaults.cardColors(Color(0xff658afc))
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Text(text = "I Need Help",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
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
                                quickScreenViewModel.onQuickScreenEvent(QuickScreenEvent.onResponseClick)
                            },
                        colors = CardDefaults.cardColors(Color(0xff658afc))
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Text(text = "Responses",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .clickable {
                                quickScreenViewModel.onQuickScreenEvent(QuickScreenEvent.onRequestsClick)
                            },
                        colors = CardDefaults.cardColors(Color(0xff658afc))
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Text(text = "Requests",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)))
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .clickable {
                                quickScreenViewModel.onQuickScreenEvent(QuickScreenEvent.onUnderstandingsClick)
                            },
                        colors = CardDefaults.cardColors(Color(0xff658afc))
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Text(text = "Understandings",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)), textAlign = TextAlign.Center)
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ){
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .clickable {
                                quickScreenViewModel.onQuickScreenEvent(QuickScreenEvent.onGreetingsAndMannerClick)
                            },
                        colors = CardDefaults.cardColors(Color(0xff658afc))
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Text(text = "Greetings And Manners",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)),textAlign = TextAlign.Center)
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .clickable {
                                quickScreenViewModel.onQuickScreenEvent(QuickScreenEvent.onStarterPhrasesClick)
                            },
                        colors = CardDefaults.cardColors(Color(0xff658afc))
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                            Text(text = "Starter Phrases",color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)),textAlign = TextAlign.Center)
                        }
                    }
                }
                Text(text = "Phrases", modifier = Modifier.padding(16.dp), fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
                SimpleVerticalGridQuick(items = quickPhrases, context)
            }

        }
        }
    )

}
@Composable
fun SimpleVerticalGridQuick(
    items: List<String>,
    context: Context,
    quickScreenViewModel: QuickScreenViewModel = hiltViewModel(),
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
                                quickScreenViewModel.onQuickScreenEvent(
                                    QuickScreenEvent.onPhraseClick(
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
                                text = item,color = Color.White,fontFamily = FontFamily(Font(R.font.poppins_regular)),textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}