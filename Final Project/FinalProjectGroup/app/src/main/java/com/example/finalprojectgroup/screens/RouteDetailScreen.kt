package com.example.finalprojectgroup.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
//import androidx.compose.material.R
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.finalprojectgroup.R

@Composable
fun RouteDetailScreen() {
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = Color.Black,
        contentColor = MaterialTheme.colors.surface
    )

    Column() {
        Button(colors = mainButtonColor, onClick = {}, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 90.dp, top = 3.dp, end = 90.dp, bottom = 15.dp)) {
            Text(stringResource(id = R.string.update))
        }
    }
}