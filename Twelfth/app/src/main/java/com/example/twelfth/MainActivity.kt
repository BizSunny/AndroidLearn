package com.example.twelfth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.TwelfthTheme
import com.example.twelfth.data.Days
import com.example.twelfth.data.dayList
import com.example.ui.theme.AppTypography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwelfthTheme(darkTheme = true){
                DaysApp(modifier = Modifier.fillMaxSize().statusBarsPadding().navigationBarsPadding())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaysApp(modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(R.string.appbar_title))
                }
            )
        }
    ){
        DayListView(modifier = Modifier.padding(it))
    }
}

@Composable
fun DayListView(modifier: Modifier = Modifier){
    LazyColumn (
        modifier = modifier.fillMaxSize().padding(8.dp)
    ){
        items(
            items = dayList
        ){
            DayItem(it)
        }
    }
}

@Composable
fun DayItem(day: Days, modifier: Modifier = Modifier){
    var expanded by remember {
        mutableStateOf(false)
    }

    Card (
        modifier = modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ){
        Column (
        ) {
            Text(
                text = stringResource(day.day),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 8.dp, bottom = 5.dp)
            )
            Text(
                text = stringResource(day.dayDescriptor),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 8.dp, bottom = 5.dp)
            )
            Image(
                painter = painterResource(day.dayImage),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
                    .clickable(
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                        indication = null
                    ){
                        expanded = !expanded
                    }
            )

            if(expanded){
                Column {
                    Text(
                        text = stringResource(day.dayContent),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 8.dp, bottom = 5.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TwelfthTheme {
        DaysApp()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingDarkPreview() {
    TwelfthTheme(darkTheme = true) {
        DaysApp()
    }
}