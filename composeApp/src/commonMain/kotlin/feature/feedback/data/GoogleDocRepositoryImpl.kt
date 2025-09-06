/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT License
 */

package feature.feedback.data

import network.GoogleDocHttp

class GoogleDocRepositoryImpl(private val httpClient: GoogleDocHttp) : GoogleDocRepository {

    override suspend fun submitFeedbackForm(
        issueType: String,
        language: String,
        issueDesc: String,
        email: String,
        appVersion: String,
        deviceName: String,
        operatingSystem: String
    ): Result<Unit> {
        return try {
                httpClient.submitFeedbackForm(
                    issueType,
                    language,
                    issueDesc,
                    email,
                    appVersion,
                    deviceName,
                    operatingSystem
                )
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}