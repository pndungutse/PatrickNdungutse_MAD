package com.example.finalprojectgroup.model

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectgroup.util.RouteDatabase
//import com.example.recipes.util.RecipeDatabase
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RouteViewModel: ViewModel() {
    private val routedb = RouteDatabase()

    var routeList = routedb.routes
    var route = routedb.route

    init {
        viewModelScope.launch(Dispatchers.IO) { routedb.getRoutes() }
    }

    fun addRoute(route: Route) = viewModelScope.launch(Dispatchers.IO){
        routedb.addRoute(route)
    }

    fun deleteRoute(id: String) = viewModelScope.launch(Dispatchers.IO){
        routedb.deleteRoute(id)
    }

    fun getRoute(id: String) = viewModelScope.launch(Dispatchers.IO){
        routedb.getRoute(id)
    }
    fun updateRoute(current: String) = viewModelScope.launch(Dispatchers.IO){
        routedb.updateRoute(current)
    }
}
