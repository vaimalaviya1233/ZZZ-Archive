/*
 * Copyright 2024 The ZZZ Archive Open Source Project by mrfatworm
 * License: MIT License
 */

package utils

import java.util.Locale

actual fun changePlatformLanguage(langCode: String) {
    val locale = Locale.Builder().setLanguage(langCode).build()
    Locale.setDefault(locale)
}
