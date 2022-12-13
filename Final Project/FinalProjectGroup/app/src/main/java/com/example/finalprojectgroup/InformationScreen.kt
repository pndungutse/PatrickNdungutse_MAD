package com.example.finalprojectgroup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
@Preview
fun InformationScreen(navController: NavController){
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
              Column(
                  modifier = Modifier
                      .verticalScroll(rememberScrollState())
                      .padding(25.dp),
              ) {
                    Text(
                        text = "OUR",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                    Text(
                        text = "MISSION",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        modifier = Modifier.padding(bottom = 0.dp)
                    )
                  Image(
                      painter = painterResource(id = R.drawable.image_login),
                      contentDescription = stringResource(id = R.string.image1),
                      contentScale = ContentScale.Crop,
                      modifier = Modifier
                          .padding()
                          .size(height = 200.dp, width = 350.dp)
                          .clip(RoundedCornerShape(16.dp))
                  )
                  Text(text = "The Bus Routing Application's purpose is based on three factors. The first step is for students and app users to maximize their time by developing a good personal plan and being well-prepared so they are not late or early. The second goal is to find solutions to transportation issues, such as providing exceptional service while using few resources and increasing student productivity by reducing the amount of time spent waiting for buses, which causes high levels of fatigue", fontSize = 10.sp,
                  modifier = Modifier
                      .padding(start = 5.dp, end = 10.dp, bottom = 10.dp)
                  )

                  Text(text = "We make sure you don't spend time on bus stop waiting for a bus that you don't know when is coming", fontSize = 15.sp, fontWeight = FontWeight.Bold,
                      modifier = Modifier
                          .padding(start = 10.dp, end = 10.dp, bottom = 5.dp)
                  )

                  Text(
                      text = "OUR",
                      fontSize = 20.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.Red
                  )
                  Text(
                      text = "MISSION",
                      fontSize = 30.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color.Red,
                      modifier = Modifier.padding(bottom = 0.dp)
                  )
                  Image(
                      painter = painterResource(id = R.drawable.image_story1),
                      contentDescription = stringResource(id = R.string.image1),
                      contentScale = ContentScale.Crop,
                      modifier = Modifier.align(Alignment.CenterHorizontally)
                          .padding()
                          .size(height = 275.dp, width = 150.dp)
                          .clip(RoundedCornerShape(16.dp))
                  )
                  Text(text = "The Bus Routing Application's purpose is based on three factors. The first step is for students and app users to maximize their time by developing a good personal plan and being well-prepared so they are not late or early. The second goal is to find solutions to transportation issues, such as providing exceptional service while using few resources and increasing student productivity by reducing the amount of time spent waiting for buses, which causes high levels of fatigue", fontSize = 10.sp,
                      modifier = Modifier
                          .padding(start = 5.dp, end = 10.dp, bottom = 10.dp)
                  )

                }
        }
    )
}


