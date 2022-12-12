package com.example.finalprojectgroup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalprojectgroup.screens.FollowRoute
import com.example.finalprojectgroup.screens.RoutesScreen
import com.example.finalprojectgroup.ui.theme.DrawerBody
import com.example.finalprojectgroup.ui.theme.DrawerHeader
import kotlinx.coroutines.launch

@Composable
//@Preview
fun HomeScreen(navController: NavController){
    var bottonState by remember { mutableStateOf("Share") }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },

        content = {
            Box(modifier = Modifier
                .fillMaxSize(),
                ) {
                if (bottonState.equals("Home")) {
//                    Text(text = bottonState, fontSize = 25.sp, fontWeight = FontWeight.Bold)
//                    InfoScreen()
                    RoutesScreen(navController)
                }else if(bottonState.equals("Share")){
                    RoutesScreen(navController)
//                    Text(text = "Share map screen", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                }else if(bottonState.equals("Follow")){
//                    Text(text = "Follow map screen", fontSize = 25.sp, fontWeight = FontWeight.Bold)
//                    InfoScreen()
                    FollowRoute()

                }
                else if(bottonState.equals("About")){
//                    Text(text = "Account screen", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    InfoScreen()
                }
            }
        },
        bottomBar = {
            BottomNavigation(

                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
                backgroundColor = Color.Red,
                contentColor = Color.White){

                BottomNavigationItem(
                    selected = bottonState=="Share",
                    onClick = { bottonState="Share"},
                    label = { Text(text = "Share") },
                    icon = { Icon(imageVector = Icons.Default.Place, contentDescription = null) }
                )
                BottomNavigationItem(
                    selected = bottonState=="Follow",
//                    onClick = { navController.navigate("Information")},
                    onClick = { bottonState="Follow"},
                    label = { Text(text = "Follow") },
                    icon = { Icon(imageVector = Icons.Default.LocationOn, contentDescription = null) }
                )
                BottomNavigationItem(
                    selected = bottonState=="About",
                    onClick = { bottonState="About"},
                    label = { Text(text = "About") },
                    icon = { Icon(imageVector = Icons.Default.Info, contentDescription = null) }
                )
//                BottomNavigationItem(
//                    selected = bottonState=="About",
//                    onClick = { bottonState="About"},
//                    label = { Text(text = "About") },
//                    icon = { Icon(imageVector = Icons.Default.Info, contentDescription = null) }
//                )
            }
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            Column(
                modifier = Modifier
                    .background(color = Color.Red)
                    .fillMaxHeight()
            ) {
                DrawerHeader()
                DrawerBody(
                    items = listOf(
                        MenuItem(
                            id = "home",
                            title = "Home",
                            contentDescription = "Go to home screen",
                            icon = Icons.Default.Home
                        ),
//                        MenuItem(
//                            id = "share",
//                            title = "Share",
//                            contentDescription = "Go to shuttles screen",
//                            icon = Icons.Default.LocationOn
//                        ),
//                        MenuItem(
//                            id = "follow",
//                            title = "Follow",
//                            contentDescription = "Follow Location",
//                            icon = Icons.Default.Place
//                        ),
//                        MenuItem(
//                            id = "account",
//                            title = "Account",
//                            contentDescription = "Go to account screen",
//                            icon = Icons.Default.AccountCircle
//                        ),
                    ),
                    onItemClick = {
//                        println("Clicked on ${it.title}")
                        navController.navigate(it.title)
                    }
                )
            }
        }
    )
}