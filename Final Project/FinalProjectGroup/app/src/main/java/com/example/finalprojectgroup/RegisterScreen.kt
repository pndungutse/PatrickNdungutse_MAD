package com.example.finalprojectgroup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
@Preview
fun RegisterScreen(navController: NavController) {
    val checkedState = remember { mutableStateOf(true) }
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = Color.Black,
        contentColor = MaterialTheme.colors.surface
    )
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
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.image_login),
                    contentDescription = stringResource(id = R.string.image1),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding()
                        .size(height = 200.dp, width = 350.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Text(
                    text = "WELCOME BACK!", fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 25.dp),
                    textAlign = TextAlign.Center, color = Color.Red,
                )
                Text(
                    text = "Login to control routes and buses", fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    textAlign = TextAlign.Center, color = Color.Black,
                )

                Column(modifier = Modifier
                    .padding(20.dp)) {
                    TextField(
                        value = "Full name",
                        label = { Text("Enter full name") },
//                          singleLine = true,
                        onValueChange = {  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(25.dp))
                            .background(color = Color.White)
                            .padding(top = 10.dp, bottom = 15.dp)
                    )

                    TextField(
                        value = "Email",
                        label = { Text("Enter Email") },
//                          singleLine = true,
                        onValueChange = {  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(25.dp))
                            .background(color = Color.White)
                            .padding(top = 10.dp, bottom = 15.dp)
                    )
                    TextField(
                        value = "Address",
                        label = { Text("Enter Address") },
//                          singleLine = true,
                        onValueChange = {  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(25.dp))
                            .background(color = Color.White)
                            .padding(top = 10.dp, bottom = 15.dp)
                    )

                    TextField(
                        value = "Password",
                        label = { Text("Enter Password") },
//                          singleLine = true,
                        onValueChange = {  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(25.dp))
                            .background(color = Color.White)
                            .padding(top = 10.dp, bottom = 10.dp)
                    )

                    Row() {
                        Checkbox(
//                              modifier= Modifier.background(color = Color.Black),
                            checked = checkedState.value,
                            onCheckedChange = { checkedState.value = it },
                            colors = CheckboxDefaults.colors(Color.Black)
                        )
                        Text(
                            text = "Remember me", fontSize = 16.sp,
                            modifier = Modifier
//                                  .fillMaxWidth()
                                .padding(top = 11.dp, bottom = 20.dp),
//                              color = Color.Black,
                        )
                    }
                    Row {
                        Button(colors = mainButtonColor, onClick = {}, modifier = Modifier.fillMaxWidth()
                            .padding(8.dp)) {
                            Text(text = "Register")
                        }
                    }
                }

            }
        }
    )
}