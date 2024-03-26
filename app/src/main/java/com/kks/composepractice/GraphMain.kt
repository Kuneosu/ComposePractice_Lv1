package com.kks.composepractice

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kks.composepractice.screens.GraphA
import com.kks.composepractice.screens.GraphB
import com.kks.composepractice.screens.GraphC

@Composable
fun GraphMain() {
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem("Graph A", Icons.Default.Home, "graphA"),
        NavigationItem("Graph B", Icons.Default.Favorite, "graphB"),
        NavigationItem("Graph C", Icons.Default.AccountCircle, "graphC"),
    )

    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    navigationItems.forEach { nav ->


                        val currentRoute =
                            navController.currentBackStackEntryAsState().value?.destination?.route

                        val isSelected = currentRoute == nav.route

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(nav.route)
                                }
                        ) {
                            Icon(
                                imageVector = nav.icon,
                                contentDescription = nav.name,
                                tint = if (isSelected) {
                                    androidx.compose.ui.graphics.Color.Red
                                } else {
                                    androidx.compose.ui.graphics.Color.Gray
                                }
                            )
                            Text(
                                text = nav.name,
                                color = if (isSelected) {
                                    androidx.compose.ui.graphics.Color.Red
                                } else {
                                    androidx.compose.ui.graphics.Color.Gray
                                }
                            )
                        }
                    }
                }
            }

        }
    ) {
        NavHost(
            navController = navController,
            startDestination = "graphA",
            modifier = Modifier.padding(it)
        ) {
            composable("graphA") {
                GraphA()
            }

            composable("graphB") {
                GraphB()
            }

            composable("graphC") {
                GraphC()
            }
        }
    }
}

data class NavigationItem(
    val name: String,
    val icon: ImageVector,
    val route: String,
)

@Composable
@Preview(showBackground = true)
fun GraphMainPreview() {
    GraphMain()
}