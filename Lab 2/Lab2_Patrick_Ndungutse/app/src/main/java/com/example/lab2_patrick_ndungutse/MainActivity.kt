package com.example.lab2_patrick_ndungutse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloandroid.ui.theme.black
import com.example.lab2_patrick_ndungutse.ui.theme.Lab2_Patrick_NdungutseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2_Patrick_NdungutseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Body()
                }
            }
        }
    }
}
@Composable
fun Body() {
    Column() {
        Header()
        Components()
    }
}

@Composable
fun Header() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(45.dp)
        .background(color = Color.Black)
//        .padding(start = 25.dp, end = 25.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.drawer_icon),
            contentDescription = stringResource(id = R.string.drawer_botton),
            modifier = Modifier
                .size(40.dp)
                .padding(top = 5.dp, start = 10.dp)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
//                    .height(60.dp)
                    .padding(end = 30.dp),
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun Components() {
    var name by remember { mutableStateOf("") }
    var textFieldName by remember { mutableStateOf("") }
    var imageDisplayCondition by remember {
        mutableStateOf(false)
    }
//    var imageToShow by remember { mutableStateOf(0) }
//    val images = arrayOf(R.drawable.dog_image,R.drawable.drawer_icon, R.drawable.scottydog, R.drawable.ananas, R.drawable.jelly, R.drawable.kid, R.drawable.logo, R.drawable.orange, R.drawable.success, R.drawable.university)
//    imageToShow = images.random()



    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        NameTextField(name = textFieldName, changed = { textFieldName = it })
        SubmitButton {
            name = textFieldName
            imageDisplayCondition = !imageDisplayCondition
        }
        Image(
            painter = painterResource(id = if(imageDisplayCondition) {
                R.drawable.orange
            }else {
                R.drawable.ananas
            }),
            contentDescription = stringResource(id = R.string.scotty),
            modifier = Modifier
                .padding(top = 15.dp, bottom = 25.dp)
                .size(190.dp)
                .clip(CircleShape),
            )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(black)
        ) {
            MessageText(newName = name)
        }
    }
}

@Composable
fun SubmitButton(clicked: () -> Unit){
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = Color.Black,
        contentColor = MaterialTheme.colors.surface
    )
    Row {
        Button(colors = mainButtonColor, onClick = clicked, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 90.dp, top = 3.dp, end = 90.dp, bottom = 15.dp)) {
            Text(stringResource(id = R.string.button_to_change))
        }
    }
}

@Composable
fun NameTextField(name: String, changed: (String) ->Unit){
    TextField(
        value = name,
        label = {Text(stringResource(id = R.string.enterName))},
        onValueChange = changed,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
    )
}
@Composable
fun MessageText(newName: String){
    if(newName.isNotEmpty()) {
        Text(
            stringResource(R.string.greeting) + " " + newName,
            color = Color.White,
            //fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab2_Patrick_NdungutseTheme {
        Body()
    }
}
@Preview(showBackground = true)
@Composable
fun DarkDefaultPreview() {
    Lab2_Patrick_NdungutseTheme(darkTheme = true) {
        Body()
    }
}