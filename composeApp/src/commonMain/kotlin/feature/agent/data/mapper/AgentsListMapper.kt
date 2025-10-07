/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT
 */

package feature.agent.data.mapper

import com.mrfatworm.zzzarchive.ZzzConfig
import feature.agent.data.database.AgentsListItemEntity
import feature.agent.model.AgentListItem
import feature.agent.model.AgentListItemResponse
import feature.agent.model.Faction
import utils.findAgentAttribute
import utils.findAgentSpecialty
import utils.findRarity

fun AgentListItemResponse.toAgentsListItemEntity(path: String = ZzzConfig.ASSET_PATH): AgentsListItemEntity =
    AgentsListItemEntity(
        id = id ?: 0,
        name = name.orEmpty(),
        imageUrl = "https://raw.githubusercontent.com/$path/Agent/Profile/$id.webp",
        isHighlight = isHighlight ?: false,
        rarity = rarity ?: 0,
        specialty = specialty.orEmpty(),
        attribute = attribute.orEmpty(),
        factionId = factionId ?: 0,
        materialId = material ?: 0,
        weeklyMaterialId = weeklyMaterial ?: 0
    )

fun AgentsListItemEntity.toAgentListItem(): AgentListItem = AgentListItem(
    id = id,
    name = name,
    imageUrl = imageUrl,
    isHighlight = isHighlight,
    rarity = findRarity(rarity),
    specialty = findAgentSpecialty(specialty),
    attribute = findAgentAttribute(attribute),
    faction = Faction(factionId),
    materialUrl = getMaterialUrl(id = materialId),
    weeklyMaterialUrl = getMaterialUrl(id = weeklyMaterialId)
)

private fun getMaterialUrl(
    path: String = ZzzConfig.ASSET_PATH,
    id: Int
): String = "https://raw.githubusercontent.com/$path/Material/$id.webp"
