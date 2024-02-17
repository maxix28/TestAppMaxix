package com.example.testappmaxix.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testappmaxix.ui.Screens.InfoScreen
import com.example.testappmaxix.ui.Screens.saveAge
import com.example.testappmaxix.ui.Screens.saveName

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier= Modifier){
    NavHost(navController = navController, startDestination = NavDestination.Name.route){
        composable(route = NavDestination.Name.route){
            saveName() {navController.navigate(NavDestination.Age.route)}
        }
        composable(route = NavDestination.Age.route){
            saveAge() {navController.navigate(NavDestination.Info.route)}
        }
        composable(route = NavDestination.Info.route){
            InfoScreen()
        }
    }
}