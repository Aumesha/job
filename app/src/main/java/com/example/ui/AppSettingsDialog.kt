package com.example.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.JobRepository
import com.example.model.CustomJobWebsite
import com.example.model.CustomYouTubeChannel
import com.example.model.UnityAdConfig
import kotlinx.coroutines.launch

@Composable
fun AppSettingsDialog(
    currentConfig: UnityAdConfig,
    onSaveConfig: (UnityAdConfig) -> Unit,
    onDismiss: () -> Unit,
    isKannada: Boolean = true
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var selectedTab by remember { mutableIntStateOf(0) } // 0: Websites, 1: YouTube Channels, 2: Unity Ads

    val customWebsites by JobRepository.customWebsitesFlow.collectAsState()
    val customChannels by JobRepository.customChannelsFlow.collectAsState()

    // Inputs
    var websiteUrlInput by remember { mutableStateOf("") }
    var channelUrlInput by remember { mutableStateOf("") }

    // Unity Ads state
    var gameId by remember { mutableStateOf(currentConfig.gameId) }
    var bannerId by remember { mutableStateOf(currentConfig.bannerPlacementId) }
    var interstitialId by remember { mutableStateOf(currentConfig.interstitialPlacementId) }
    var rewardedId by remember { mutableStateOf(currentConfig.rewardedPlacementId) }
    var testMode by remember { mutableStateOf(currentConfig.isTestMode) }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.96f)
                .fillMaxHeight(0.92f)
                .clip(RoundedCornerShape(20.dp))
                .testTag("app_settings_dialog"),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f))
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = if (isKannada) "ಆ್ಯಪ್ ಸೆಟ್ಟಿಂಗ್ಸ್ (Settings)" else "App Settings",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = if (isKannada) "ವೆಬ್‌ಸೈಟ್ & ಯೂಟ್ಯೂಬ್ ಚಾನೆಲ್ ಆಟೋ-ಸಿಂಕ್" else "Website & YouTube Auto-Sync Controls",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.testTag("close_settings_dialog_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // 3 Tabs (Option 1: Websites, Option 2: YouTube Channels, 3: Unity Ads)
                ScrollableTabRow(
                    selectedTabIndex = selectedTab,
                    edgePadding = 12.dp,
                    indicator = { tabPositions ->
                        TabRowDefaults.SecondaryIndicator(
                            Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                            color = MaterialTheme.colorScheme.primary,
                            height = 3.dp
                        )
                    }
                ) {
                    Tab(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Language,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = if (selectedTab == 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = if (isKannada) "1. ವೆಬ್‌ಸೈಟ್‌ಗಳು" else "1. Websites",
                                    fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Normal,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    )
                    Tab(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Tv,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = if (selectedTab == 1) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = if (isKannada) "2. ಯೂಟ್ಯೂಬ್" else "2. YouTube",
                                    fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Normal,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    )
                    Tab(
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 },
                        text = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Settings,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = if (selectedTab == 2) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "3. Unity Ads",
                                    fontWeight = if (selectedTab == 2) FontWeight.Bold else FontWeight.Normal,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    )
                }

                // Tab Content
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(14.dp)
                ) {
                    when (selectedTab) {
                        0 -> OptionWebsitesTab(
                            websiteUrlInput = websiteUrlInput,
                            onWebsiteUrlChange = { websiteUrlInput = it },
                            customWebsites = customWebsites,
                            onAddWebsite = { url ->
                                if (url.isNotBlank()) {
                                    val success = JobRepository.addCustomJobWebsite(url)
                                    if (success) {
                                        websiteUrlInput = ""
                                        Toast.makeText(
                                            context,
                                            if (isKannada) "ವೆಬ್‌ಸೈಟ್ ಯಶಸ್ವಿಯಾಗಿ ಸೇರಿಸಲಾಗಿದೆ! ಪ್ರತಿ 45 ಸೆಕೆಂಡಿಗೆ ಆಟೋ-ಸಿಂಕ್ ಆಗುತ್ತದೆ."
                                            else "Website added successfully! Auto-syncs every 45 seconds.",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            },
                            onDeleteWebsite = { id ->
                                JobRepository.removeCustomJobWebsite(id)
                                Toast.makeText(
                                    context,
                                    if (isKannada) "ವೆಬ್‌ಸೈಟ್ ತೆಗೆದುಹಾಕಲಾಗಿದೆ" else "Website removed",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            isKannada = isKannada
                        )

                        1 -> OptionYouTubeTab(
                            channelUrlInput = channelUrlInput,
                            onChannelUrlChange = { channelUrlInput = it },
                            customChannels = customChannels,
                            onAddChannel = { url ->
                                if (url.isNotBlank()) {
                                    val success = JobRepository.addCustomYouTubeChannel(url)
                                    if (success) {
                                        channelUrlInput = ""
                                        Toast.makeText(
                                            context,
                                            if (isKannada) "ಯೂಟ್ಯೂಬ್ ಚಾನೆಲ್ ಸೇರಿಸಲಾಗಿದೆ! ವೀಡಿಯೋಗಳು ಮೆನುವಿನಲ್ಲಿ ಲೈವ್ ಆಗಿ ಕಾಣಿಸುತ್ತವೆ."
                                            else "YouTube channel added! Videos are now live in the videos menu.",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            },
                            onDeleteChannel = { id ->
                                JobRepository.removeCustomYouTubeChannel(id)
                                Toast.makeText(
                                    context,
                                    if (isKannada) "ಚಾನೆಲ್ ತೆಗೆದುಹಾಕಲಾಗಿದೆ" else "Channel removed",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            isKannada = isKannada
                        )

                        2 -> UnityAdsTab(
                            gameId = gameId,
                            onGameIdChange = { gameId = it },
                            bannerId = bannerId,
                            onBannerIdChange = { bannerId = it },
                            interstitialId = interstitialId,
                            onInterstitialIdChange = { interstitialId = it },
                            rewardedId = rewardedId,
                            onRewardedIdChange = { rewardedId = it },
                            testMode = testMode,
                            onTestModeChange = { testMode = it },
                            onSave = {
                                val updated = currentConfig.copy(
                                    gameId = gameId.trim(),
                                    bannerPlacementId = bannerId.trim(),
                                    interstitialPlacementId = interstitialId.trim(),
                                    rewardedPlacementId = rewardedId.trim(),
                                    isTestMode = testMode
                                )
                                onSaveConfig(updated)
                                Toast.makeText(
                                    context,
                                    if (isKannada) "Unity Ads ಸೆಟ್ಟಿಂಗ್ಸ್ ಉಳಿಸಲಾಗಿದೆ!" else "Unity Ads Configuration Saved!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                onDismiss()
                            },
                            isKannada = isKannada
                        )
                    }
                }
            }
        }
    }
}

/**
 * Option 1: Custom Job Websites Box and Auto-Sync List
 */
@Composable
private fun OptionWebsitesTab(
    websiteUrlInput: String,
    onWebsiteUrlChange: (String) -> Unit,
    customWebsites: List<CustomJobWebsite>,
    onAddWebsite: (String) -> Unit,
    onDeleteWebsite: (String) -> Unit,
    isKannada: Boolean
) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Title & Description Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Language,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isKannada) "ಆಯ್ಕೆ 1: ಕಸ್ಟಮ್ ಜಾಬ್ ವೆಬ್‌ಸೈಟ್‌ಗಳು ಸೇರಿಸಿ" else "Option 1: Add Custom Job Websites",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = if (isKannada) "ಯಾವುದೇ ಉದ್ಯೋಗ ವೆಬ್‌ಸೈಟ್‌ನ URL/ಲಿಂಕ್ ಹಾಕಿ. ಪ್ರತಿ 45 ಸೆಕೆಂಡಿಗೆ ಹೊಸ ಜಾಬ್ ಅಧಿಸೂಚನೆಗಳು ಆಟೋ-ಸಿಂಕ್ ಆಗಿ ನಿಮ್ಮ ಆ್ಯಪ್‌ನಲ್ಲಿ ಬರುತ್ತವೆ."
                    else "Enter any job website URL. New job notices will automatically sync every 45s into your app.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF059669))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = if (isKannada) "⚡ 45s ಆಟೋ-ಸಿಂಕ್ ಆಕ್ಟಿವ್" else "⚡ 45s Auto-Sync Active",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isKannada) "ಅಸ್ತಿತ್ವದಲ್ಲಿರುವ 9 ಪೋರ್ಟಲ್‌ಗಳು ಸುರಕ್ಷಿತವಾಗಿವೆ" else "9 existing portals remain intact",
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Input Box for Website URL
        Text(
            text = if (isKannada) "ವೆಬ್‌ಸೈಟ್ ಲಿಂಕ್ (URL):" else "Website URL:",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = websiteUrlInput,
                onValueChange = onWebsiteUrlChange,
                placeholder = {
                    Text(
                        text = "ಉದಾ: https://karnatakacareers.in",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.outline
                    )
                },
                modifier = Modifier
                    .weight(1f)
                    .testTag("custom_website_url_input"),
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { onAddWebsite(websiteUrlInput) },
                enabled = websiteUrlInput.isNotBlank(),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.testTag("add_custom_website_button")
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = if (isKannada) "ಸೇರಿಸಿ" else "Add", fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // List of added websites
        Text(
            text = if (isKannada) "ನೀವು ಸೇರಿಸಿರುವ ವೆಬ್‌ಸೈಟ್‌ಗಳು (${customWebsites.size}):" else "Added Websites (${customWebsites.size}):",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (customWebsites.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.Language,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.size(36.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (isKannada) "ಇನ್ನೂ ಯಾವುದೇ ಕಸ್ಟಮ್ ವೆಬ್‌ಸೈಟ್ ಸೇರಿಸಿಲ್ಲ.\nಮೇಲಿನ ಬಾಕ್ಸ್‌ನಲ್ಲಿ ಲಿಂಕ್ ಹಾಕಿ ಸೇರಿಸಿ."
                        else "No custom websites added yet.\nEnter a URL above to add.",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.outline,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(customWebsites, key = { it.id }) { site ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("custom_website_item_${site.id}"),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = site.name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                                Text(
                                    text = site.url,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.primary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Sync,
                                        contentDescription = null,
                                        tint = Color(0xFF059669),
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = if (isKannada) "ಪ್ರತಿ 45s ಆಟೋ-ಸಿಂಕ್ ಸಕ್ರಿಯ" else "Auto-syncs every 45s",
                                        fontSize = 10.sp,
                                        color = Color(0xFF059669)
                                    )
                                }
                            }

                            IconButton(
                                onClick = { onDeleteWebsite(site.id) },
                                modifier = Modifier.size(32.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = MaterialTheme.colorScheme.error,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Option 2: Custom YouTube Channels Box and Video Sync List
 */
@Composable
private fun OptionYouTubeTab(
    channelUrlInput: String,
    onChannelUrlChange: (String) -> Unit,
    customChannels: List<CustomYouTubeChannel>,
    onAddChannel: (String) -> Unit,
    onDeleteChannel: (String) -> Unit,
    isKannada: Boolean
) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Title & Description Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFDC2626).copy(alpha = 0.08f)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Tv,
                        contentDescription = null,
                        tint = Color(0xFFDC2626),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isKannada) "ಆಯ್ಕೆ 2: ಕಸ್ಟಮ್ ಯೂಟ್ಯೂಬ್ ಚಾನೆಲ್ ಲಿಂಕ್ ಹಾಕಿ" else "Option 2: Add Custom YouTube Channels",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = if (isKannada) "ಯಾವುದೇ ಯೂಟ್ಯೂಬ್ ಚಾನೆಲ್‌ನ URL/ಲಿಂಕ್ ಹಾಕಿ. ಉದ್ಯೋಗ ವೀಡಿಯೋಗಳ ಮೆನುವಿನಲ್ಲಿ ಚಾನೆಲ್ ಬದಲಿಗೆ ಆ ಚಾನೆಲ್‌ನ ವೀಡಿಯೋಗಳು ಕಾಣಿಸುತ್ತವೆ ಮತ್ತು ಪ್ರತಿ 45 ಸೆಕೆಂಡಿಗೆ ಆಟೋ-ಸಿಂಕ್ ಆಗುತ್ತವೆ."
                    else "Enter any YouTube channel URL. Career videos from this channel will appear in the videos menu and auto-sync every 45s.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFFDC2626))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = if (isKannada) "⚡ 45s ವೀಡಿಯೋ ಆಟೋ-ಸಿಂಕ್" else "⚡ 45s Video Auto-Sync",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isKannada) "ಅಸ್ತಿತ್ವದಲ್ಲಿರುವ 6 ಚಾನೆಲ್ ವೀಡಿಯೋಗಳು ಸುರಕ್ಷಿತವಾಗಿವೆ" else "6 existing channels remain intact",
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Input Box for YouTube Channel URL
        Text(
            text = if (isKannada) "ಯೂಟ್ಯೂಬ್ ಚಾನೆಲ್ ಲಿಂಕ್ (URL):" else "YouTube Channel URL:",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = channelUrlInput,
                onValueChange = onChannelUrlChange,
                placeholder = {
                    Text(
                        text = "ಉದಾ: https://youtube.com/@channelName",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.outline
                    )
                },
                modifier = Modifier
                    .weight(1f)
                    .testTag("custom_channel_url_input"),
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFDC2626),
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { onAddChannel(channelUrlInput) },
                enabled = channelUrlInput.isNotBlank(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDC2626)
                ),
                modifier = Modifier.testTag("add_custom_channel_button")
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = if (isKannada) "ಸೇರಿಸಿ" else "Add", fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // List of added channels
        Text(
            text = if (isKannada) "ನೀವು ಸೇರಿಸಿರುವ ಯೂಟ್ಯೂಬ್ ಚಾನೆಲ್‌ಗಳು (${customChannels.size}):" else "Added YouTube Channels (${customChannels.size}):",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (customChannels.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.Tv,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.size(36.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (isKannada) "ಇನ್ನೂ ಯಾವುದೇ ಕಸ್ಟಮ್ ಯೂಟ್ಯೂಬ್ ಚಾನೆಲ್ ಸೇರಿಸಿಲ್ಲ.\nಮೇಲಿನ ಬಾಕ್ಸ್‌ನಲ್ಲಿ ಲಿಂಕ್ ಹಾಕಿ ಸೇರಿಸಿ."
                        else "No custom channels added yet.\nEnter a channel link above.",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.outline,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(customChannels, key = { it.id }) { channel ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("custom_channel_item_${channel.id}"),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = channel.channelName,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                                Text(
                                    text = channel.channelUrl,
                                    fontSize = 11.sp,
                                    color = Color(0xFFDC2626),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.PlayCircle,
                                        contentDescription = null,
                                        tint = Color(0xFF059669),
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = if (isKannada) "ವೀಡಿಯೋಗಳು ಉದ್ಯೋಗ ಮೆನುವಿನಲ್ಲಿ ಲೈವ್ ಆಗಿವೆ (45s ಸಿಂಕ್)" else "Videos live in menu (45s sync)",
                                        fontSize = 10.sp,
                                        color = Color(0xFF059669)
                                    )
                                }
                            }

                            IconButton(
                                onClick = { onDeleteChannel(channel.id) },
                                modifier = Modifier.size(32.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = MaterialTheme.colorScheme.error,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Tab 3: Unity Ads Configuration
 */
@Composable
private fun UnityAdsTab(
    gameId: String,
    onGameIdChange: (String) -> Unit,
    bannerId: String,
    onBannerIdChange: (String) -> Unit,
    interstitialId: String,
    onInterstitialIdChange: (String) -> Unit,
    rewardedId: String,
    onRewardedIdChange: (String) -> Unit,
    testMode: Boolean,
    onTestModeChange: (Boolean) -> Unit,
    onSave: () -> Unit,
    isKannada: Boolean
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = if (isKannada) "Unity Ads ನೈಜ ಐಡಿಗಳು & ಟೆಸ್ಟ್ ಮೋಡ್" else "Unity Ads Real IDs & Test Mode",
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
        )
        Text(
            text = if (isKannada) "ನಿಮ್ಮ Unity Dashboard ನಿಂದ ಪಡೆದ Game ID ಹಾಗೂ Placement ID ಗಳನ್ನು ಇಲ್ಲಿ ನಮೂದಿಸಿ."
            else "Enter your Game ID and Placement IDs from Unity Dashboard.",
            fontSize = 11.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = gameId,
            onValueChange = onGameIdChange,
            label = { Text("Game ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = bannerId,
            onValueChange = onBannerIdChange,
            label = { Text("Banner Placement ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = interstitialId,
            onValueChange = onInterstitialIdChange,
            label = { Text("Interstitial Placement ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = rewardedId,
            onValueChange = onRewardedIdChange,
            label = { Text("Rewarded Placement ID") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = if (isKannada) "ಟೆಸ್ಟ್ ಮೋಡ್ (Test Mode)" else "Test Mode",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp
                )
                Text(
                    text = if (isKannada) "ಆ್ಯಪ್ ಲೈವ್ ಆಗುವ ಮೊದಲು ಪರಿಶೀಲನೆಗೆ" else "For verification before release",
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.outline
                )
            }
            Switch(
                checked = testMode,
                onCheckedChange = onTestModeChange
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onSave,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("save_unity_ads_config_button"),
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = if (isKannada) "ಉಳಿಸಿ (Save Settings)" else "Save Settings")
        }
    }
}
