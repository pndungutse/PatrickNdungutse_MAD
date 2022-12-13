package com.example.finalprojectgroup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalprojectgroup.ui.theme.FinalProjectGroupTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyBottomNavigation()
            Nav()
        }
    }
}

@Composable
fun MyBottomNavigation(){
    var bottonState by remember { mutableStateOf("Home") }
    Scaffold(
        topBar = {
            TopAppBar (
                title = {
                    Box(modifier = Modifier
                        .fillMaxWidth(),
                        Alignment.Center){
                        Text(text = "BRA")
                    } },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Icon")
                    }
                },
                backgroundColor = Color.Red,
                contentColor = Color.White,
                elevation = 8.dp,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
                    }
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
//                    }
                }
            )
        },
        content = {
                  Box(modifier = Modifier
                      .fillMaxSize(),
                  Alignment.Center) {
                      Text(text = bottonState, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                  }
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
                backgroundColor = Color.Red,
                contentColor = Color.White){

                BottomNavigationItem(
                    selected = bottonState=="Home",
                    onClick = { bottonState="Home"},
                    label = {Text(text = "Home")},
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null)}
                )

                BottomNavigationItem(
                    selected = bottonState=="Share",
                    onClick = { bottonState="Share"},
                    label = {Text(text = "Share")},
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null)}
                )
                BottomNavigationItem(
                    selected = bottonState=="Follow",
                    onClick = { bottonState="Follow"},
                    label = {Text(text = "Follow")},
                    icon = { Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)}
                )
                BottomNavigationItem(
                    selected = bottonState=="Account",
                    onClick = { bottonState="Account"},
                    label = {Text(text = "Account")},
                    icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)}
                )

            }
        }
    )
}
@Composable
fun MyAppBar() {
    Scaffold(
        topBar = {
            TopAppBar (
                title = {
                    Box(modifier = Modifier
                        .fillMaxWidth(),
                        Alignment.Center){
                        Text(text = "BRA")
                    } },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Icon")
                    }
                },
                backgroundColor = Color.Red,
                contentColor = Color.White,
                elevation = 8.dp,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
                    }
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
//                    }
                }
            )
        }
    ) {

    }
}

@Preview()
@Composable
fun DefaultPreview() {
//    MyAppBar()
//    MyBottomNavigation()
    Nav()
}