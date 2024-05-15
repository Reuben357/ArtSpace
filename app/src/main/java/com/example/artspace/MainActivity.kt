package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var result by remember {
        mutableStateOf(0)
    }
    when(result){
        1 -> {
            ArtWork(
                title = R.string.TGeorgesSeurat,
                year = R.string.George,
                imageResource = R.drawable.johannes,
                onPreview = { result--},
                onNext = { result++ })
        }

        2 -> {
            ArtWork(
                title = R.string.TSelfPortrait,
                year = R.string.SelfPortrait,
                imageResource = R.drawable.selfportrait,
                onPreview = { result--},
                onNext = { result++ })
        }
        3 -> {
            ArtWork(
                title = R.string.TEdvardMunch,
                year = R.string.EdvardMunch,
                imageResource = R.drawable.edvardmunch,
                onPreview = { result--},
                onNext = { result++ })
        }
        4 -> {
            ArtWork(
                title = R.string.TJohannes,
                year = R.string.JohannesVermeer,
                imageResource = R.drawable.johannes,
                onPreview = { result--},
                onNext = { result++ })
        }
        5 -> {
            ArtWork(
                title = R.string.TEugeneDelacroix,
                year = R.string.EugeneDelacroix,
                imageResource = R.drawable.eugenedelacroix,
                onPreview = { result--},
                onNext = { result++ })
        }

        else -> {
            ArtWork(
                title = R.string.TJeanAntoine,
                year = R.string.JeanAntoine,
                imageResource = R.drawable.jean_antoine,
                onPreview = { result--},
                onNext = { result++ })
        }
    }
}


@Composable
fun ArtWork(
    @StringRes title: Int,
    @StringRes year: Int,
    @DrawableRes imageResource: Int,
    onPreview: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = modifier
        )
        Card(
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(id = title),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                )
                Text(
                    text = stringResource(id = year),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = modifier.padding(top = 8.dp)
                )
            }
        }


        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxWidth()
        ){
            Button(
                onClick = onPreview
            ) {
                Text(text = "Previous")
            }

            Button(
                onClick = onNext
            ) {
                Text(text = "Next")
            }
        }
    }
}




@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}