package com.example.finalprojectgroup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    TopAppBar (

        title = {
            Box(modifier = Modifier
                .fillMaxWidth(),
                Alignment.Center){
                Text(text = "BusRA")
            } },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Icon")
            }
        },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 8.dp,
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
//                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
            }
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
//                    }
        }
    )
}