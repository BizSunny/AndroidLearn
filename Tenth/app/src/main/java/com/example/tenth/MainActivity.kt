package com.example.tenth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tenth.ui.theme.Shapes
import com.example.tenth.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WoofTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .statusBarsPadding()
                        .navigationBarsPadding()
                ) {
                    WoofApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.ic_woof_logo),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }
    )
}

@Composable
fun WoofApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            WoofTopAppBar()
        }
    ) {
        LazyColumn (contentPadding = it){
            items(
                items = dogs
            ) {
                DogItem(it)
            }
        }
    }
}

@Composable
fun DogItem(dog: Dog, modifier: Modifier = Modifier){
    var expanded by remember {
        mutableStateOf(false)
    }

    val color by animateColorAsState(
        targetValue = if(expanded){
            MaterialTheme.colorScheme.tertiaryContainer
        }
        else{
            MaterialTheme.colorScheme.primaryContainer
        }
    )

    Card (
        Modifier
            .fillMaxSize()
            .padding(
                start = dimensionResource(R.dimen.padding_small),
                end = dimensionResource(R.dimen.padding_small),
                bottom = dimensionResource(R.dimen.padding_small)
            )
    ){
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
                .background(color = color)
        ) {
            Row (
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ){
                DogIcon(dog.paintResourceID)
                DogInformation(dog.stringResourceID, dog.age, modifier)
                Spacer(modifier = Modifier.weight(1f))
                DogItemButton(
                    expanded = expanded,
                    onClick = {
                        expanded = !expanded
                    }
                )
            }
            if(expanded) {
                DogHobby(
                    dog.hobbyResourceID,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Composable
fun DogIcon(dogIcon: Int, modifier: Modifier = Modifier){
    Image(
        painter = painterResource(dogIcon),
        contentDescription = null,
        modifier = Modifier.size(100.dp).padding(dimensionResource(R.dimen.padding_small)).clip(Shapes.small),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun DogInformation(dogName: Int, dogAge: Int, modifier: Modifier = Modifier){
    Column (
    ){
        Text(
            text = stringResource(dogName),
            modifier = Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.displayMedium
        )

        Text(
            text = stringResource(R.string.years_old, dogAge),
            modifier = Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun DogItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            imageVector = if(expanded){
                Icons.Filled.ExpandLess
            }
            else{
                Icons.Filled.ExpandMore
            },
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary,
        )
    }
}

@Composable
fun DogHobby(
    @StringRes dogHobby: Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(dogHobby),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WoofTheme(darkTheme = false) {
        WoofApp()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingDarkPreview() {
    WoofTheme(darkTheme = true) {
        WoofApp()
    }
}