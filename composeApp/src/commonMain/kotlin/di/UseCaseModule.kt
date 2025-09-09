package di

import database.UpdateDatabaseUseCase
import feature.agent.domain.AgentDetailUseCase
import feature.agent.domain.AgentsListUseCase
import feature.bangboo.domain.BangbooDetailUseCase
import feature.bangboo.domain.BangbooListUseCase
import feature.banner.domain.BannerUseCase
import feature.cover.domain.CoverImageUseCase
import feature.drive.domain.DrivesListUseCase
import feature.forum.domain.ForumUseCase
import feature.hoyolab.domain.GameRecordUseCase
import feature.hoyolab.domain.HoYoLabAgentUseCase
import feature.hoyolab.domain.HoYoLabManageUseCase
import feature.hoyolab.domain.HoYoLabPreferenceUseCase
import feature.news.domain.OfficialNewsUseCase
import feature.setting.domain.AppInfoUseCase
import feature.setting.domain.LanguageUseCase
import feature.setting.domain.LanguageUseCaseImpl
import feature.setting.domain.ThemeUseCase
import feature.setting.domain.UiScaleUseCase
import feature.wengine.domain.WEngineDetailUseCase
import feature.wengine.domain.WEnginesListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<CoverImageUseCase> { CoverImageUseCase(get()) }
    single<BannerUseCase> { BannerUseCase(get(), get(), get()) }
    single<LanguageUseCase> { LanguageUseCaseImpl(get()) }
    single<OfficialNewsUseCase> { OfficialNewsUseCase(get(), get()) }
    single<AgentsListUseCase> { AgentsListUseCase(get(), get()) }
    single<AgentDetailUseCase> { AgentDetailUseCase(get(), get()) }
    single<BangbooListUseCase> { BangbooListUseCase(get(), get()) }
    single<BangbooDetailUseCase> { BangbooDetailUseCase(get(), get()) }
    single<WEnginesListUseCase> { WEnginesListUseCase(get(), get()) }
    single<WEngineDetailUseCase> { WEngineDetailUseCase(get(), get()) }
    single<DrivesListUseCase> { DrivesListUseCase(get(), get()) }
    single<AppInfoUseCase> { AppInfoUseCase() }
    single<ThemeUseCase> { ThemeUseCase(get()) }
    single<UpdateDatabaseUseCase> {
        UpdateDatabaseUseCase(get(), get(), get(), get(), get(), get(), get(), get())
    }
    single<UiScaleUseCase> { UiScaleUseCase(get()) }
    single<HoYoLabManageUseCase> { HoYoLabManageUseCase(get(), get(), get()) }
    single<HoYoLabAgentUseCase> { HoYoLabAgentUseCase(get(), get(), get(), get(), get()) }
    single<HoYoLabPreferenceUseCase> { HoYoLabPreferenceUseCase(get()) }
    single<GameRecordUseCase> { GameRecordUseCase(get(), get(), get(), get(), get()) }
    single<ForumUseCase> { ForumUseCase(get()) }
}
