package com.example.eleventh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.EleventhTheme
import com.example.eleventh.model.HeroesRepository.heroes
import com.example.ui.theme.AppTypography


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EleventhTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize().statusBarsPadding().navigationBarsPadding()
                ) {
                    Superheroes()
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Superheroes(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.displayLarge
                    )
                },
            )
        }
    ) {
        HeroesListView(modifier = Modifier.padding(it))
    }
}

@Composable
fun HeroesListView(modifier: Modifier = Modifier){
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = heroes
        ){
            HeroesScreen().HeroesCard(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroesPreview() {
    EleventhTheme(darkTheme = false) {
        Superheroes()
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroesDarkPreview() {
    EleventhTheme(darkTheme = true) {
        Superheroes()
    }
}