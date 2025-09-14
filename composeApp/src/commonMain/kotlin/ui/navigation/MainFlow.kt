/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT License
 */

package ui.navigation

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import zzzarchive.composeapp.generated.resources.Res
import zzzarchive.composeapp.generated.resources.agents
import zzzarchive.composeapp.generated.resources.bangboo
import zzzarchive.composeapp.generated.resources.drives
import zzzarchive.composeapp.generated.resources.function
import zzzarchive.composeapp.generated.resources.home
import zzzarchive.composeapp.generated.resources.ic_article_scroll
import zzzarchive.composeapp.generated.resources.ic_bangboo
import zzzarchive.composeapp.generated.resources.ic_cd
import zzzarchive.composeapp.generated.resources.ic_function
import zzzarchive.composeapp.generated.resources.ic_help
import zzzarchive.composeapp.generated.resources.ic_home
import zzzarchive.composeapp.generated.resources.ic_people
import zzzarchive.composeapp.generated.resources.ic_setting
import zzzarchive.composeapp.generated.resources.ic_w_engine
import zzzarchive.composeapp.generated.resources.setting
import zzzarchive.composeapp.generated.resources.unknown
import zzzarchive.composeapp.generated.resources.w_engines
import zzzarchive.composeapp.generated.resources.wiki

@Serializable
sealed class MainFlow(val startScreen: Screen) {
    @Serializable
    data object Home : MainFlow(
        startScreen = Screen.Home
    )

    @Serializable
    data object Agent : MainFlow(
        startScreen = Screen.AgentsList
    )

    @Serializable
    data object WEngine : MainFlow(
        startScreen = Screen.WEnginesList
    )

    @Serializable
    data object Drive : MainFlow(
        startScreen = Screen.DrivesList
    )

    @Serializable
    data object Bangboo : MainFlow(
        startScreen = Screen.BangbooList
    )

    @Serializable
    data object Setting : MainFlow(
        startScreen = Screen.Setting
    )

    @Serializable
    data object Wiki : MainFlow(
        startScreen = Screen.Wiki
    )

    @Serializable
    data object Function : MainFlow(
        startScreen = Screen.Function
    )
}

data class TopDestination(
    val route: MainFlow,
    val iconRes: DrawableResource = Res.drawable.ic_help,
    val textRes: StringResource = Res.string.unknown
)

private val topHomeDestination = TopDestination(
    route = MainFlow.Home,
    iconRes = Res.drawable.ic_home,
    textRes = Res.string.home
)

private val topAgentDestination = TopDestination(
    route = MainFlow.Agent,
    iconRes = Res.drawable.ic_people,
    textRes = Res.string.agents
)

private val topWEngineDestination = TopDestination(
    route = MainFlow.WEngine,
    iconRes = Res.drawable.ic_w_engine,
    textRes = Res.string.w_engines
)

private val topBangbooDestination = TopDestination(
    route = MainFlow.Bangboo,
    iconRes = Res.drawable.ic_bangboo,
    textRes = Res.string.bangboo
)

private val topDriveDestination = TopDestination(
    route = MainFlow.Drive,
    iconRes = Res.drawable.ic_cd,
    textRes = Res.string.drives
)

private val topSettingDestination = TopDestination(
    route = MainFlow.Setting,
    iconRes = Res.drawable.ic_setting,
    textRes = Res.string.setting
)

private val topWikiDestination = TopDestination(
    route = MainFlow.Wiki,
    iconRes = Res.drawable.ic_article_scroll,
    textRes = Res.string.wiki
)

private val topFunctionDestination = TopDestination(
    route = MainFlow.Function,
    iconRes = Res.drawable.ic_function,
    textRes = Res.string.function
)

val NAV_RAIL_MAIN_FLOW =
    listOf(
        topHomeDestination,
        topAgentDestination,
        topWEngineDestination,
        topBangbooDestination,
        topDriveDestination,
        topSettingDestination
    )

val NAV_BOTTOM_MAIN_FLOW =
    listOf(
        topHomeDestination,
        topWikiDestination,
        topFunctionDestination,
        topSettingDestination
    )
