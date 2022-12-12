package com.example.finalprojectgroup.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojectgroup.model.Route
import com.example.finalprojectgroup.model.RouteViewModel

@Composable
fun FollowRoute() {
    val viewModel: RouteViewModel = viewModel()
    val context = LocalContext.current

    if(viewModel.routeList.size == 0) {
        // Determinate
//        LinearProgressIndicator(progress = 0.5f)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(progress = 0.5f, color = Color.Red, strokeWidth = 6.dp, modifier = Modifier.size(size = 35.dp).align(
                Alignment.Center))
        }

    } else {
        LazyColumn(
            contentPadding = PaddingValues(
                vertical = 8.dp,
                horizontal = 8.dp
            )
        )
        {
            items(viewModel.routeList, key={route -> route.id}) { route ->
                // , key={recipe -> recipe.id}
                RouteItem(item = route, context)
                //, {viewModel.deleteRecipe(it)}
            }
        }
    }

}

@Composable
fun RouteItem(item: Route, context: Context) {
//    Card(
//        elevation = 4.dp,
//        shape = RoundedCornerShape(10.dp),
//        backgroundColor = MaterialTheme.colors.surface,
//        contentColor = MaterialTheme.colors.primary,
//        border = BorderStroke(2.dp, color = Color.Red),
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth()
//
//    ) {
//        Column(
//            modifier = Modifier.padding(15.dp)
//        ) {
////            Text(text = "Route: "+item.from+" to "+item.dest+"      "+item.departure_time, style = MaterialTheme.typography.h6)
//////                Text(text = "Destination:"+item.dest, fontSize = 14.sp)
////            Text(text = "Current bus stop: "+item.current, fontSize = 12.sp)
////            Text(text = "Time: "+item.current_time, fontSize = 10.sp)
//
//
//        }
//
//    }


    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth() ) {
        Text(text = "FOLLOW BUS LOCATION", textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 14.sp, modifier = Modifier.padding(bottom = 15.dp))

        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Text(text = "Route: ", style = MaterialTheme.typography.h6)
            Spacer(Modifier.weight(1f))
            Text(item.from+" to "+item.dest, style = MaterialTheme.typography.h6)
        }
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Text(text = "Departure time: ", fontSize = 12.sp)
            Spacer(Modifier.weight(1f))
            Text("Mon-Fri "+item.departure_time, fontSize = 12.sp)
        }
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Text(text = "Recent bus stop: ", fontSize = 12.sp)
            Spacer(Modifier.weight(1f))
            Text(item.current, fontSize = 12.sp)
        }
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Text(text = "Time updated: ", fontSize = 12.sp)
            Spacer(Modifier.weight(1f))
            Text(item.current_time, fontSize = 12.sp, color = MaterialTheme.colors.secondary)
        }
    }
}