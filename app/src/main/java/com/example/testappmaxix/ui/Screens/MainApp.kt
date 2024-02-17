package com.example.testappmaxix.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testappmaxix.ui.navigation.Destination
import com.example.testappmaxix.ui.navigation.NavDestination
import com.example.testappmaxix.ui.navigation.NavGraph

@Composable
fun mainScreen(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    Scaffold (bottomBar ={ bottomBar(navController =navController)}){
NavGraph(navController = navController, modifier = modifier.padding(it))
    }
}
@Composable
fun bottomBar(modifier: Modifier = Modifier, navController: NavHostController) {

    val screens = listOf(
        NavDestination.Name,
        NavDestination.Age,
        NavDestination.Info,


        )

    val navBAckStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBAckStackEntry?.destination
    val isInScreens: Boolean = currentDestination?.let { currentDest ->
        screens.any { screen -> screen.route == currentDest.route }
    } ?: false

    if (isInScreens) {

        Row(
            modifier = modifier
                .padding(horizontal = 5.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f))
                .clip(
                    RoundedCornerShape(40.dp)
                ), horizontalArrangement = Arrangement.SpaceAround
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    navController = navController,
                    currentDestination = currentDestination
                )
            }
        }
    }


}

@Composable
fun RowScope.AddItem(
    screen: Destination,
    navController: NavHostController,
    currentDestination: androidx.navigation.NavDestination?, modifier: Modifier = Modifier
) {


    IconButton(onClick = { navController.navigate(screen.route) }) {

Text(text =screen.route, fontWeight =(if (currentDestination?.hierarchy?.any { it.route == screen.route } == true)     FontWeight.Bold else FontWeight.Normal) ,
            modifier = modifier

                .padding(5.dp)

)
    }

}

