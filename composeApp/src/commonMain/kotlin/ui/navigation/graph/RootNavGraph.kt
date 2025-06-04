/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT License
 */

package ui.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import feature.splash.SplashScreen
import root.MainContainer
import ui.navigation.NavActions
import ui.navigation.RootFlow

@Composable
fun RootNavGraph() {
    val rootNavController = rememberNavController()
    val rootNavActions = remember(rootNavController) {
        NavActions(rootNavController)
    }
    NavHost(
        navController = rootNavController,
        startDestination = RootFlow.MainContainer.route
    ) {
        composable(RootFlow.Splash.route) {
            SplashScreen(
                startMainFlow = { rootNavActions.popAndNavigation(RootFlow.MainContainer) })
        }
        composable(RootFlow.MainContainer.route) {
            MainContainer(
                rootNavActions = rootNavActions,
            )
        }
    }
}
