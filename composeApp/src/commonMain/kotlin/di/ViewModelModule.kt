package di

import feature.agent.presentation.AgentDetailViewModel
import feature.agent.presentation.AgentsListViewModel
import feature.bangboo.presentation.BangbooDetailViewModel
import feature.bangboo.presentation.BangbooListViewModel
import feature.drive.presentation.DrivesListViewModel
import feature.feedback.presentation.FeedbackViewModel
import feature.home.presentation.HomeViewModel
import feature.hoyolab.presentation.HoYoLabSyncViewModel
import feature.hoyolab.presentation.MyAgentDetailViewModel
import feature.hoyolab.presentation.MyAgentsListViewModel
import feature.setting.presentation.SettingViewModel
import feature.splash.InitViewModel
import feature.wengine.presentation.WEngineDetailViewModel
import feature.wengine.presentation.WEnginesListViewModel
import feature.wiki.presentation.WikiViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import root.MainContainerViewModel

val viewModelModule = module {
    viewModelOf(::InitViewModel)
    viewModelOf(::MainContainerViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::WikiViewModel)
    viewModelOf(::AgentsListViewModel)
    viewModelOf(::AgentDetailViewModel)
    viewModelOf(::WEnginesListViewModel)
    viewModelOf(::WEngineDetailViewModel)
    viewModelOf(::BangbooListViewModel)
    viewModelOf(::BangbooDetailViewModel)
    viewModelOf(::DrivesListViewModel)
    viewModelOf(::SettingViewModel)
    viewModelOf(::FeedbackViewModel)
    viewModelOf(::HoYoLabSyncViewModel)
    viewModelOf(::MyAgentsListViewModel)
    viewModelOf(::MyAgentDetailViewModel)
}
