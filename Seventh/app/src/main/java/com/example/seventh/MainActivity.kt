package com.example.seventh

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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.seventh.ui.theme.SeventhTheme
import com.example.seventh.unit.ArtUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val artUnitList = listOf(
            ArtUnit(R.drawable.img_1, "Title_1", "Tester_1", 2001),
            ArtUnit(R.drawable.img_2, "Title_2", "Tester_2", 2002),
            ArtUnit(R.drawable.img_3, "Title_3", "Tester_3", 2003),
        )

        setContent {
            SeventhTheme {
                ArtSpace(artUnitList, modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun ArtSpace(artUnitList: List<ArtUnit>, modifier: Modifier = Modifier) {
    var imgIndex by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = modifier
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            ArtInfo(artUnitList[imgIndex])
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ){
            Button(
                onClick = {
                    if(imgIndex == 0){
                        imgIndex = 2
                    }
                    else{
                        imgIndex--
                    }
                },
                modifier = Modifier.width(130.dp)
            ) {
                Text(
                    text = "previous"
                )
            }

            Button(
                onClick = {
                    if(imgIndex == 2){
                        imgIndex = 0
                    }
                    else{
                        imgIndex++
                    }
                },
                modifier = Modifier.width(130.dp)
            ) {
                Text(
                    text = "Next"
                )
            }
        }
    }
}

@Composable
fun ArtInfo(artUnit: ArtUnit, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.padding(top = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Surface(
            shadowElevation = 20.dp,
            modifier = modifier.align(Alignment.CenterHorizontally).weight(1f)
        ){
            Image(
                painter = painterResource(artUnit.imageResource),
                contentDescription = artUnit.title,
                contentScale = ContentScale.Fit,
                modifier = Modifier.padding(30.dp)
            )
        }

        Column(
            modifier = modifier
                .padding(vertical = 10.dp, horizontal = 30.dp).padding(top = 20.dp)
                .background(Color.LightGray).align(Alignment.CenterHorizontally),
        ){
            Text(
                text = artUnit.title,
                fontSize = 22.sp,
                modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)
            )
            Row(
                modifier = Modifier.padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            ){
                Text(
                    text = artUnit.artist,
                    fontWeight =  FontWeight.Bold
                )
                Text(text = "(${artUnit.createYear})")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val artUnitList = listOf(
        ArtUnit(R.drawable.img_1, "Title_1", "Tester_1", 2001),
        ArtUnit(R.drawable.img_2, "Title_2", "Tester_2", 2002),
        ArtUnit(R.drawable.img_3, "Title_3", "Tester_3", 2003),
    )

    SeventhTheme {
        ArtSpace(artUnitList, modifier = Modifier.fillMaxSize())
    }
}