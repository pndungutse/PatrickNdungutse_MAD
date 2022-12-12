package com.example.finalprojectgroup

import android.view.RoundedCorner
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
@Preview
fun ContactScreen(navController: NavController){
//    var bottonState by remember { mutableStateOf("Home") }
    val textfieldName = remember { mutableStateOf(value = "")}
    val textfieldEmail = remember { mutableStateOf(value = "")}
    val textfieldMessage = remember { mutableStateOf(value = "")}
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
                .padding(10.dp)
                .background(color = Color.Red)
                .clip(shape = RoundedCornerShape(15.dp))
                .fillMaxSize(),
//                Alignment.Center
                ) {
                Column(modifier = Modifier.padding(25.dp)) {
                    Text(text = "GET IN TOUCH", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text(text = "Have any question? Do not hesitate to reach out to us", fontSize = 16.sp, color = Color.White)

                    Row(modifier = Modifier
                        .padding(top = 25.dp)) {
                        Icon(imageVector = Icons.Default.MailOutline, contentDescription = null)
                        Text(text = "info@group-bra.com", fontSize = 16.sp, color = Color.White)
                    }
                    Row(modifier = Modifier
                        .padding(top = 15.dp)) {
                        Icon(imageVector = Icons.Default.Call, contentDescription = null)
                        Text(text = "+250788471299", fontSize = 16.sp, color = Color.White)
                    }
                    Row(modifier = Modifier
                        .padding(top = 15.dp, bottom = 25.dp)) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        Text(text = "KN 67 Street Nyarugenge, Kigali", fontSize = 16.sp, color = Color.White)
                    }

                    Row(modifier = Modifier
                        .padding(top = 15.dp, bottom = 30.dp)) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = null)
                        Icon(imageVector = Icons.Default.Info, contentDescription = null)
                        Icon(imageVector = Icons.Default.Info, contentDescription = null)
                    }

                        Column(modifier = Modifier.padding(bottom = 20.dp)) {
                            NameTextField(name = textfieldName.value, changed = {textfieldName.value = it})

//                            EmailTextField(email = textfieldEmail.value, changed = {textfieldEmail.value = it})
//                            MessageTextField(message = textfieldMessage.value, changed = {textfieldMessage.value = it})
                        }

                    submitButton({})

                }
            }

        }
    )
}

@Composable
fun NameTextField(name: String, changed: (String) -> Unit){
    TextField(
//        text = stringResource(id = R.string.greeting) + " " + newName,
        value = name,
        label = { Text(stringResource(id = R.string.enterName))},
        onValueChange = changed,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .height(50.dp)
            .clip(shape = RoundedCornerShape(10.dp))
//           .padding(top = 10.dp, bottom = 10.dp)
    )
}
@Composable
fun EmailTextField(email: String, changed: (String) -> Unit){
    TextField(
//        text = stringResource(id = R.string.greeting) + " " + newName,
        value = email,
        label = { Text(stringResource(id = R.string.enterEmail))},
        onValueChange = changed,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .height(50.dp)
            .clip(shape = RoundedCornerShape(10.dp))
    )
}
@Composable
fun MessageTextField(message: String, changed: (String) -> Unit){
    TextField(
//        text = stringResource(id = R.string.greeting) + " " + newName,
        value = message,
        label = { Text(stringResource(id = R.string.enterMessage))},
        onValueChange = changed,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .height(50.dp)
            .clip(shape = RoundedCornerShape(10.dp))
    )
}
@Composable
fun submitButton(clicked: () -> Unit){

    //custom background buttons
    // create a variable mainButtonColor and define background Color and content Color
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = Color.Black,
        contentColor = MaterialTheme.colors.surface
    )

    Row {
        Button(colors = mainButtonColor, onClick = {}, modifier = Modifier.fillMaxWidth()
            .padding(8.dp)) {
            Text(text = stringResource(id = R.string.submit_button))
        }
    }
}