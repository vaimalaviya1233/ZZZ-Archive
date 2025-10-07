/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT License
 */

package feature.agent.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import feature.agent.model.AgentsListState
import feature.agent.model.stubAgentsList
import ui.components.cards.ContentCard
import ui.components.chips.AttributeFilterChipsList
import ui.components.chips.RarityFilterChipsList
import ui.components.chips.SpecialtyFilterChips
import ui.components.dialogs.AgentMaterialDialog
import ui.components.items.HighlightAgentListItem
import ui.components.items.RarityItem
import ui.theme.AppTheme
import ui.utils.cardPadding
import ui.utils.gridListHorizontalGap
import ui.utils.gridListVerticalGap
import utils.AgentAttribute
import utils.AgentSpecialty
import utils.ZzzRarity

@Composable
fun AgentsListFilterCard(
    modifier: Modifier,
    uiState: AgentsListState,
    lazyGridState: LazyGridState = rememberLazyGridState(),
    invisibleFilter: Boolean = false,
    onRarityChipSelectionChanged: (Set<ZzzRarity>) -> Unit,
    onAttributeChipSelectionChanged: (Set<AgentAttribute>) -> Unit,
    onSpecialtyChipSelectionChanged: (Set<AgentSpecialty>) -> Unit
) {
    var isShowMaterialDialog by remember { mutableStateOf(false) }
    var selectedAgent by remember { mutableStateOf(stubAgentsList[0]) }
    Column(modifier = modifier) {
        AnimatedVisibility(visible = !invisibleFilter) {
            ContentCard(hasDefaultPadding = false) {
                Column(
                    modifier = Modifier.padding(vertical = AppTheme.spacing.s400),
                    verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.s300)
                ) {
                    RarityFilterChipsList(uiState.selectedRarity, onRarityChipSelectionChanged)
                    AttributeFilterChipsList(
                        uiState.selectedAttributes,
                        1,
                        onAttributeChipSelectionChanged
                    )
                    SpecialtyFilterChips(
                        uiState.selectedSpecialties,
                        1,
                        onSpecialtyChipSelectionChanged
                    )
                }
            }
        }
        LazyVerticalGrid(
            state = lazyGridState,
            columns = GridCells.Adaptive(AppTheme.size.s100),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(cardPadding()),
            horizontalArrangement = gridListHorizontalGap(),
            verticalArrangement = gridListVerticalGap()
        ) {
            item(span = { GridItemSpan(this.maxLineSpan) }) {
                BoxWithConstraints {
                    val isDualItem = maxWidth - (AppTheme.spacing.s300) >= AppTheme.size.s280 * 2
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.s300),
                        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.s300),
                        maxItemsInEachRow = 2
                    ) {
                        uiState.highlightAgentsList.forEach { agent ->
                            HighlightAgentListItem(
                                modifier = Modifier.weight(1f),
                                uiState = agent,
                                onClick = {
                                    selectedAgent = agent
                                    isShowMaterialDialog = true
                                }
                            )
                        }
                        if (isDualItem && uiState.highlightAgentsList.size % 2 == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
            items(
                count = uiState.filteredAgentsList.size,
                key = { index -> uiState.filteredAgentsList[index].id }
            ) { index ->
                val agent = uiState.filteredAgentsList[index]
                RarityItem(
                    modifier = Modifier.animateItem(),
                    rarity = agent.rarity,
                    attribute = agent.attribute,
                    imgUrl = agent.imageUrl,
                    onClick = {
                        selectedAgent = agent
                        isShowMaterialDialog = true
                    }
                )
            }
        }
    }
    if (isShowMaterialDialog) {
        AgentMaterialDialog(
            materialUrl = selectedAgent.materialUrl,
            weeklyMaterialUrl = selectedAgent.weeklyMaterialUrl,
            skillMaterialUrls = selectedAgent.skillMaterialUrls,
            levelMaterialUrls = selectedAgent.levelMaterialUrls,
            wEngineMaterialUrls = selectedAgent.wEngineMaterialUrls,
            onDismiss = { isShowMaterialDialog = false }
        )
    }
}
