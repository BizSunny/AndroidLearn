package com.example.third

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.third.ui.theme.ThirdTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirdTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.main_background))){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
        ){
            Box(modifier = modifier
                    .background(color = colorResource(R.color.main_icon_background))
                    .size(150.dp)){
                Image(
                    painter = painterResource(R.drawable.android_logo),
                    contentDescription = null,
                )
            }
            Text(
                text = "Jennifer Doe",
                fontSize = 52.sp,
                modifier = modifier.padding(top = 10.dp, bottom = 15.dp)
            )
            Text(
                text = "Android Developer Extraordinaire",
                color = colorResource(R.color.main_title_text)
            )
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ){
            BottomContent(
                imgID = R.drawable.baseline_call_24,
                info = "+11 (123) 444 555 666",
            )
            BottomContent(
                imgID = R.drawable.baseline_share_24,
                info = "@AndroidDev",
                modifier = modifier.padding(top = 10.dp, bottom = 10.dp)
            )
            BottomContent(
                imgID = R.drawable.baseline_email_24,
                info = "jen doe@android.com",
                modifier = modifier.padding(bottom = 80.dp)
            )
        }
    }
}

@Composable
fun BottomContent(imgID: Int, info: String, modifier: Modifier = Modifier){
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Image(
            painter = painterResource(imgID),
            contentDescription = null,
            modifier = modifier
        )
        Text(
            text = info,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThirdTheme {
        Greeting()
    }
}