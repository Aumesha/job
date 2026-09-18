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

enum class PrivateJobPortal(val displayName: String, val websiteUrl: String, val tagColor: Long) {
    ALL("ಎಲ್ಲಾ ಪೋರ್ಟಲ್‌ಗಳು", "", 0xFF3B82F6),
    FREE_JOB_ALERT("FreeJobAlert", "https://www.freejobalert.com", 0xFFE11D48),
    KARNATAKA_JOBS("KarnatakaJobs.in", "https://karnatakajobs.in", 0xFF059669),
    FRESHERSWORLD("Freshersworld", "https://www.freshersworld.com", 0xFF2563EB),
    NAUKRI("Naukri.com", "https://www.naukri.com", 0xFF0284C7),
    SHINE("Shine.com", "https://www.shine.com", 0xFFD97706),
    INDEED("Indeed India", "https://in.indeed.com", 0xFF4F46E5),
    SARKARI_RESULT("SarkariResult.com", "https://www.sarkariresult.com", 0xFFDC2626),
    FOUNDIT("Foundit / ಫೌಂಡಿಟ್", "https://www.foundit.in", 0xFF7C3AED),
    APNA_APP("Apna App Portal", "https://apna.co", 0xFF0D9488)
}

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
    val datePosted: String = "ಇಂದು",
    val portalSource: String = "FreeJobAlert",
    val portalUrl: String = "https://www.freejobalert.com"
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
    val isUnlocked: Boolean = false,
    val channelUrl: String = "https://www.youtube.com",
    val examCategory: String = "ಉದ್ಯೋಗ ಮಾಹಿತಿ"
)

data class CustomJobWebsite(
    val id: String,
    val url: String,
    val domain: String,
    val name: String,
    val addedAt: String = "ಈಗಷ್ಟೇ ಸೇರಿಸಲಾಗಿದೆ (Just added)",
    val lastSyncStatus: String = "Active (ಸ್ವಯಂಚಾಲಿತ ಸಿಂಕ್ ಸಕ್ರಿಯವಾಗಿದೆ)",
    val jobsCount: Int = 1
)

data class CustomYouTubeChannel(
    val id: String,
    val channelUrl: String,
    val channelName: String,
    val handle: String,
    val addedAt: String = "ಈಗಷ್ಟೇ ಸೇರಿಸಲಾಗಿದೆ (Just added)",
    val lastSyncStatus: String = "Active (ಸ್ವಯಂಚಾಲಿತ ಸಿಂಕ್ ಸಕ್ರಿಯವಾಗಿದೆ)",
    val videosCount: Int = 1
)

data class UnityAdConfig(
    val gameId: String = "5592831", // Unity Ads Preview / Test Game ID
    val bannerPlacementId: String = "Banner_Android",
    val interstitialPlacementId: String = "Interstitial_Android",
    val rewardedPlacementId: String = "Rewarded_Android",
    val isTestMode: Boolean = true
)
