package com.example.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.BusinessCenter
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import com.example.ads.UnityBannerAd
import com.example.ads.UnityInterstitialAdDialog
import com.example.ads.UnityRewardUnlockDialog
import com.example.ads.UnityRewardedAdPlayingScreen
import com.example.data.JobRepository
import com.example.model.AppMenu
import com.example.model.JobArticle
import com.example.model.JobCategory
import com.example.model.JobVideo
import com.example.model.LegalPolicyPage
import com.example.model.UnityAdConfig
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onOpenJobDetail: (JobArticle) -> Unit,
    onOpenVideoDetail: (JobVideo) -> Unit,
    isKannada: Boolean,
    onToggleLanguage: () -> Unit,
    adConfig: UnityAdConfig,
    onUpdateAdConfig: (UnityAdConfig) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var selectedMenu by remember { mutableStateOf(AppMenu.JOBS) }
    var selectedCategory by remember { mutableStateOf(JobCategory.ALL) }
    var searchQuery by remember { mutableStateOf("") }
    // Selected Portal filter for Menu 1 (null means ALL 9 Portals)
    var selectedPortal by remember { mutableStateOf<String?>(null) }
    // Selected Channel filter for Menu 2 (null means ALL 6 Channels)
    var selectedChannel by remember { mutableStateOf<String?>(null) }

    // Ads and Legal dialog states
    var showAdsSettings by remember { mutableStateOf(false) }
    var showPasswordDialog by remember { mutableStateOf(false) }
    var showLegalMenuDropdown by remember { mutableStateOf(false) }
    var activeLegalPage by remember { mutableStateOf<LegalPolicyPage?>(null) }

    // Ads states
    var showMenu2Interstitial by remember { mutableStateOf(false) }
    var videoPendingReward by remember { mutableStateOf<JobVideo?>(null) }
    var isPlayingRewardedAd by remember { mutableStateOf(false) }
    var unlockedVideoIds by remember { mutableStateOf(setOf<String>()) }

    // Collect reactive StateFlows from JobRepository (Continuous auto-sync)
    val allArticles by JobRepository.jobArticlesFlow.collectAsState()
    val allVideos by JobRepository.careerVideosFlow.collectAsState()
    val isSyncing by JobRepository.isSyncingFlow.collectAsState()
    val lastSyncTime by JobRepository.lastSyncTimeFlow.collectAsState()
    val customWebsites by JobRepository.customWebsitesFlow.collectAsState()
    val customChannels by JobRepository.customChannelsFlow.collectAsState()

    var secondsToNextSync by remember { mutableIntStateOf(45) }
    var autoSyncBannerText by remember { mutableStateOf<String?>(null) }

    // Continuous Automated Real-time Sync (No manual action required - auto syncs on launch & every 45s continuously)
    LaunchedEffect(Unit) {
        val (firstJobs, firstVids) = JobRepository.syncLatestFromPortalsAndChannels()
        if (firstJobs > 0 || firstVids > 0) {
            autoSyncBannerText = if (isKannada) "⚡ ತಾನಾಗಿಯೇ ಅಪ್‌ಡೇಟ್ ಆಗಿದೆ: $firstJobs ಹೊಸ ಉದ್ಯೋಗ, $firstVids ಹೊಸ ವೀಡಿಯೋಗಳು ಲೈವ್!"
                else "⚡ Auto-Synced: $firstJobs new jobs, $firstVids new videos live!"
        }
        while (true) {
            kotlinx.coroutines.delay(1000)
            if (secondsToNextSync > 1) {
                secondsToNextSync -= 1
            } else {
                secondsToNextSync = 45
                val (newJobs, newVids) = JobRepository.syncLatestFromPortalsAndChannels()
                if (newJobs > 0 || newVids > 0) {
                    autoSyncBannerText = if (isKannada) "⚡ ತಾನಾಗಿಯೇ ಅಪ್‌ಡೇಟ್ ಆಗಿದೆ: $newJobs ಹೊಸ ಉದ್ಯೋಗ, $newVids ಹೊಸ ವೀಡಿಯೋಗಳು ಲೈವ್!"
                        else "⚡ Auto-Updated: $newJobs new jobs, $newVids new videos live!"
                }
            }
        }
    }

    // Auto dismiss notification banner after 7 seconds
    LaunchedEffect(autoSyncBannerText) {
        if (autoSyncBannerText != null) {
            kotlinx.coroutines.delay(7000)
            autoSyncBannerText = null
        }
    }

    // Filtered Jobs by the 9 Private Portals
    val filteredArticles = allArticles.filter { article ->
        val matchesPortal = selectedPortal == null || article.portalSource.contains(selectedPortal!!, ignoreCase = true)
        val matchesSearch = if (searchQuery.isBlank()) true else {
            article.titleKannada.contains(searchQuery, ignoreCase = true) ||
            article.titleEnglish.contains(searchQuery, ignoreCase = true) ||
            article.organization.contains(searchQuery, ignoreCase = true) ||
            article.portalSource.contains(searchQuery, ignoreCase = true) ||
            article.qualification.contains(searchQuery, ignoreCase = true)
        }
        matchesPortal && matchesSearch
    }

    // Filtered Videos by the 6 YouTube Channels
    val filteredVideos = allVideos.filter { video ->
        val matchesChannel = selectedChannel == null || video.channelName.contains(selectedChannel!!, ignoreCase = true)
        val matchesSearch = if (searchQuery.isBlank()) true else {
            video.titleKannada.contains(searchQuery, ignoreCase = true) ||
            video.titleEnglish.contains(searchQuery, ignoreCase = true) ||
            video.channelName.contains(searchQuery, ignoreCase = true) ||
            video.examCategory.contains(searchQuery, ignoreCase = true)
        }
        matchesChannel && matchesSearch
    }

    // If a legal policy page was selected from the 3rd menu at the top, show it
    if (activeLegalPage != null) {
        LegalPolicyScreen(
            initialPage = activeLegalPage!!,
            isKannada = isKannada,
            onToggleLanguage = onToggleLanguage,
            adConfig = adConfig,
            onBack = { activeLegalPage = null },
            modifier = modifier
        )
        return
    }

    // Handle switching to Menu 2: triggers full screen interstitial ad as requested!
    val onMenuSelected: (AppMenu) -> Unit = { newMenu ->
        if (newMenu == AppMenu.VIDEOS && selectedMenu != AppMenu.VIDEOS) {
            showMenu2Interstitial = true
        }
        selectedMenu = newMenu
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    Brush.linearGradient(
                                        listOf(Color(0xFF2563EB), Color(0xFF0D9488))
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.BusinessCenter,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "Free Jobs",
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = if (isKannada) "ಉಚಿತ ಉದ್ಯೋಗ ಮಾಹಿತಿ" else "No Ads Inside Job Articles",
                                style = MaterialTheme.typography.bodySmall,
                                fontSize = 10.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                },
                actions = {
                    // 3RD MENU: Legal, Policy & Ads Info (Privacy, Terms, Contact, Disclaimer)
                    // Placed directly next to the gear box (Settings icon) at the top as requested!
                    Box {
                        IconButton(
                            onClick = { showLegalMenuDropdown = true },
                            modifier = Modifier.testTag("top_legal_menu_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Policy,
                                contentDescription = "Policies & Legal Menu",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }

                        DropdownMenu(
                            expanded = showLegalMenuDropdown,
                            onDismissRequest = { showLegalMenuDropdown = false }
                        ) {
                            DropdownMenuItem(
                                text = {
                                    Column {
                                        Text(
                                            text = if (isKannada) "1. ಗೌಪ್ಯತಾ ನೀತಿ" else "1. Privacy Policy",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp
                                        )
                                        Text(
                                            text = if (isKannada) "ಗೂಗಲ್ ಪ್ಲೇ & Unity Ads ನೀತಿ" else "Google Play & Unity Ads Policy",
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.outline
                                        )
                                    }
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Security,
                                        contentDescription = null,
                                        tint = Color(0xFF047857),
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                onClick = {
                                    showLegalMenuDropdown = false
                                    activeLegalPage = LegalPolicyPage.PRIVACY_POLICY
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Column {
                                        Text(
                                            text = if (isKannada) "2. ನಿಯಮಗಳು & ಷರತ್ತುಗಳು" else "2. Terms & Conditions",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp
                                        )
                                        Text(
                                            text = if (isKannada) "ಸೇವಾ ನಿಯಮಾವಳಿ & ಮಾರ್ಗಸೂಚಿ" else "Service Agreement & Guidelines",
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.outline
                                        )
                                    }
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Gavel,
                                        contentDescription = null,
                                        tint = Color(0xFF1D4ED8),
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                onClick = {
                                    showLegalMenuDropdown = false
                                    activeLegalPage = LegalPolicyPage.TERMS_CONDITIONS
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Column {
                                        Text(
                                            text = if (isKannada) "3. ಸಂಪರ್ಕಿಸಿ & ಸಹಾಯವಾಣಿ" else "3. Contact Us",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp
                                        )
                                        Text(
                                            text = if (isKannada) "ಇಮೇಲ್ & ಅಭ್ಯರ್ಥಿ ಸಹಾಯವಾಣಿ" else "Direct Email & Student Helpdesk",
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.outline
                                        )
                                    }
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Phone,
                                        contentDescription = null,
                                        tint = Color(0xFF0D9488),
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                onClick = {
                                    showLegalMenuDropdown = false
                                    activeLegalPage = LegalPolicyPage.CONTACT_US
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Column {
                                        Text(
                                            text = if (isKannada) "4. ಹಕ್ಕು ನಿರಾಕರಣೆ" else "4. Disclaimer",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp
                                        )
                                        Text(
                                            text = if (isKannada) "ಸರಕಾರೇತರ ಸ್ವತಂತ್ರ ಸಂಸ್ಥೆ ಘೋಷಣೆ" else "Non-Government Entity Declaration",
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.outline
                                        )
                                    }
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Warning,
                                        contentDescription = null,
                                        tint = Color(0xFFDC2626),
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                onClick = {
                                    showLegalMenuDropdown = false
                                    activeLegalPage = LegalPolicyPage.DISCLAIMER
                                }
                            )
                        }
                    }

                    // Settings (Protected by password)
                    IconButton(
                        onClick = { showPasswordDialog = true },
                        modifier = Modifier.testTag("main_ads_settings_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    // Language Toggle
                    IconButton(
                        onClick = onToggleLanguage,
                        modifier = Modifier.testTag("main_language_toggle")
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.12f))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = if (isKannada) "EN" else "ಕನ್ನಡ",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            // Permanently only two bottom menus (compact height as requested):
            // 1st Menu: Job Articles (ಜಾಬ್ ಆರ್ಟಿಕಲ್ಸ್)
            // 2nd Menu: YouTube Job Videos (ಉದ್ಯೋಗ ವೀಡಿಯೋಗಳು)
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 4.dp,
                modifier = Modifier
                    .height(64.dp)
                    .testTag("bottom_menu_bar")
            ) {
                NavigationBarItem(
                    selected = selectedMenu == AppMenu.JOBS,
                    onClick = { onMenuSelected(AppMenu.JOBS) },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = "Jobs",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    label = {
                        Text(
                            text = if (isKannada) "ಜಾಬ್ ಆರ್ಟಿಕಲ್ಸ್" else "Job Articles",
                            fontSize = 11.sp,
                            fontWeight = if (selectedMenu == AppMenu.JOBS) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    modifier = Modifier.testTag("menu_jobs_tab")
                )

                NavigationBarItem(
                    selected = selectedMenu == AppMenu.VIDEOS,
                    onClick = { onMenuSelected(AppMenu.VIDEOS) },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.VideoLibrary,
                            contentDescription = "Videos",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    label = {
                        Text(
                            text = if (isKannada) "ಉದ್ಯೋಗ ವೀಡಿಯೋ" else "Career Videos",
                            fontSize = 11.sp,
                            fontWeight = if (selectedMenu == AppMenu.VIDEOS) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    modifier = Modifier.testTag("menu_videos_tab")
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Search Bar (Shown on Jobs & Videos tabs - compacted as requested)
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 3.dp)) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("search_text_field"),
                    placeholder = {
                        Text(
                            text = if (selectedMenu == AppMenu.JOBS) {
                                if (isKannada) "ಹುದ್ದೆ, ಇಲಾಖೆ ಹುಡುಕಿ..." else "Search jobs, department..."
                            } else {
                                if (isKannada) "ವೀಡಿಯೋ ಹುಡುಕಿ..." else "Search videos..."
                            },
                            fontSize = 12.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(
                                onClick = { searchQuery = "" },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear",
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                    )
                )
            }

            // Live Automated Sync Indicator & Trigger
            LiveSyncHeaderBar(
                isSyncing = isSyncing,
                lastSyncTime = lastSyncTime,
                secondsRemaining = secondsToNextSync,
                isKannada = isKannada,
                onSyncClick = {
                    coroutineScope.launch {
                        val (newArticles, newVideos) = JobRepository.syncLatestFromPortalsAndChannels()
                        if (newArticles > 0 || newVideos > 0) {
                            autoSyncBannerText = if (isKannada) "⚡ ತಾನಾಗಿಯೇ ಅಪ್‌ಡೇಟ್ ಆಗಿದೆ: $newArticles ಹೊಸ ಜಾಬ್, $newVideos ಹೊಸ ವೀಡಿಯೋಗಳು ಲೈವ್!"
                                else "⚡ Live Synced: $newArticles new jobs, $newVideos new career videos!"
                            Toast.makeText(
                                context,
                                if (isKannada) "ಆಟೋ-ಸಿಂಕ್ ಯಶಸ್ವಿ: $newArticles ಹೊಸ ಜಾಬ್ ಅಧಿಸೂಚನೆಗಳು, $newVideos ಹೊಸ ವೀಡಿಯೋಗಳು ಲೈವ್ ಆಗಿವೆ!"
                                else "Live Sync: $newArticles new job notices, $newVideos new career videos updated!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                context,
                                if (isKannada) "ಎಲ್ಲಾ 9 ಖಾಸಗಿ ಜಾಬ್ ವೆಬ್‌ಸೈಟ್‌ಗಳು & 6 ಯೂಟ್ಯೂಬ್ ಚಾನೆಲ್‌ಗಳು ಈಗಾಗಲೇ ನವೀಕೃತವಾಗಿವೆ"
                                else "All 9 private job portals & 6 YouTube channels are currently up to date",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            )

            // Animated Banner for Automatic Sync Notification
            AnimatedVisibility(visible = autoSyncBannerText != null) {
                Surface(
                    color = Color(0xFF047857),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Bolt,
                            contentDescription = null,
                            tint = Color(0xFFFDE047),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = autoSyncBannerText ?: "",
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(
                            onClick = { autoSyncBannerText = null },
                            modifier = Modifier.size(22.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close",
                                tint = Color.White,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }

            // Filter Chips for Menu 1: 9 Private Job Portals + Custom Added Portals
            if (selectedMenu == AppMenu.JOBS) {
                val basePortals = listOf(
                    null to (if (isKannada) "ಎಲ್ಲಾ ಪೋರ್ಟಲ್‌ಗಳು" else "All Portals"),
                    "FreeJobAlert" to "1. FreeJobAlert",
                    "KarnatakaJobs" to "2. KarnatakaJobs.in",
                    "Freshersworld" to "3. Freshersworld",
                    "Naukri" to "4. Naukri.com",
                    "Shine" to "5. Shine.com",
                    "Indeed" to "6. Indeed India",
                    "SarkariResult" to "7. SarkariResult.com",
                    "Foundit" to "8. Foundit (Monster)",
                    "Apna" to "9. Apna App Portal"
                )
                val customPortalOptions = customWebsites.map { site ->
                    site.name to "🌐 ${site.name}"
                }
                val portalOptions = basePortals + customPortalOptions
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 6.dp)
                ) {
                    items(portalOptions) { (portalKey, label) ->
                        val isSelected = selectedPortal == portalKey
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedPortal = portalKey },
                            label = {
                                Text(
                                    text = label,
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                selectedLabelColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                }
            }

            // Filter Chips for Menu 2: 6 Top YouTube Channels + Custom Added Channels
            if (selectedMenu == AppMenu.VIDEOS) {
                val baseChannels = listOf(
                    null to (if (isKannada) "ಎಲ್ಲಾ ಚಾನೆಲ್‌ಗಳು" else "All Channels"),
                    "Spardha Chaitra" to "1. ಸ್ಪರ್ಧಾ ಚೈತ್ರ",
                    "Karnataka Jobs Alert" to "2. ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್",
                    "Classic Education" to "3. ಕ್ಲಾಸಿಕ್ ಎಜುಕೇಶನ್ / KPSC ವಾಣಿ",
                    "Spardha Sphoorthi" to "4. ಸ್ಪರ್ಧಾ ಸ್ಫೂರ್ತಿ",
                    "Shreedhar" to "5. ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ",
                    "Karnataka Udyoga Mitra" to "6. ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ಮಿತ್ರ"
                )
                val customChannelOptions = customChannels.map { chan ->
                    chan.channelName to "📺 ${chan.channelName}"
                }
                val channelOptions = baseChannels + customChannelOptions
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 6.dp)
                ) {
                    items(channelOptions) { (channelKey, label) ->
                        val isSelected = selectedChannel == channelKey
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedChannel = channelKey },
                            label = {
                                Text(
                                    text = label,
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFFFFE4E6),
                                selectedLabelColor = Color(0xFFDC2626)
                            )
                        )
                    }
                }
            }

            // MENU 1: JOB ARTICLES LIST
            if (selectedMenu == AppMenu.JOBS) {
                Column(modifier = Modifier.fillMaxSize()) {
                    // TOP BANNER AD (Requested: "1 ನೇ ಮೆನುವಿನಲ್ಲಿ ಮೇಲೆ banner ad")
                    UnityBannerAd(
                        placementId = "Banner_Jobs_Top",
                        config = adConfig,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    // Articles List with In-feed Ad after every 4 articles
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .testTag("job_articles_list"),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        itemsIndexed(filteredArticles) { index, article ->
                            JobArticleCard(
                                article = article,
                                isKannada = isKannada,
                                onReadMoreClicked = { onOpenJobDetail(article) }
                            )

                            // IN-FEED BANNER AD (Requested: "ಪ್ರತಿ 4 ಆರ್ಟಿಕಲ್ ಮಧ್ಯದಲ್ಲಿ ಒಂದು banner ad")
                            if ((index + 1) % 4 == 0 && index != filteredArticles.size - 1) {
                                Spacer(modifier = Modifier.height(4.dp))
                                UnityBannerAd(
                                    placementId = "Banner_Jobs_InFeed_${(index + 1) / 4}",
                                    config = adConfig
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                            }
                        }
                    }

                    // BOTTOM BANNER AD (Requested: "1 ನೇ ಮೆನುವಿನಲ್ಲಿ ಕೆಳಗೆ banner ad")
                    UnityBannerAd(
                        placementId = "Banner_Jobs_Bottom",
                        config = adConfig,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }

            // MENU 2: YOUTUBE CAREER VIDEOS LIST
            if (selectedMenu == AppMenu.VIDEOS) {
                Column(modifier = Modifier.fillMaxSize()) {
                    // TOP BANNER AD (Requested: "2 ನೇ ಮೆನುವಿನಲ್ಲಿ ಒಳಗಡೆ ಮೇಲೆ banner ad")
                    UnityBannerAd(
                        placementId = "Banner_Videos_Top",
                        config = adConfig,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    // Videos List with In-feed Ad after every 4 videos
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .testTag("videos_list"),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        itemsIndexed(filteredVideos) { index, video ->
                            val isUnlocked = unlockedVideoIds.contains(video.id)
                            VideoItemCard(
                                video = video,
                                isUnlocked = isUnlocked,
                                isKannada = isKannada,
                                onVideoClicked = {
                                    if (isUnlocked) {
                                        onOpenVideoDetail(video)
                                    } else {
                                        // Show Reward Ad gate dialog as requested!
                                        videoPendingReward = video
                                    }
                                }
                            )

                            // IN-FEED BANNER AD (Requested: "ಪ್ರತಿ 4 ವಿಡಿಯೋಗಳ ಕೆಳಗಡೆ ಒಂದು banner ad")
                            if ((index + 1) % 4 == 0 && index != filteredVideos.size - 1) {
                                Spacer(modifier = Modifier.height(4.dp))
                                UnityBannerAd(
                                    placementId = "Banner_Videos_InFeed_${(index + 1) / 4}",
                                    config = adConfig
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                            }
                        }
                    }

                    // BOTTOM BANNER AD (Requested: "2 ನೇ ಮೆನುವಿನಲ್ಲಿ ಕೆಳಗೆ banner ad")
                    UnityBannerAd(
                        placementId = "Banner_Videos_Bottom",
                        config = adConfig,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }
        }
    }

    // Full Screen Interstitial Ad when Menu 2 opened (Requested by user)
    if (showMenu2Interstitial) {
        UnityInterstitialAdDialog(
            placementId = adConfig.interstitialPlacementId,
            config = adConfig,
            onDismiss = { showMenu2Interstitial = false }
        )
    }

    // Rewarded Ad Unlock Prompt Dialog ("Watch ad and unlock your video")
    videoPendingReward?.let { pendingVideo ->
        UnityRewardUnlockDialog(
            videoTitle = if (isKannada) pendingVideo.titleKannada else pendingVideo.titleEnglish,
            onWatchAdClicked = {
                isPlayingRewardedAd = true
            },
            onDismiss = { videoPendingReward = null }
        )
    }

    // Rewarded Ad Playing Simulation
    if (isPlayingRewardedAd && videoPendingReward != null) {
        UnityRewardedAdPlayingScreen(
            placementId = adConfig.rewardedPlacementId,
            config = adConfig,
            onRewardEarned = {
                val targetVideo = videoPendingReward
                isPlayingRewardedAd = false
                videoPendingReward = null
                if (targetVideo != null) {
                    unlockedVideoIds = unlockedVideoIds + targetVideo.id
                    onOpenVideoDetail(targetVideo)
                }
            }
        )
    }

    // Password Prompt Dialog before opening Settings
    if (showPasswordDialog) {
        SettingsPasswordDialog(
            onSuccess = {
                showPasswordDialog = false
                showAdsSettings = true
            },
            onDismiss = { showPasswordDialog = false },
            isKannada = isKannada
        )
    }

    // App Settings Dialog (Option 1: Add Websites, Option 2: Add YouTube Channels, Option 3: Unity Ads)
    if (showAdsSettings) {
        AppSettingsDialog(
            currentConfig = adConfig,
            onSaveConfig = onUpdateAdConfig,
            onDismiss = { showAdsSettings = false },
            isKannada = isKannada
        )
    }
}

/**
 * Password Prompt Dialog for opening Settings
 * Requires password: "aumesha"
 */
@Composable
fun SettingsPasswordDialog(
    onSuccess: () -> Unit,
    onDismiss: () -> Unit,
    isKannada: Boolean
) {
    var enteredPassword by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .testTag("settings_password_dialog")
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(26.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = if (isKannada) "ಸೆಟ್ಟಿಂಗ್ಸ್ ಪಾಸ್‌ವರ್ಡ್ (Password)" else "Settings Password",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = if (isKannada) "ಸೆಟ್ಟಿಂಗ್ಸ್ ಬಾಕ್ಸ್ ತೆರೆಯಲು ದಯವಿಟ್ಟು ರಹಸ್ಯ ಪಾಸ್‌ವರ್ಡ್ ನಮೂದಿಸಿ."
                    else "Please enter the secret password to open settings.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = enteredPassword,
                    onValueChange = {
                        enteredPassword = it
                        isError = false
                    },
                    label = { Text(if (isKannada) "ಪಾಸ್‌ವರ್ಡ್ ನಮೂದಿಸಿ" else "Enter Password") },
                    placeholder = { Text("password") },
                    singleLine = true,
                    isError = isError,
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            Icon(
                                imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = "Toggle password visibility",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("settings_password_input"),
                    shape = RoundedCornerShape(10.dp)
                )

                if (isError) {
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = if (isKannada) "❌ ತಪ್ಪಾದ ಪಾಸ್‌ವರ್ಡ್! ಸರಿಯಾದ ಪಾಸ್‌ವರ್ಡ್ ಹಾಕಿ."
                        else "❌ Incorrect password! Please enter the correct password.",
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text(if (isKannada) "ರದ್ದುಮಾಡಿ" else "Cancel")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {
                            if (enteredPassword.trim() == "aumesha") {
                                onSuccess()
                            } else {
                                isError = true
                            }
                        },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.testTag("submit_settings_password_button")
                    ) {
                        Text(if (isKannada) "ತೆರೆಯಿರಿ (Open)" else "Open")
                    }
                }
            }
        }
    }
}

/**
 * Job Article Card in Menu 1
 */
@Composable
fun JobArticleCard(
    article: JobArticle,
    isKannada: Boolean,
    onReadMoreClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onReadMoreClicked() }
            .testTag("job_article_card_${article.id}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Header Row: Portal Source badge & Vacancies
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF2563EB).copy(alpha = 0.12f))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.BusinessCenter,
                                contentDescription = null,
                                tint = Color(0xFF1D4ED8),
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = article.portalSource.ifBlank { article.organization },
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1D4ED8),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    if (article.datePosted.contains("ಸಿಂಕ್") || article.datePosted.contains("Just") || article.datePosted.contains("ಲೈವ್") || article.isTrending) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(0xFF10B981).copy(alpha = 0.15f))
                                .padding(horizontal = 6.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = "✨ ಹೊಸದು (NEW)",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF059669)
                            )
                        }
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.People,
                        contentDescription = null,
                        tint = Color(0xFF059669),
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = article.totalVacancies,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF059669)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Title
            Text(
                text = if (isKannada) article.titleKannada else article.titleEnglish,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Short Description
            Text(
                text = if (isKannada) article.shortDescriptionKannada else article.shortDescriptionEnglish,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Footer: Last Date & "Read More" Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = null,
                        tint = Color(0xFFDC2626),
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${if (isKannada) "ಕೊನೆ ದಿನ:" else "Last Date:"} ${article.lastDate}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFDC2626)
                    )
                }

                // Requested "ರೀಡ್ ಮೋರ್ (Read More)" button
                Button(
                    onClick = onReadMoreClicked,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                    modifier = Modifier.testTag("read_more_button_${article.id}")
                ) {
                    Text(
                        text = if (isKannada) "ರೀಡ್ ಮೋರ್ (ವಿವರ)" else "Read More",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

/**
 * YouTube Video Item Card in Menu 2
 */
@Composable
fun VideoItemCard(
    video: JobVideo,
    isUnlocked: Boolean,
    isKannada: Boolean,
    onVideoClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onVideoClicked() }
            .testTag("video_card_${video.id}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            // Educational Job Video Broadcast Banner (No external exercise/fitness images)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0xFF0F172A),
                                Color(0xFF1E293B),
                                Color(0xFF0B192C)
                            )
                        )
                    )
            ) {
                // Background subtle accent graphic
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.radialGradient(
                                colors = listOf(
                                    Color(0xFFDC2626).copy(alpha = 0.18f),
                                    Color.Transparent
                                )
                            )
                        )
                )

                // Top Bar: Channel Badge (Red YouTube style) & Unlock Status Pill
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // YouTube Channel Badge
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(0xFFDC2626))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.VideoLibrary,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(13.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = video.channelName,
                                    color = Color.White,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        if (video.date.contains("ಸಿಂಕ್") || video.date.contains("Just") || video.date.contains("ಲೈವ್") || video.date.contains("ಅಪ್‌ಲೋಡ್")) {
                            Spacer(modifier = Modifier.width(6.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xFF10B981))
                                    .padding(horizontal = 6.dp, vertical = 3.dp)
                            ) {
                                Text(
                                    text = "✨ ಹೊಸದು (NEW)",
                                    color = Color.White,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    // Unlock Status Pill
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (isUnlocked) Color(0xFF059669) else Color(0xFFD97706))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = if (isUnlocked) Icons.Default.LockOpen else Icons.Default.Lock,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(11.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isUnlocked) "ಅನ್‌ಲಾಕ್ ಆಗಿದೆ" else "ಜಾಹೀರಾತು ನೋಡಿ",
                                color = Color.White,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Black
                            )
                        }
                    }
                }

                // Center: Exam Category & Center Play/Lock Icon
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Exam Category Badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White.copy(alpha = 0.15f))
                            .padding(horizontal = 10.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = video.examCategory.ifBlank { "ಉದ್ಯೋಗ ತಯಾರಿ 2026" },
                            color = Color(0xFFFDE047),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // Center Play/Lock Icon
                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .clip(CircleShape)
                            .background(if (isUnlocked) Color(0xFFDC2626) else Color(0xFF0F172A).copy(alpha = 0.9f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = if (isUnlocked) Icons.Default.PlayArrow else Icons.Default.Lock,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                }

                // Bottom bar: Views count and Duration badge
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Views badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Black.copy(alpha = 0.75f))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = video.views,
                            color = Color(0xFFE2E8F0),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    // Duration badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Black.copy(alpha = 0.85f))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = video.duration,
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Video Meta Details
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = if (isKannada) video.titleKannada else video.titleEnglish,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = video.channelName,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "${video.views} • ${video.date}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Watch Button
                Button(
                    onClick = onVideoClicked,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isUnlocked) Color(0xFFDC2626) else Color(0xFF0D9488)
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("video_action_button_${video.id}")
                ) {
                    Icon(
                        imageVector = if (isUnlocked) Icons.Default.PlayArrow else Icons.Default.LockOpen,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isUnlocked) {
                            if (isKannada) "ವೀಡಿಯೋ ಪ್ಲೇ ಮಾಡಿ (Play Video)" else "Play Video"
                        } else {
                            "watch ad and unlock your video"
                        },
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
fun LiveSyncHeaderBar(
    isSyncing: Boolean,
    lastSyncTime: String,
    secondsRemaining: Int,
    isKannada: Boolean,
    onSyncClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "sync_spin")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing)
        ),
        label = "rotation"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 2.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                // Pulsing live indicator circle
                Box(
                    modifier = Modifier
                        .size(9.dp)
                        .clip(CircleShape)
                        .background(if (isSyncing) Color(0xFFF59E0B) else Color(0xFF10B981))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = if (isSyncing) {
                                if (isKannada) "🔄 ಲೈವ್ ಸಿಂಕ್ ಆಗುತ್ತಿದೆ..." else "🔄 Auto-Syncing Portals & Channels..."
                            } else {
                                if (isKannada) "⚡ 45s ಆಟೋ-ಸಿಂಕ್ ಸಕ್ರಿಯ" else "⚡ 45s Auto-Sync Active"
                            },
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(if (isSyncing) Color(0xFFF59E0B).copy(alpha = 0.2f) else Color(0xFF10B981).copy(alpha = 0.2f))
                                .padding(horizontal = 5.dp, vertical = 1.dp)
                        ) {
                            Text(
                                text = if (isSyncing) "Syncing" else "${secondsRemaining}s",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSyncing) Color(0xFFD97706) else Color(0xFF059669)
                            )
                        }
                    }
                    Text(
                        text = if (isSyncing) {
                            if (isKannada) "ಎಲ್ಲಾ ವೆಬ್‌ಸೈಟ್‌ಗಳು & ಚಾನೆಲ್‌ಗಳ ಹೊಸ ಅಪ್‌ಡೇಟ್ ಪರಿಶೀಲಿಸಲಾಗುತ್ತಿದೆ..."
                            else "Checking 9 portals & 6 YouTube channels for new updates..."
                        } else {
                            if (isKannada) "$lastSyncTime (ಯಾವುದೇ ಹೊಸ ಮಾಹಿತಿ ಬಂದರೆ ತಕ್ಷಣವೇ ಕಾಣಿಸುತ್ತದೆ)"
                            else "$lastSyncTime (Instant live updates appear automatically)"
                        },
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            IconButton(
                onClick = onSyncClick,
                enabled = !isSyncing,
                modifier = Modifier
                    .size(32.dp)
                    .testTag("manual_sync_button")
            ) {
                Icon(
                    imageVector = Icons.Default.Sync,
                    contentDescription = "Sync",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(18.dp)
                        .rotate(if (isSyncing) rotation else 0f)
                )
            }
        }
    }
}

