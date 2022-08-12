package com.example.pokedex

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.relocationRequester
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

@Composable
fun PokemonItem(pokemon: Pokemon) {
    Card(
        modifier = Modifier.padding(8.dp,5.dp).fillMaxSize().height(100.dp,),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = pokemon.name)
        Image(
            painter = rememberImagePainter(
                data = pokemon.img.replace("http","https"),
                builder = {
                    scale(coil.size.Scale.FILL)
                    transformations(CircleCropTransformation())
                }),
            contentDescription ="desc",
            modifier = Modifier.fillMaxHeight()

        )
    }
}