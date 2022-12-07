package com.example.lab4.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lab4.R
import androidx.navigation.NavController

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit,
//    navController: NavController
) {
    TopAppBar (
        title = {
            Box(modifier = Modifier
                .fillMaxWidth(),
                Alignment.Center){
                Text(text = stringResource(id = R.string.lab_4))
            } },
//        navigationIcon = {
//            IconButton(onClick = onNavigationIconClick) {
//                Icon(imageVector = Icons.Default.Menu, contentDescription = "Icon")
//            }
//        },
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 8.dp,
        actions = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            }
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
//                    }
        }
    )
}