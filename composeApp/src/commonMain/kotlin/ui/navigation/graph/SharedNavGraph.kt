/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT License
 */

package ui.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import feature.agent.presentation.AgentDetailScreen
import feature.agent.presentation.AgentsListScreen
import feature.bangboo.presentation.BangbooDetailScreen
import feature.bangboo.presentation.BangbooListScreen
import feature.drive.presentation.DrivesListScreen
import feature.feedback.presentation.FeedbackScreen
import feature.hoyolab.presentation.HoYoLabSyncScreen
import feature.hoyolab.presentation.MyAgentDetailScreen
import feature.hoyolab.presentation.MyAgentsListScreen
import feature.setting.presentation.SettingScreen
import feature.wengine.presentation.WEngineDetailScreen
import feature.wengine.presentation.WEnginesListScreen
import ui.navigation.NavActions
import ui.navigation.Screen
import ui.navigation.slideInAnimateComposable

fun NavGraphBuilder.sharedNavGraph(navActions: NavActions) {
    composable<Screen.AgentsList> {
        AgentsListScreen(onAgentClick = { id ->
            navActions.navigationTo(Screen.AgentDetail(id))
        }, onBackClick = {
            navActions.back()
        })
    }

    slideInAnimateComposable<Screen.AgentDetail> {
        AgentDetailScreen(wEngineClick = { id ->
            navActions.navigationTo(Screen.WEngineDetail(id))
        }, onBackClick = { navActions.back() })
    }

    composable<Screen.WEnginesList> {
        WEnginesListScreen(onWEngineClick = { id ->
            navActions.navigationTo(
                Screen.WEngineDetail(id)
            )
        }, onBackClick = {
            navActions.back()
        })
    }

    slideInAnimateComposable<Screen.WEngineDetail> {
        WEngineDetailScreen(onBackClick = { navActions.back() })
    }

    composable<Screen.BangbooList> {
        BangbooListScreen(onBangbooClick = { id ->
            navActions.navigationTo(
                Screen.BangbooDetail(id)
            )
        }, onBackClick = {
            navActions.back()
        })
    }

    slideInAnimateComposable<Screen.BangbooDetail> {
        BangbooDetailScreen(onBackClick = { navActions.back() })
    }

    composable<Screen.DrivesList> {
        DrivesListScreen(onBackClick = {
            navActions.back()
        })
    }

    composable<Screen.Setting> {
        SettingScreen(onFeedbackClick = {
            navActions.navigationTo(Screen.Feedback)
        }, onHoYoLabClick = {
            navActions.navigationTo(Screen.HoYoLabSync)
        })
    }

    slideInAnimateComposable<Screen.Feedback> {
        FeedbackScreen {
            navActions.back()
        }
    }

    slideInAnimateComposable<Screen.HoYoLabSync> {
        HoYoLabSyncScreen(onBackClick = { navActions.back() }, navigateToFeedback = {
            navActions.navigationTo(Screen.Feedback)
        })
    }

    slideInAnimateComposable<Screen.MyAgentsList> {
        MyAgentsListScreen(
            onAgentClick = { id ->
                navActions.navigationTo(Screen.MyAgentDetail(id))
            },
            onBackClick = {
                navActions.back()
            }
        )
    }

    slideInAnimateComposable<Screen.MyAgentDetail> {
        MyAgentDetailScreen(onBackClick = {
            navActions.back()
        })
    }
}
