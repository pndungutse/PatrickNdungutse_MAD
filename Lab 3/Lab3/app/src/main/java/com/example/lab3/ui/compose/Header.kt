package com.example.lab3.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab3.R

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