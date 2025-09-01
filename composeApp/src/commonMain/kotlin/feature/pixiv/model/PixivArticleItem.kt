/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT
 */

package feature.pixiv.model

data class PixivArticleItem(
    val id: String,
    val title: String,
    val url: String,
    val userId: String,
    val userName: String,
    val profileImageUrl: String
)
