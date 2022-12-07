package com.example.lab4.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab4.model.MenuItem
import com.example.lab4.ui.compose.content.HomeContent
import com.example.lab4.ui.compose.content.SettingsContent
import com.example.lab4.ui.compose.content.ShopContent
import kotlinx.coroutines.launch
import com.example.lab4.R

// reference is from final project progress
@Composable
//@Preview
fun HomeScreen(
    navController: NavController){
    var bottonState by remember { mutableStateOf("Home") }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar (
                title = {
                    Box(modifier = Modifier
                        .fillMaxWidth(),
                        Alignment.Center){
                        Text(text = stringResource(id = R.string.lab_4))
                    } },
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                elevation = 8.dp,
                actions = {
                    IconButton(onClick = { navController.navigate("Profile") }) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                    }
                }
            )
        },


        content = {
            Box(modifier = Modifier
                .fillMaxSize(),
            ) {
                if (bottonState.equals(stringResource(id = R.string.home))) {
                    HomeContent()
                }
                else if(bottonState.equals(stringResource(id = R.string.shop))){
                    ShopContent()
                }else if(bottonState.equals(stringResource(id = R.string.settings))){
                    SettingsContent()
                }
            }
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
                backgroundColor = Color.Blue,
                contentColor = Color.White){

                BottomNavigationItem(
                    selected = bottonState== stringResource(id = R.string.home),
                    onClick = { bottonState="Home"},
                    label = { Text(text = stringResource(id = R.string.home)) },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
                )

                BottomNavigationItem(
                    selected = bottonState== stringResource(id = R.string.shop),
                    onClick = { bottonState="Shop"},
                    label = { Text(text = stringResource(id = R.string.shop)) },
                    icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null) }
                )
                BottomNavigationItem(
                    selected = bottonState==stringResource(id = R.string.settings),
//                    onClick = { navController.navigate("Information")},
                    onClick = { bottonState="Settings"},
                    label = { Text(text = stringResource(id = R.string.settings)) },
                    icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = null) }
                )
            }
        },
    )
}