/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT License
 */

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.setSingletonImageLoaderFactory
import feature.splash.InitViewModel
import org.koin.compose.viewmodel.koinViewModel
import ui.navigation.graph.RootNavGraph
import ui.theme.AppTheme
import ui.theme.ZzzArchiveTheme
import utils.imageLoaderDiskCache

@Composable
fun ZzzArchiveApp() {
    // Initialize the Coil3 image loader
    setSingletonImageLoaderFactory { context ->
        imageLoaderDiskCache(context)
    }
    ZzzArchiveTheme {
        val viewModel: InitViewModel = koinViewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        var isDark by AppTheme.isDark
        isDark = uiState.isDark
        var uiScale by AppTheme.uiScale
        uiScale = uiState.uiScale
        var fontScale by AppTheme.fontScale
        fontScale = uiState.fontScale

        if (!uiState.isLoading) {
            RootNavGraph()
        }
    }
}
