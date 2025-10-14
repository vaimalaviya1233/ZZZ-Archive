/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT
 */

package database

import feature.agent.data.repository.FakeAgentRepository
import feature.cover.data.FakeCoverImageRepository
import feature.home.data.FakeAssetVersionRepository
import feature.setting.data.FakeSystemConfigRepository
import feature.setting.domain.FakeLanguageUseCase
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest

class UpdateDatabaseUseCaseTest {
    private val assetVersionRepository = FakeAssetVersionRepository()
    private val coverImageRepository = FakeCoverImageRepository()
    private val agentRepository = FakeAgentRepository()
    private val systemConfigRepository = FakeSystemConfigRepository()
    private val languageUseCase = FakeLanguageUseCase()

    private val updateDatabaseUseCase =
        UpdateDatabaseUseCase(
            assetVersionRepository,
            coverImageRepository,
            agentRepository,
            systemConfigRepository,
            languageUseCase
        )

    @Test
    fun `Update assets if new version available`() = runTest {
        updateDatabaseUseCase.updateAssetsIfNewVersionAvailable()
        assertEquals(2, systemConfigRepository.getCoverImageDBVersion().first())
        assertEquals(2, systemConfigRepository.getAgentListDBVersion().first())
    }

    @Test
    fun `Reset wiki database version`() = runTest {
        updateDatabaseUseCase.resetWikiDatabaseVersion()
        assertEquals(0, systemConfigRepository.getAgentListDBVersion().first())
    }
}
