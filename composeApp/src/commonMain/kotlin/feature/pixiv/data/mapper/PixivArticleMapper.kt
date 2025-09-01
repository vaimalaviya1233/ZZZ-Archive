/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT
 */

package feature.pixiv.data.mapper

import feature.pixiv.model.PixivArticleItem
import feature.pixiv.model.PixivTopicResponse


fun PixivTopicResponse.toPixivArticleList(): List<PixivArticleItem> {
    return this.body.illustManga?.data?.map { recentArticle ->
        PixivArticleItem(
            id = recentArticle.id.orEmpty(),
            title = recentArticle.title.orEmpty(),
            url = recentArticle.url.orEmpty(),
            userId = recentArticle.userId.orEmpty(),
            userName = recentArticle.userName.orEmpty(),
            profileImageUrl = recentArticle.profileImageUrl.orEmpty()
        )
    } ?: emptyList()
}


