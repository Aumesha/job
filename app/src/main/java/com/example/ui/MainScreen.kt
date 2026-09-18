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
import androidx.compose.material.icons.filled.BusinessCenter
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Clear
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import coil.compose.AsyncImage
import com.example.ads.UnityAdsSettingsDialog
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
    var showAdsSettings by remember { mutableStateOf(false) }
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

    // Automatically trigger initial background check for new jobs & videos
    LaunchedEffect(Unit) {
        JobRepository.syncLatestFromPortalsAndChannels()
    }

    // Filtered Jobs
    val filteredArticles = allArticles.filter { article ->
        val matchesCategory = selectedCategory == JobCategory.ALL || article.category == selectedCategory
        val matchesSearch = if (searchQuery.isBlank()) true else {
            article.titleKannada.contains(searchQuery, ignoreCase = true) ||
            article.titleEnglish.contains(searchQuery, ignoreCase = true) ||
            article.organization.contains(searchQuery, ignoreCase = true) ||
            article.qualification.contains(searchQuery, ignoreCase = true)
        }
        matchesCategory && matchesSearch
    }

    // Filtered Videos
    val filteredVideos = allVideos.filter { video ->
        if (searchQuery.isBlank()) true else {
            video.titleKannada.contains(searchQuery, ignoreCase = true) ||
            video.titleEnglish.contains(searchQuery, ignoreCase = true) ||
            video.channelName.contains(searchQuery, ignoreCase = true)
        }
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
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = if (isKannada) "ಉಚಿತ ಉದ್ಯೋಗ ಮಾಹಿತಿ" else "No Ads Inside Job Articles",
                                style = MaterialTheme.typography.bodySmall,
                                fontSize = 11.sp,
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

                    // Unity Ads Settings (Gare box)
                    IconButton(
                        onClick = { showAdsSettings = true },
                        modifier = Modifier.testTag("main_ads_settings_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Ads Configuration",
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
            // Permanently only two bottom menus:
            // 1st Menu: Job Articles (ಜಾಬ್ ಆರ್ಟಿಕಲ್ಸ್)
            // 2nd Menu: YouTube Job Videos (ಉದ್ಯೋಗ ವೀಡಿಯೋಗಳು)
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 6.dp,
                modifier = Modifier.testTag("bottom_menu_bar")
            ) {
                NavigationBarItem(
                    selected = selectedMenu == AppMenu.JOBS,
                    onClick = { onMenuSelected(AppMenu.JOBS) },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = "Jobs"
                        )
                    },
                    label = {
                        Text(
                            text = if (isKannada) "ಜಾಬ್ ಆರ್ಟಿಕಲ್ಸ್" else "Job Articles",
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
                            contentDescription = "Videos"
                        )
                    },
                    label = {
                        Text(
                            text = if (isKannada) "ಉದ್ಯೋಗ ವೀಡಿಯೋ" else "Career Videos",
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
            // Search Bar (Shown on Jobs & Videos tabs)
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("search_text_field"),
                    placeholder = {
                        Text(
                            text = if (selectedMenu == AppMenu.JOBS) {
                                if (isKannada) "ಹುದ್ದೆ, ಇಲಾಖೆ ಅಥವಾ ಅರ್ಹತೆ ಹುಡುಕಿ..." else "Search jobs, department, qualification..."
                            } else {
                                if (isKannada) "ವೀಡಿಯೋ ಅಥವಾ ವಿಷಯ ಹುಡುಕಿ..." else "Search career videos..."
                            },
                            fontSize = 13.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                            }
                        }
                    },
                    shape = RoundedCornerShape(12.dp),
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
                isKannada = isKannada,
                onSyncClick = {
                    coroutineScope.launch {
                        val (newArticles, newVideos) = JobRepository.syncLatestFromPortalsAndChannels()
                        if (newArticles > 0 || newVideos > 0) {
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

            // Category Chips for Menu 1 (Jobs)
            if (selectedMenu == AppMenu.JOBS) {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 6.dp)
                ) {
                    items(JobCategory.values()) { category ->
                        FilterChip(
                            selected = selectedCategory == category,
                            onClick = { selectedCategory = category },
                            label = {
                                Text(
                                    text = if (isKannada) category.labelKannada else category.labelEnglish,
                                    fontSize = 12.sp
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

    // Unity Ads Settings Dialog
    if (showAdsSettings) {
        UnityAdsSettingsDialog(
            currentConfig = adConfig,
            onSaveConfig = onUpdateAdConfig,
            onDismiss = { showAdsSettings = false }
        )
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
            // Header Row: Org badge & Vacancies
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = article.organization,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
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
            // Thumbnail with Play & Lock overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .background(Color.DarkGray),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = video.thumbnailUrl,
                    contentDescription = video.titleEnglish,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Dark vignette
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f))
                )

                // Center Icon (Unlocked play or Lock icon)
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(if (isUnlocked) Color(0xFFFF0000) else Color(0xFF0F172A).copy(alpha = 0.85f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (isUnlocked) Icons.Default.PlayArrow else Icons.Default.Lock,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(26.dp)
                    )
                }

                // Duration badge
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color.Black.copy(alpha = 0.8f))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = video.duration,
                        color = Color.White,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Unlock Status Pill
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(
                            if (isUnlocked) Color(0xFF059669) else Color(0xFFD97706)
                        )
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = if (isUnlocked) Icons.Default.LockOpen else Icons.Default.Lock,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(12.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (isUnlocked) "UNLOCKED" else "WATCH AD TO UNLOCK",
                            color = Color.White,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Black
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
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
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
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(if (isSyncing) Color(0xFFF59E0B) else Color(0xFF10B981))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = if (isSyncing) {
                            if (isKannada) "ಹೊಸ ಜಾಬ್ & ವೀಡಿಯೋ ಪರಿಶೀಲಿಸಲಾಗುತ್ತಿದೆ..." else "Fetching updates from private portals & channels..."
                        } else {
                            if (isKannada) "ಆಟೋ-ಸಿಂಕ್: 9 ಖಾಸಗಿ ಜಾಬ್ ವೆಬ್‌ಸೈಟ್ & 6 ಚಾನೆಲ್ ಲೈವ್" else "Auto-Sync: 9 Private Portals & 6 Channels Live"
                        },
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = if (isKannada) "ಕೊನೆಯ ನವೀಕರಣ: $lastSyncTime" else "Last update: $lastSyncTime",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
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

