/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT License
 */

package ui.navigation.graph.app

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import feature.home.presentation.HomeScreen
import ui.navigation.MainFlow
import ui.navigation.NavActions
import ui.navigation.Screen
import ui.navigation.graph.sharedNavGraph

fun NavGraphBuilder.homeNavGraph(navActions: NavActions) {
    navigation<MainFlow.Home>(
        startDestination = MainFlow.Home.startScreen::class
    ) {
        composable<Screen.Home> {
            HomeScreen(
                onAgentsOverviewClick = { navActions.navigationToMainScreen(MainFlow.Agent) },
                onWEnginesOverviewClick = { navActions.navigationToMainScreen(MainFlow.WEngine) },
                onBangbooOverviewClick = { navActions.navigationToMainScreen(MainFlow.Bangboo) },
                onDrivesOverviewClick = { navActions.navigationToMainScreen(MainFlow.Drive) },
                onAgentDetailClick = { id ->
                    navActions.navigationTo(Screen.AgentDetail(id))
                },
                onWEngineDetailClick = { id ->
                    navActions.navigationTo(Screen.WEngineDetail(id))
                },
                onBangbooDetailClick = { id ->
                    navActions.navigationTo(Screen.BangbooDetail(id))
                },
                navigateTo = { route ->
                    navActions.navigationTo(route)
                }
            )
        }
        sharedNavGraph(navActions)
    }
}
