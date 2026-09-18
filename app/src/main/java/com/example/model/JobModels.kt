package com.example.model

enum class AppMenu {
    JOBS,
    VIDEOS
}

enum class LegalPolicyPage(val titleKannada: String, val titleEnglish: String) {
    PRIVACY_POLICY("ಗೌಪ್ಯತಾ ನೀತಿ", "Privacy Policy"),
    TERMS_CONDITIONS("ನಿಯಮಗಳು ಮತ್ತು ಷರತ್ತುಗಳು", "Terms & Conditions"),
    CONTACT_US("ಸಂಪರ್ಕಿಸಿ & ಸಹಾಯವಾಣಿ", "Contact Us"),
    DISCLAIMER("ಹಕ್ಕು ನಿರಾಕರಣೆ", "Disclaimer")
}

data class JobWebsiteSource(
    val id: String,
    val name: String,
    val descriptionKannada: String,
    val descriptionEnglish: String,
    val url: String,
    val category: String,
    val isAutoSync: Boolean = true,
    val syncFrequency: String = "ಪ್ರತಿ ಗಂಟೆ (Hourly)"
)

data class YouTubeChannelSource(
    val id: String,
    val channelName: String,
    val channelHandle: String,
    val description: String,
    val subscribers: String,
    val totalVideos: String,
    val isAutoSync: Boolean = true
)

enum class JobCategory(val labelKannada: String, val labelEnglish: String) {
    ALL("ಎಲ್ಲಾ", "All"),
    KARNATAKA_GOVT("ಕರ್ನಾಟಕ ಸರಕಾರಿ", "Karnataka Govt"),
    CENTRAL_GOVT("ಕೇಂದ್ರ ಸರಕಾರಿ", "Central Govt"),
    BANKING("ಬ್ಯಾಂಕಿಂಗ್", "Banking"),
    POLICE_DEFENCE("ಪೊಲೀಸ್ / ರಕ್ಷಣೆ", "Police / Defence"),
    RAILWAY("ರೈಲ್ವೆ", "Railway"),
    PRIVATE_IT("ಖಾಸಗಿ / IT", "Private / IT")
}

data class JobArticle(
    val id: String,
    val titleKannada: String,
    val titleEnglish: String,
    val organization: String,
    val category: JobCategory,
    val qualification: String,
    val totalVacancies: String,
    val location: String,
    val salary: String,
    val lastDate: String,
    val applyStartDate: String,
    val ageLimit: String,
    val shortDescriptionKannada: String,
    val shortDescriptionEnglish: String,
    val fullArticleKannada: String,
    val fullArticleEnglish: String,
    val selectionProcess: List<String>,
    val applicationFee: String,
    val officialApplyUrl: String,
    val officialNotificationUrl: String,
    val officialWebsite: String,
    val isTrending: Boolean = false,
    val datePosted: String = "ಇಂದು"
)

data class JobVideo(
    val id: String,
    val titleKannada: String,
    val titleEnglish: String,
    val channelName: String,
    val youtubeVideoId: String,
    val duration: String,
    val views: String,
    val date: String,
    val thumbnailUrl: String,
    val description: String,
    val isUnlocked: Boolean = false
)

data class UnityAdConfig(
    val gameId: String = "5592831", // Unity Ads Preview / Test Game ID
    val bannerPlacementId: String = "Banner_Android",
    val interstitialPlacementId: String = "Interstitial_Android",
    val rewardedPlacementId: String = "Rewarded_Android",
    val isTestMode: Boolean = true
)
