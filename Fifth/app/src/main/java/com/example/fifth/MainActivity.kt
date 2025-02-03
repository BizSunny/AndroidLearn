package com.example.fifth

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fifth.ui.theme.FifthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FifthTheme {
                Greeting(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var index by remember{
        mutableIntStateOf(1)
    }

    var renIndex by remember{
        mutableIntStateOf(0)
    }

    val (imageResource, textResource) = when(index){
        1 -> R.drawable.lemon_tree to R.string.lemonade_text_1
        2 -> R.drawable.lemon_squeeze to R.string.lemonade_text_2
        3 -> R.drawable.lemon_drink to R.string.lemonade_text_3
        else -> R.drawable.lemon_restart to R.string.lemonade_text_4
    }

    Text(
        text = "Lemonade",
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(top = 10.dp, bottom = 10.dp),
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ){
        Box(
            modifier = Modifier.size(200.dp)
                .border(
                    2.dp,
                    shape = RoundedCornerShape(20.dp),
                    color = Color(0xFF69CDD8)
                )
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFA0EFE5)),
        ){
            Image(
                painter = painterResource(imageResource),
                contentDescription = index.toString(),
                modifier = modifier.clickable {
                    if(index == 1){
                        renIndex = (2..4).random()
                        index = (index % 4) + 1
                    }
                    else if(index == 2){
                        renIndex--

                        if(renIndex == 0){
                            index = 3
                        }
                    }
                    else{
                        index = (index % 4) + 1
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textResource),
            fontSize = 18.sp
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FifthTheme {
        Greeting(modifier = Modifier.fillMaxSize())
    }
}