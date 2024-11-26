package com.example.voicely.ui.languages.telugu

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.voicely.R
import com.example.voicely.ui.languages.hindi.HindiScreenEvent
import com.example.voicely.ui.languages.hindi.HindiScreenViewModel
import com.example.voicely.ui.languages.hindi.SimpleVerticalGridHindi

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun TeluguScreen(
    teluguScreenViewModel: TeluguScreenViewModel = hiltViewModel(),
    popBackStack : () -> Unit
) {
    val coreWordsPhrases = listOf(
        "I",
        "me",
        "my",
        "you",
        "your",
        "it",
        "that",
        "this",
        "am",
        "are",
        "be",
        "been",
        "can",
        "come",
        "could",
        "do",
        "don't",
        "drink",
        "eat",
        "go",
        "have",
        "help",
        "is",
        "let",
        "like",
        "need",
        "play",
        "stop",
        "want",
        "was",
        "were",
        "will",
        "would",
        "another",
        "any",
        "full",
        "more",
        "not",
        "only",
        "other",
        "no",
        "please",
        "sorry",
        "thank you",
        "yes",
        "here",
        "there",
        "before",
        "never",
        "now",
        "what",
        "a",
        "about",
        "after",
        "again",
        "all",
        "also",
        "an",
        "and",
        "as",
        "at",
        "because",
        "but",
        "by",
        "else",
        "for",
        "from",
        "if",
        "in",
        "may",
        "of",
        "off",
        "on",
        "or",
        "out",
        "so",
        "still",
        "than",
        "the",
        "to",
        "up",
        "with",
        "without",
        "word"
    )
    val context = LocalContext.current
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Telugu", fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)
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
                        value = teluguScreenViewModel.state.value.text,
                        onValueChange = {
                            teluguScreenViewModel.onTeluguScreenEvent(TeluguScreenEvent.onTextFieldClick(it))
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
                                teluguScreenViewModel.onTeluguScreenEvent(TeluguScreenEvent.onSpeakClick(teluguScreenViewModel.state.value.text,context))
                            },
                                modifier = Modifier.size(40.dp)) {
                                Icon(painter = painterResource(id = R.drawable.speak), contentDescription = null)
                            }
                        }

                    )
                }
                items(1){
                    Text(text = "Phrases", modifier = Modifier.padding(16.dp), fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
                    SimpleVerticalGridTelugu(items = coreWordsPhrases, context = context)

                }
            }
        }
    )

}
@Composable
fun SimpleVerticalGridTelugu(
    items: List<String>,
    context: Context,
    teluguScreenViewModel: TeluguScreenViewModel = hiltViewModel()
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
                                teluguScreenViewModel.onTeluguScreenEvent(TeluguScreenEvent.onSpeakClick(item,context))
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
