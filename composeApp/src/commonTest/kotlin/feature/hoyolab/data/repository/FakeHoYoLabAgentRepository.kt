package feature.hoyolab.data.repository

import feature.hoyolab.model.MyAgentListItem
import feature.hoyolab.model.agent.MyAgentDetailListItem
import feature.hoyolab.model.agent.stubMyAgentDetailListItem
import feature.hoyolab.model.stubMyAgentsList

class FakeHoYoLabAgentRepository : HoYoLabAgentRepository {
    private var isError = false

    fun setError(isError: Boolean) {
        this.isError = isError
    }

    override suspend fun requestPlayerAgentList(
        languageCode: String,
        uid: Int,
        region: String,
        lToken: String,
        ltUid: String
    ): Result<List<MyAgentListItem>> = if (isError) {
        Result.failure(Exception())
    } else {
        Result.success(stubMyAgentsList)
    }

    override suspend fun requestPlayerAgentDetail(
        languageCode: String,
        uid: Int,
        region: String,
        lToken: String,
        ltUid: String,
        agentId: Int
    ): Result<MyAgentDetailListItem> = if (isError) {
        Result.failure(Exception())
    } else {
        Result.success(stubMyAgentDetailListItem)
    }
}
