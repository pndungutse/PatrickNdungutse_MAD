package com.example.finalprojectgroup.screens

import android.content.Context
import android.util.Size
import androidx.compose.foundation.combinedClickable
//import android.util.Log
//import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
//import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalprojectgroup.model.RouteViewModel
//import com.example.finalprojectgroup.ui.theme.FinalProjectGroupTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalprojectgroup.R
//import com.example.finalprojectgroup.R
import com.example.finalprojectgroup.model.Route
import java.util.*

@Composable
fun RoutesScreen(navController: NavController) {
    val viewModel: RouteViewModel = viewModel()
    val context = LocalContext.current

    if(viewModel.routeList.size == 0) {
        // Determinate
//        LinearProgressIndicator(progress = 0.5f)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(progress = 0.5f, color = Color.Red, strokeWidth = 6.dp, modifier = Modifier.size(size = 35.dp).align(Alignment.Center))
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
                RouteItem(item = route, context, {viewModel.deleteRoute(it)}, {viewModel.getRoute(it)}, {viewModel.updateRoute(it)}, navController)
                //, {viewModel.deleteRecipe(it)}
            }
        }
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RouteItem(item: Route, context: Context, deleteRoute: (String) -> Unit, getRoute: (String) -> Unit, updateRoute: (String)-> Unit, navController: NavController) {
    var showCard by remember { mutableStateOf(true) }

    if (showCard) {

        Row {
            Card(
                elevation = 4.dp,
                shape = RoundedCornerShape(10.dp),
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.primary,
                border = BorderStroke(2.dp, color = Color.Red),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
//                .height(120.dp)
                    .combinedClickable(
                        onClick = {
//                    getRoute("xLJHl0YkkIGdesxTUaWy")
//                          updateRoute("Kimironko")
                            showCard = false
//                        navController.navigate("RouteDetail")

                        },
//                onLongClick = { showDeleteDialog = true }
                    )
            ) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(text = "Route: "+item.from+" to "+item.dest+"      "+item.departure_time, style = MaterialTheme.typography.h6)
//                Text(text = "Destination:"+item.dest, fontSize = 14.sp)
                    Text(text = "Current bus stop: "+item.current, fontSize = 12.sp)
                    Text(text = "Time: "+item.current_time, fontSize = 10.sp)
                }

            }

            Button(
                onClick = {showCard=true}, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 100.dp, top = 3.dp, end = 100.dp, bottom = 15.dp)
            ) {
                Text(stringResource(id = R.string.cancel))
            }
        }
    } else {


//        /    the expanded state of the Text Field
        var mExpanded by remember { mutableStateOf(false) }

        // Create a list of cities
        val mCities =
            listOf("Kwa Rubangura", "Muhima Merez", "Kinamba", "Kacyiru", "Minijust (Gishushu/RDB)", "Sport View Hotel", "Simba Super Market", "Kwa mushimire", "Kepler", "Nayinzira", "CMU")
        // Create a string value to store the selected city
        var mSelectedText by remember { mutableStateOf(item.current) }
//        var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

        val icon = if (mExpanded)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown

        Column(Modifier.padding(20.dp)) {
            // with icon and not expanded
            OutlinedTextField(
                value = mSelectedText,
                onValueChange = { mSelectedText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
//            mTextFieldSize = coordinates.size.toSize()
                    },
                label = { Text("Label") },
                trailingIcon = {
                    Icon(icon, "contentDescription",
                        Modifier.clickable { mExpanded = !mExpanded })
                }
            )

            // Create a drop-down menu with list of cities, 
            // when clicked, set the Text Field text as the city selected
            DropdownMenu(
                expanded = mExpanded,
                onDismissRequest = { mExpanded = false },
//            modifier = Modifier
//            .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
            ) {
                mCities.forEach { label ->
                    DropdownMenuItem(onClick = {
                        mSelectedText = label
                        mExpanded = false
                    })
                    {
                        Text(text = label)
                    }

                }
            }
//    if (showDeleteDialog){
//        deleteRecipeDialog(context, dismissDialog = {showDeleteDialog = false}, item, deleteBook)
//    }
        }

        val mainButtonColor = ButtonDefaults.buttonColors(
            backgroundColor = Color.Red,
            contentColor = MaterialTheme.colors.surface
        )

        Column {

                Button(
                    colors = mainButtonColor, onClick = {showCard=true
                        updateRoute(mSelectedText)}, modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 90.dp, top = 3.dp, end = 90.dp, bottom = 15.dp)
                ) {
                    Text(stringResource(id = R.string.update))
                }

            Button(
                colors = mainButtonColor, onClick = {showCard=true}, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 100.dp, top = 3.dp, end = 100.dp, bottom = 15.dp)
            ) {
                Text(stringResource(id = R.string.cancel))
            }

        }
    }
}