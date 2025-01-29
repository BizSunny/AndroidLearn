package com.example.second

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.second.ui.theme.SecondTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val columnScroll = rememberScrollState()

    //1번
    Column (
        modifier = modifier.verticalScroll(columnScroll)
    ){
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = null,
        )

        Text(
            text = stringResource(R.string.content_title),
            modifier = modifier.padding(16.dp),
            fontSize = 24.sp,
        )

        Text(
            text = stringResource(R.string.content_body),
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = stringResource(R.string.content_tail),
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )

        //2번
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ){
            Image(
                painter = painterResource(R.drawable.ic_task_completed),
                contentDescription = null
            )

            Text(
                text = "All tasks completed",
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
            )

            Text(
                text = "Nice work!",
                fontSize = 16.sp
            )
        }

        //3번
        Column(
            modifier = modifier.fillMaxWidth(),
        ){
            Row(

            ){
                Column(modifier = modifier
                        .background(color = Color(0xFFEADDFF))
                        .weight(1f)
                        .padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,){
                    Text(
                        text = "Text composable",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Displays text and follows the recommended Material Design guidelines.",
                        textAlign = TextAlign.Justify
                    )
                }

                Column(modifier = modifier
                        .background(color = Color(0xFFD0BCFF))
                        .weight(1f)
                        .padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Image composable",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Creates a composable that lays out and draws a given Painter class object.",
                        textAlign = TextAlign.Justify
                    )
                }
            }

            Row(

            ){
                Column(modifier = modifier
                        .background(color = Color(0xFFB69DF8))
                        .weight(1f)
                        .padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                    Text(
                        text = "Row composable",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "A layout composable that places its children in a horizontal sequence.",
                        textAlign = TextAlign.Justify
                    )
                }

                Column(modifier = modifier
                        .background(color = Color(0xFFF6EDFF))
                        .weight(1f)
                        .padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Column composable",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "A layout composable that places its children in a vertical sequence.",
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SecondTheme {
        Greeting("Android")
    }
}