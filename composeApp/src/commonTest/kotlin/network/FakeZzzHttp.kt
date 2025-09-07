/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT License
 */

package network

import feature.agent.model.AgentDetailResponse
import feature.agent.model.AgentsListResponse
import feature.agent.model.stubAgentDetailResponse
import feature.agent.model.stubAgentsListResponse
import feature.bangboo.model.BangbooDetailResponse
import feature.bangboo.model.BangbooListResponse
import feature.bangboo.model.stubBangbooDetailResponse
import feature.bangboo.model.stubBangbooListResponse
import feature.banner.data.BannerResponse
import feature.banner.data.stubBannerResponse
import feature.cover.model.CoverImageListResponse
import feature.cover.model.stubCoverImageResponse
import feature.drive.model.DrivesListResponse
import feature.drive.model.stubDrivesListResponse
import feature.home.model.AssetVersionResponse
import feature.home.model.stubAssetVersionResponse
import feature.wengine.model.WEngineDetailResponse
import feature.wengine.model.WEnginesListResponse
import feature.wengine.model.stubWEngineDetailResponse
import feature.wengine.model.stubWEnginesListResponse

class FakeZzzHttp : ZzzHttp {
    private var isError = false

    fun setError(isError: Boolean) {
        this.isError = isError
    }

    override suspend fun requestAssetVersion(): AssetVersionResponse = if (isError) {
        throw Exception()
    } else {
        stubAssetVersionResponse
    }

    override suspend fun requestBanner(languagePath: String): BannerResponse = if (isError) {
        throw Exception()
    } else {
        stubBannerResponse
    }

    override suspend fun requestCoverImage(): CoverImageListResponse = if (isError) {
        throw Exception()
    } else {
        stubCoverImageResponse
    }

    override suspend fun requestAgentsList(languagePath: String): AgentsListResponse = if (isError) {
        throw Exception()
    } else {
        stubAgentsListResponse
    }

    override suspend fun requestAgentDetail(
        id: Int,
        languagePath: String
    ): AgentDetailResponse = if (isError) {
        throw Exception()
    } else {
        stubAgentDetailResponse
    }

    override suspend fun requestWEnginesList(languagePath: String): WEnginesListResponse = if (isError) {
        throw Exception()
    } else {
        stubWEnginesListResponse
    }

    override suspend fun requestWEngineDetail(
        id: Int,
        languagePath: String
    ): WEngineDetailResponse = if (isError) {
        throw Exception()
    } else {
        stubWEngineDetailResponse
    }

    override suspend fun requestBangbooList(languagePath: String): BangbooListResponse = if (isError) {
        throw Exception()
    } else {
        stubBangbooListResponse
    }

    override suspend fun requestBangbooDetail(
        id: Int,
        languagePath: String
    ): BangbooDetailResponse = if (isError) {
        throw Exception()
    } else {
        stubBangbooDetailResponse
    }

    override suspend fun requestDrivesList(languagePath: String): DrivesListResponse = if (isError) {
        throw Exception()
    } else {
        stubDrivesListResponse
    }
}
