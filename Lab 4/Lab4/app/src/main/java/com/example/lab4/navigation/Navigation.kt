package com.example.lab4.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab4.ui.compose.AccountScreen
import com.example.lab4.ui.compose.HomeScreen

@Composable
fun Nav() {
    var navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "Home") {
        composable(route = "Home"){
            HomeScreen(navController)
        }
        composable(route = "Profile"){
            AccountScreen(navController)
        }
//        composable(route = "Login"){
//            LoginScreen(navController)
//        }
//        composable(route = "Register"){
//            RegisterScreen(navController)
//        }
//
//        composable(route = "Contact"){
//            ContactScreen(navController)
//        }
//        composable(route = "Information"){
//            InformationScreen(navController)
//        }
    }
}