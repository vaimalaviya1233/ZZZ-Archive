/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT
 */

package ui.navigation.graph.app

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import feature.wiki.presentation.WikiScreen
import ui.navigation.MainFlow
import ui.navigation.NavActions
import ui.navigation.Screen
import ui.navigation.graph.sharedNavGraph

fun NavGraphBuilder.wikiNavGraph(navActions: NavActions) {
    navigation<MainFlow.Wiki>(
        startDestination = MainFlow.Wiki.startScreen::class
    ) {
        composable<Screen.Wiki> {
            WikiScreen(
                onAgentsOverviewClick = { navActions.navigationTo(Screen.AgentsList) },
                onWEnginesOverviewClick = { navActions.navigationTo(Screen.WEnginesList) },
                onBangbooOverviewClick = { navActions.navigationTo(Screen.BangbooList) },
                onDrivesOverviewClick = { navActions.navigationTo(Screen.DrivesList) },
                onAgentDetailClick = { id ->
                    navActions.navigationTo(Screen.AgentDetail(id))
                },
                onWEngineDetailClick = { id ->
                    navActions.navigationTo(Screen.WEngineDetail(id))
                },
                onBangbooDetailClick = { id ->
                    navActions.navigationTo(Screen.BangbooDetail(id))
                }
            )
        }
        sharedNavGraph(navActions)
    }
}
