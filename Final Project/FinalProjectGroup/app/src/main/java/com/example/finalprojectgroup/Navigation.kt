package com.example.finalprojectgroup

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalprojectgroup.screens.RouteDetailScreen
import com.example.finalprojectgroup.screens.RoutesScreen

@Composable
fun Nav() {
    var navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "Home") {
        composable(route = "Home"){
            HomeScreen(navController)
        }
        composable(route = "Login"){
            LoginScreen(navController)
        }
        composable(route = "Register"){
            RegisterScreen(navController)
        }

        composable(route = "Contact"){
            ContactScreen(navController)
        }
        composable(route = "Information"){
            InformationScreen(navController)
        }
        composable(route = "RouteDetail"){
            RouteDetailScreen()
        }
        composable(route = "Share"){
            RoutesScreen(navController)
        }
    }
}