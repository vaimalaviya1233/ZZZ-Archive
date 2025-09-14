/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT License
 */

package ui.navigation.graph.app

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import feature.function.FunctionScreen
import ui.navigation.MainFlow
import ui.navigation.NavActions
import ui.navigation.Screen
import ui.navigation.graph.sharedNavGraph

fun NavGraphBuilder.functionNavGraph(navActions: NavActions) {
    navigation<MainFlow.Function>(
        startDestination = MainFlow.Function.startScreen::class
    ) {
        composable<Screen.Function> {
            FunctionScreen()
        }
        sharedNavGraph(navActions)
    }
}
