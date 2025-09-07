package utils

enum class Language(val localName: String, val code: String, val officialCode: String) {
    English(localName = "English", code = "en", officialCode = "en-us"),
    ChineseTraditional(localName = "繁體中文", code = "zh", officialCode = "zh-tw")
}

expect fun changePlatformLanguage(langCode: String)
