package com.example.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ads.UnityBannerAd
import com.example.model.LegalPolicyPage
import com.example.model.UnityAdConfig

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LegalPolicyScreen(
    initialPage: LegalPolicyPage = LegalPolicyPage.PRIVACY_POLICY,
    isKannada: Boolean,
    onToggleLanguage: () -> Unit,
    adConfig: UnityAdConfig,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var currentPage by remember { mutableStateOf(initialPage) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = if (isKannada) currentPage.titleKannada else currentPage.titleEnglish,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                        Text(
                            text = if (isKannada) "Free Jobs ಅಧಿಕೃತ ನಿಯಮಗಳು" else "Free Jobs Official Policies",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("policy_back_button")) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    // Language Switch Button
                    IconButton(onClick = onToggleLanguage) {
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

                    // Share button
                    IconButton(onClick = {
                        val shareText = "Free Jobs Policy & Info:\nhttps://karnataka.gov.in"
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, shareText)
                        }
                        context.startActivity(Intent.createChooser(intent, "Share Policy"))
                    }) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            UnityBannerAd(
                placementId = "Banner_Legal_Bottom",
                config = adConfig,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Horizontal page selector chips (4 Pages requested: Privacy, Terms, Contact, Disclaimer)
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(LegalPolicyPage.values()) { page ->
                    FilterChip(
                        selected = currentPage == page,
                        onClick = { currentPage = page },
                        label = {
                            Text(
                                text = if (isKannada) page.titleKannada else page.titleEnglish,
                                fontSize = 12.sp,
                                fontWeight = if (currentPage == page) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        leadingIcon = {
                            val icon = when (page) {
                                LegalPolicyPage.PRIVACY_POLICY -> Icons.Default.Security
                                LegalPolicyPage.TERMS_CONDITIONS -> Icons.Default.Gavel
                                LegalPolicyPage.CONTACT_US -> Icons.Default.Phone
                                LegalPolicyPage.DISCLAIMER -> Icons.Default.Warning
                            }
                            Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(16.dp))
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.primary
                        )
                    )
                }
            }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(top = 8.dp, bottom = 24.dp)
            ) {
                when (currentPage) {
                    LegalPolicyPage.PRIVACY_POLICY -> {
                        item { PrivacyPolicyArticle(isKannada = isKannada) }
                    }
                    LegalPolicyPage.TERMS_CONDITIONS -> {
                        item { TermsAndConditionsArticle(isKannada = isKannada) }
                    }
                    LegalPolicyPage.CONTACT_US -> {
                        item { ContactUsArticle(isKannada = isKannada, context = context) }
                    }
                    LegalPolicyPage.DISCLAIMER -> {
                        item { DisclaimerArticle(isKannada = isKannada) }
                    }
                }
            }
        }
    }
}

@Composable
private fun PrivacyPolicyArticle(isKannada: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        ArticleHeaderCard(
            title = if (isKannada) "ಗೌಪ್ಯತಾ ನೀತಿ (Privacy Policy)" else "Privacy Policy",
            subtitle = if (isKannada) "ಕೊನೆಯ ನವೀಕರಣ: ಸೆಪ್ಟೆಂಬರ್ 2026 | ಗೂಗಲ್ ಪ್ಲೇ ಕಾಂಪ್ಲೈಯನ್ಸ್" else "Last Updated: September 2026 | Google Play Compliance",
            icon = Icons.Default.Security,
            iconTint = Color(0xFF047857),
            containerColor = Color(0xFFECFDF5)
        )

        SectionBlock(
            title = if (isKannada) "1. ಪರಿಚಯ & ಬದ್ಧತೆ (Introduction)" else "1. Introduction & Commitment",
            body = if (isKannada) {
                "ನಮ್ಮ 'Free Jobs' ಮೊಬೈಲ್ ಅಪ್ಲಿಕೇಶನ್‌ಗೆ ಸ್ವಾಗತ. ಕರ್ನಾಟಕದ ಹಾಗೂ ಇಡೀ ಭಾರತದ ಉದ್ಯೋಗಾಕಾಂಕ್ಷಿ ಯುವಜನತೆಗೆ ಪಾರದರ್ಶಕ, ನಿಖರ ಹಾಗೂ ಉಚಿತ ಉದ್ಯೋಗ ಮಾಹಿತಿಯನ್ನು ತಲುಪಿಸುವುದು ನಮ್ಮ ಪ್ರಮುಖ ಧ್ಯೇಯವಾಗಿದೆ. ಬಳಕೆದಾರರ ವೈಯಕ್ತಿಕ ಗೌಪ್ಯತೆಯನ್ನು ಕಾಪಾಡುವುದು ನಮ್ಮ ಪ್ರಮುಖ ಕರ್ತವ್ಯವಾಗಿದೆ. ಈ ಗೌಪ್ಯತಾ ನೀತಿಯು ನಮ್ಮ ಆ್ಯಪ್ ಬಳಸುವಾಗ ನಿಮ್ಮ ಮಾಹಿತಿಯನ್ನು ಹೇಗೆ ನಿರ್ವಹಿಸಲಾಗುತ್ತದೆ ಎಂಬುದನ್ನು ಸ್ಪಷ್ಟಪಡಿಸುತ್ತದೆ."
            } else {
                "Welcome to Free Jobs. Our core mission is delivering transparent, verified, and 100% free career notifications to job aspirants across Karnataka and India. We respect your privacy and are committed to safeguarding user data in strict adherence with Google Play Developer Policies and global privacy regulations."
            }
        )

        SectionBlock(
            title = if (isKannada) "2. ಯಾವುದೇ ವೈಯಕ್ತಿಕ ಮಾಹಿತಿ ಸಂಗ್ರಹವಿಲ್ಲ (Zero Personal Data Collection)" else "2. Zero Personal Data Collection",
            body = if (isKannada) {
                "• ನಮ್ಮ ಆ್ಯಪ್ ಯಾವುದೇ ರೀತಿಯ ವೈಯಕ್ತಿಕ ಲಾಗಿನ್, ನೋಂದಣಿ ಅಥವಾ ಪಾಸ್‌ವರ್ಡ್ ಕೇಳುವುದಿಲ್ಲ.\n" +
                "• ನಿಮ್ಮ ಹೆಸರು, ಮೊಬೈಲ್ ಸಂಖ್ಯೆ, ಇಮೇಲ್ ವಿಳಾಸ, ಜಿಪಿಎಸ್ ಲೊಕೇಶನ್ ಅಥವಾ ಫೋಟೋ ಗ್ಯಾಲರಿಯನ್ನು ನಾವು ಯಾವುದೇ ಕಾರಣಕ್ಕೂ ಸಂಗ್ರಹಿಸುವುದಿಲ್ಲ ಅಥವಾ ಸರ್ವರ್‌ಗೆ ಕಳುಹಿಸುವುದಿಲ್ಲ.\n" +
                "• ಯಾವುದೇ ಅನಗತ್ಯ ಪರ್ಮಿಷನ್‌ಗಳಿಲ್ಲದೆ (Zero Dangerous Permissions) ಆ್ಯಪ್ ಸುರಕ್ಷಿತವಾಗಿ ರನ್ ಆಗುತ್ತದೆ."
            } else {
                "• Free Jobs does not require account creation, login, or personal profile registration.\n" +
                "• We never collect or harvest personal names, phone numbers, email addresses, contact lists, GPS location, or device media.\n" +
                "• The application requires zero intrusive permissions to function."
            }
        )

        SectionBlock(
            title = if (isKannada) "3. ಜಾಹೀರಾತು ನೀತಿ (Unity Ads Integration)" else "3. Unity Ads Integration & Advertising Policy",
            body = if (isKannada) {
                "ಆ್ಯಪ್‌ನ ಸರ್ವರ್ ವೆಚ್ಚ ಹಾಗೂ ಉಚಿತ ನಿರ್ವಹಣೆಗಾಗಿ Unity Ads ಪ್ಲಾಟ್‌ಫಾರ್ಮ್ ಅನ್ನು ಅಳವಡಿಸಲಾಗಿದೆ. Unity Ads ಕೇವಲ ಅನಾಮಧೇಯ ಡಿವೈಸ್ ಐಡಿ (Advertising ID) ಆಧಾರಿತ ಸುರಕ್ಷಿತ ಜಾಹೀರಾತುಗಳನ್ನು ಮಾತ್ರ ನೀಡುತ್ತದೆ. ಯಾವುದೇ ಕಿರಿಕಿರಿಯುಂಟುಮಾಡುವ ಪಾಪ್-ಅಪ್ ಅಥವಾ ಮಾಲ್‌ವೇರ್ ಲಿಂಕ್‌ಗಳು ಇರುವುದಿಲ್ಲ. ಬಳಕೆದಾರರು ತಮ್ಮ ಇಚ್ಛೆಯಂತೆ ಜಾಹೀರಾತುಗಳನ್ನು ವೀಕ್ಷಿಸಬಹುದು."
            } else {
                "To sustain operating and server hosting costs while keeping the app completely free for candidates, we integrate the certified Unity Ads SDK. Unity Ads serves non-intrusive banner and video placements in full compliance with Google Play Families & Advertising policies. No personal tracking data is shared."
            }
        )

        SectionBlock(
            title = if (isKannada) "4. ಯೂಟ್ಯೂಬ್ ಹಾಗೂ ಮೂರನೇ ವ್ಯಕ್ತಿ ಲಿಂಕ್‌ಗಳು (YouTube & External Links)" else "4. Embedded YouTube & External Recruitment Links",
            body = if (isKannada) {
                "• ಉದ್ಯೋಗ ವೀಡಿಯೋಗಳು ಅಧಿಕೃತ ಯೂಟ್ಯೂಬ್ ಎಜುಕೇಶನ್ ಚಾನೆಲ್‌ಗಳಿಂದ ಆ್ಯಪ್‌ನಲ್ಲೇ ಎಂಬೆಡ್ ಆಗಿ ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತವೆ.\n" +
                "• ಅಧಿಕೃತ ಅರ್ಜಿ (Apply Online) ಮತ್ತು ನೋಟಿಫಿಕೇಶನ್ ಪಿಡಿಎಫ್ ಲಿಂಕ್‌ಗಳು ನೇರವಾಗಿ ಸರಕಾರಿ ಪೋರ್ಟಲ್‌ಗಳಿಗೆ (KPSC, KEA, SSC, ಇತ್ಯಾದಿ) ಕರೆದೊಯ್ಯುತ್ತವೆ. ಆ ವೆಬ್‌ಸೈಟ್‌ಗಳ ನಿಯಮಗಳಿಗೆ ಆಯಾ ಸಂಸ್ಥೆಗಳೇ ಜವಾಬ್ದಾರರಾಗಿರುತ್ತವೆ."
            } else {
                "• Career videos are streamed directly via official educational channel embeds using standard YouTube web playback.\n" +
                "• Direct links to Official Notification PDFs and Apply Online forms redirect users to authorized government recruiting authority websites (KPSC, KEA, SSC, RRB)."
            }
        )

        SectionBlock(
            title = if (isKannada) "5. ಮಕ್ಕಳ ಗೌಪ್ಯತೆ (Children's Privacy)" else "5. Children's Privacy (COPPA Compliance)",
            body = if (isKannada) {
                "ಈ ಆ್ಯಪ್ ಸ್ಪರ್ಧಾತ್ಮಕ ಪರೀಕ್ಷೆ ಮತ್ತು ಉದ್ಯೋಗಗಳಿಗೆ ಸಂಬಂಧಿಸಿದ್ದಾಗಿದ್ದು, 13 ವರ್ಷಕ್ಕಿಂತ ಮೇಲ್ಪಟ್ಟ ಮತ್ತು ವಯಸ್ಕ ಅಭ್ಯರ್ಥಿಗಳಿಗಾಗಿ ಮಾತ್ರ ರೂಪಿಸಲಾಗಿದೆ."
            } else {
                "Free Jobs is specifically geared toward competitive examinations and employment notices intended for candidates aged 13 and above."
            }
        )
    }
}

@Composable
private fun TermsAndConditionsArticle(isKannada: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        ArticleHeaderCard(
            title = if (isKannada) "ನಿಯಮಗಳು & ಷರತ್ತುಗಳು (Terms & Conditions)" else "Terms & Conditions",
            subtitle = if (isKannada) "ಸೇವಾ ನಿಯಮಾವಳಿಗಳು ಮತ್ತು ಬಳಕೆದಾರರ ಮಾರ್ಗಸೂಚಿಗಳು" else "Service Agreement & User Guidelines",
            icon = Icons.Default.Gavel,
            iconTint = Color(0xFF1D4ED8),
            containerColor = Color(0xFFEFF6FF)
        )

        SectionBlock(
            title = if (isKannada) "1. ನಿಯಮಗಳ ಅಂಗೀಕಾರ (Acceptance of Terms)" else "1. Acceptance of Terms",
            body = if (isKannada) {
                "Free Jobs ಅಪ್ಲಿಕೇಶನ್ ಅನ್ನು ಡೌನ್‌ಲೋಡ್ ಮಾಡುವ ಮೂಲಕ ಮತ್ತು ಬಳಸುವ ಮೂಲಕ, ನೀವು ಈ ಕೆಳಗಿನ ನಿಯಮ ಮತ್ತು ಷರತ್ತುಗಳನ್ನು ಸಂಪೂರ್ಣವಾಗಿ ಓದಿ ಒಪ್ಪಿಕೊಂಡಿದ್ದೀರಿ ಎಂದು ಪರಿಗಣಿಸಲಾಗುತ್ತದೆ. ಈ ನಿಯಮಗಳನ್ನು ಒಪ್ಪದಿದ್ದಲ್ಲಿ, ದಯವಿಟ್ಟು ಆ್ಯಪ್ ಬಳಸುವುದನ್ನು ನಿಲ್ಲಿಸಿ."
            } else {
                "By installing, downloading, or browsing the Free Jobs mobile app, you confirm your acceptance of these Terms and Conditions. If you do not agree, please discontinue using the application immediately."
            }
        )

        SectionBlock(
            title = if (isKannada) "2. ಉಚಿತ ಮಾಹಿತಿ ಸೇವೆ (Free Informational Service)" else "2. Non-Commercial Public Information Service",
            body = if (isKannada) {
                "Free Jobs ಆಪ್‌ನಲ್ಲಿ ನೀಡಲಾಗುವ ಎಲ್ಲಾ ಉದ್ಯೋಗ ಮಾಹಿತಿ, ಪರೀಕ್ಷಾ ಸಿಲಬಸ್, ಪ್ರವೇಶ ಪತ್ರ ಮತ್ತು ಫಲಿತಾಂಶಗಳ ಅಪ್‌ಡೇಟ್‌ಗಳು ಉಚಿತ ಮಾಹಿತಿ ಉದ್ದೇಶಕ್ಕಾಗಿ ಮಾತ್ರ ಲಭ್ಯವಿರುತ್ತವೆ. ಯಾವುದೇ ಉದ್ಯೋಗ ಗ್ಯಾರಂಟಿ ಅಥವಾ ನೇಮಕಾತಿ ಭರವಸೆಯನ್ನು ನಾವು ನೀಡುವುದಿಲ್ಲ."
            } else {
                "All job vacancy alerts, exam syllabi, hall tickets, and results aggregated in this application are distributed purely for public educational and informational guidance. We do not provide job placement guarantees or recruitment assurances."
            }
        )

        SectionBlock(
            title = if (isKannada) "3. ಬೌದ್ಧಿಕ ಆಸ್ತಿ ಹಕ್ಕುಗಳು (Intellectual Property)" else "3. Intellectual Property Rights",
            body = if (isKannada) {
                "• ಸರಕಾರಿ ನೇಮಕಾತಿ ಅಧಿಸೂಚನೆಗಳು, ಲಾಂಛನಗಳು ಮತ್ತು ಇಲಾಖಾ ಆದೇಶಗಳು ಸಂಬಂಧಪಟ್ಟ ಆಯಾ ಸರಕಾರಿ ಪ್ರಾಧಿಕಾರಗಳಿಗೆ ಸೇರಿರುತ್ತವೆ.\n" +
                "• ಈ ಆ್ಯಪ್‌ನ ವಿನ್ಯಾಸ, ಕೋಡಿಂಗ್, ಲೇಔಟ್ ಮತ್ತು ಪ್ರಸ್ತುತಿ ಶೈಲಿಯು Free Jobs ತಂಡದ ಸ್ವತ್ತಾಗಿದೆ.\n" +
                "• ಯಾವುದೇ ವಾಣಿಜ್ಯ ಉದ್ದೇಶಕ್ಕಾಗಿ ಆ್ಯಪ್ ಡೇಟಾವನ್ನು ಸ್ಕ್ರಾಪಿಂಗ್ ಮಾಡುವುದು ಅಥವಾ ಮರುಮಾರಾಟ ಮಾಡುವುದು ಕಟ್ಟುನಿಟ್ಟಾಗಿ ನಿಷೇಧಿಸಲಾಗಿದೆ."
            } else {
                "• All gazettes, official logos, and notification PDFs belong exclusively to their respective government recruiting boards.\n" +
                "• Application architecture, user interface elements, and custom curated summaries are the intellectual property of Free Jobs.\n" +
                "• Automated scraping or reselling of this compiled database is strictly prohibited."
            }
        )

        SectionBlock(
            title = if (isKannada) "4. ಬಳಕೆದಾರರ ಜವಾಬ್ದಾರಿ (User Responsibility & Due Diligence)" else "4. User Due Diligence & Responsibility",
            body = if (isKannada) {
                "ಯಾವುದೇ ಉದ್ಯೋಗಕ್ಕೆ ಅರ್ಜಿ ಸಲ್ಲಿಸುವ ಮುನ್ನ ಅಧಿಕೃತ ಗೆಜೆಟ್ ನೋಟಿಫಿಕೇಶನ್ ಅನ್ನು ಮೂಲ ವೆಬ್‌ಸೈಟ್‌ನಲ್ಲಿ ಪರಿಶೀಲಿಸುವುದು ಅಭ್ಯರ್ಥಿಯ ಕರ್ತವ್ಯವಾಗಿದೆ. ಅರ್ಹತೆ, ವಯೋಮಿತಿ, ಮೀಸಲಾತಿ ಹಾಗೂ ಕೊನೆಯ ದಿನಾಂಕಗಳ ಬದಲಾವಣೆಗಳಿಗೆ ಆಯಾ ಇಲಾಖಾ ಅಧಿಸೂಚನೆಯೇ ಅಂತಿಮ ತೀರ್ಪಾಗಿರುತ್ತದೆ."
            } else {
                "Candidates are strictly advised to review the official recruitment gazette on the governing portal prior to submitting application fees. Any changes in eligibility, age limits, category reservations, or deadline extensions are determined solely by the respective issuing department."
            }
        )
    }
}

@Composable
private fun ContactUsArticle(isKannada: Boolean, context: Context) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        ArticleHeaderCard(
            title = if (isKannada) "ಸಂಪರ್ಕಿಸಿ & ಸಹಾಯವಾಣಿ (Contact Us)" else "Contact Us & Helpdesk",
            subtitle = if (isKannada) "ನಿಮ್ಮ ಸಲಹೆ, ಪ್ರಶ್ನೆಗಳು ಮತ್ತು ಮಾರ್ಗದರ್ಶನಕ್ಕಾಗಿ ಸಂಪರ್ಕಿಸಿ" else "Support, Queries & Editorial Feedback",
            icon = Icons.Default.Phone,
            iconTint = Color(0xFF0D9488),
            containerColor = Color(0xFFCCFBF1)
        )

        // Support Details Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                Text(
                    text = if (isKannada) "ಅಧಿಕೃತ ಸಂಪರ್ಕ ವಿವರಗಳು (Direct Channels)" else "Official Contact Channels",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                // Email Row
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(imageVector = Icons.Default.Email, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "ಇಮೇಲ್ ಸಹಾಯವಾಣಿ (Email Support)", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.outline)
                        Text(text = "support.freejobs.karnataka@gmail.com", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                    }
                }

                // Hours Row
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFEF3C7)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(imageVector = Icons.Default.HelpOutline, contentDescription = null, tint = Color(0xFFD97706))
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "ಕಾರ್ಯನಿರ್ವಹಣಾ ಸಮಯ (Operating Hours)", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.outline)
                        Text(text = "ಸೋಮವಾರ – ಶನಿವಾರ: ಬೆಳಗ್ಗೆ 9:00 ರಿಂದ ಸಂಜೆ 6:00", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                    }
                }

                // Send Email Button
                Button(
                    onClick = {
                        try {
                            val intent = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mailto:support.freejobs.karnataka@gmail.com")
                                putExtra(Intent.EXTRA_SUBJECT, "Free Jobs App Query / Feedback")
                            }
                            context.startActivity(intent)
                        } catch (_: Exception) {
                            Toast.makeText(context, "Email app not found", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isKannada) "ನಮಗೆ ನೇರವಾಗಿ ಇಮೇಲ್ ಕಳುಹಿಸಿ" else "Send Us Direct Email",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        SectionBlock(
            title = if (isKannada) "ಸಹಾಯವಾಣಿ ಮಾರ್ಗದರ್ಶನ (Editorial Guidelines)" else "Candidate Advisory Support",
            body = if (isKannada) {
                "• ಯಾವುದೇ ಉದ್ಯೋಗ ಅಧಿಸೂಚನೆಯಲ್ಲಿ ತಪ್ಪು ಮಾಹಿತಿ ಅಥವಾ ಲಿಂಕ್ ದೋಷ ಕಂಡುಬಂದಲ್ಲಿ ನಮಗೆ ತಕ್ಷಣ ಇಮೇಲ್ ಮೂಲಕ ತಿಳಿಸಬಹುದು.\n" +
                "• ಸರಕಾರಿ ಪರೀಕ್ಷೆಗಳ ಅರ್ಜಿ ಸಲ್ಲಿಕೆ, ಚಲನ್ ಪಾವತಿ ಮತ್ತು ಹಾಲ್ ಟಿಕೆಟ್ ಡೌನ್‌ಲೋಡ್ ಸಮಸ್ಯೆಗಳಿಗೆ ಸಂಬಂಧಪಟ್ಟ ಇಲಾಖೆಯ ಅಧಿಕೃತ ಹೆಲ್ಪ್‌ಲೈನ್ ನಂಬರ್‌ಗಳನ್ನು ಆಯಾ ಜಾಬ್ ಆರ್ಟಿಕಲ್‌ನಲ್ಲಿ ಒದಗಿಸಲಾಗಿರುತ್ತದೆ.\n" +
                "• ವಿದ್ಯಾರ್ಥಿಗಳ ಪ್ರಶ್ನೆಗಳಿಗೆ ನಮ್ಮ ತಾಂತ್ರಿಕ ತಂಡ 24 ಗಂಟೆಯೊಳಗೆ ಪ್ರತಿಕ್ರಿಯಿಸುತ್ತದೆ."
            } else {
                "• If you encounter any broken link or editorial discrepancy, report it directly via our support email for immediate correction.\n" +
                "• Department-specific examination grievances (e.g. KPSC payment verification or KEA hall ticket corrections) must be submitted to the official departmental helpline numbers listed inside each job notice.\n" +
                "• Our support desk responds to candidate queries within 24 business hours."
            }
        )
    }
}

@Composable
private fun DisclaimerArticle(isKannada: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        ArticleHeaderCard(
            title = if (isKannada) "ಹಕ್ಕು ನಿರಾಕರಣೆ (Disclaimer)" else "Legal Disclaimer",
            subtitle = if (isKannada) "ಸರಕಾರೇತರ ಸ್ವತಂತ್ರ ಸಂಸ್ಥೆ ಪ್ರಕಟಣೆ | ಕಡ್ಡಾಯ ಘೋಷಣೆ" else "Non-Governmental Entity Declaration | Mandatory Disclosure",
            icon = Icons.Default.Warning,
            iconTint = Color(0xFFDC2626),
            containerColor = Color(0xFFFEE2E2)
        )

        SectionBlock(
            title = if (isKannada) "1. ಸರಕಾರೇತರ ಸ್ವತಂತ್ರ ವೇದಿಕೆ (Non-Government Entity Declaration)" else "1. Non-Government Entity Declaration",
            body = if (isKannada) {
                "• 'Free Jobs' ಮೊಬೈಲ್ ಅಪ್ಲಿಕೇಶನ್ ಯಾವುದೇ ಸರಕಾರಿ ಇಲಾಖೆ, ಕರ್ನಾಟಕ ಸರಕಾರ ಅಥವಾ ಭಾರತ ಸರಕಾರದ ಅಧಿಕೃತ ಅಪ್ಲಿಕೇಶನ್ ಅಲ್ಲ.\n" +
                "• ಈ ಅಪ್ಲಿಕೇಶನ್ ಯಾವುದೇ ಸರಕಾರಿ ಪ್ರಾಧಿಕಾರದೊಂದಿಗೆ ನೇರ ಅಧಿಕೃತ ಸಂಬಂಧವನ್ನು ಹೊಂದಿಲ್ಲ.\n" +
                "• ಇದು ಸಂಪೂರ್ಣವಾಗಿ ಸಾರ್ವಜನಿಕ ಉದ್ಯೋಗಾಕಾಂಕ್ಷಿಗಳಿಗೆ ಮಾಹಿತಿ ಸಂಗ್ರಹಿಸಿ ನೀಡುವ ಸ್ವತಂತ್ರ ಜನಕಲ್ಯಾಣ ಮಾಹಿತಿ ಸೇವೆಯಾಗಿದೆ."
            } else {
                "• Free Jobs is NOT an official application of any government agency, the Government of Karnataka, or the Government of India.\n" +
                "• Free Jobs is NOT affiliated with, sponsored by, or endorsed by any governmental authority.\n" +
                "• This is an independent public-interest career information curation platform designed solely to aid students and job seekers."
            }
        )

        SectionBlock(
            title = if (isKannada) "2. ಉದ್ಯೋಗ ಮಾಹಿತಿ ಸಂಗ್ರಹ ಮೂಲಗಳು (Private Job Portals & Media)" else "2. Career News Aggregation Sources",
            body = if (isKannada) {
                "ನಮ್ಮ ಆ್ಯಪ್‌ನಲ್ಲಿ ಪ್ರಕಟವಾಗುವ ಮಾಹಿತಿಗಳು ಪ್ರಮುಖ ಖಾಸಗಿ ಉದ್ಯೋಗ ಪೋರ್ಟಲ್‌ಗಳು, ವೃತ್ತಿಪರ ಜಾಬ್ ನ್ಯೂಸ್ ಪ್ಲಾಟ್‌ಫಾರ್ಮ್‌ಗಳು ಮತ್ತು ಮಾಧ್ಯಮ ಪ್ರಕಟಣೆಗಳಿಂದ ಸಂಗ್ರಹಿಸಲಾಗಿರುತ್ತದೆ:\n\n" +
                "• FreeJobAlert: https://www.freejobalert.com\n" +
                "• KarnatakaJobs.in: https://karnatakajobs.in\n" +
                "• Freshersworld: https://www.freshersworld.com\n" +
                "• Naukri.com: https://www.naukri.com\n" +
                "• Shine.com: https://www.shine.com\n" +
                "• Indeed India: https://in.indeed.com\n" +
                "• SarkariResult: https://www.sarkariresult.com\n" +
                "• Foundit: https://www.foundit.in\n" +
                "• Apna App: https://apna.co\n\n" +
                "ಉದ್ಯೋಗಾಕಾಂಕ್ಷಿಗಳ ಅನುಕೂಲಕ್ಕಾಗಿ ಈ ಖಾಸಗಿ ವೇದಿಕೆಗಳಲ್ಲಿ ಬಿಡುಗಡೆಯಾಗುವ ದೈನಂದಿನ ಅಧಿಸೂಚನೆಗಳನ್ನು ನೇರವಾಗಿ ಒದಗಿಸಲಾಗಿದೆ."
            } else {
                "Career notifications summarized on this application are curated from leading private employment portals and job news platforms:\n\n" +
                "• FreeJobAlert: https://www.freejobalert.com\n" +
                "• KarnatakaJobs.in: https://karnatakajobs.in\n" +
                "• Freshersworld: https://www.freshersworld.com\n" +
                "• Naukri.com: https://www.naukri.com\n" +
                "• Shine.com: https://www.shine.com\n" +
                "• Indeed India: https://in.indeed.com\n" +
                "• SarkariResult: https://www.sarkariresult.com\n" +
                "• Foundit: https://www.foundit.in\n" +
                "• Apna App: https://apna.co\n\n" +
                "Our service aggregates job updates to assist job seekers with timely private career openings."
            }
        )

        SectionBlock(
            title = if (isKannada) "3. ಆರ್ಥಿಕ ಎಚ್ಚರಿಕೆ (Financial Advisory & Safety)" else "3. Financial Advisory & Fraud Prevention",
            body = if (isKannada) {
                "• Free Jobs ಅಪ್ಲಿಕೇಶನ್ ಯಾವುದೇ ಉದ್ಯೋಗ ನೀಡಲು ಹಣ ಅಥವಾ ಲಂಚವನ್ನು ಕೇಳುವುದಿಲ್ಲ.\n" +
                "• ಸರಕಾರಿ ಪರೀಕ್ಷೆಗಳ ಅರ್ಜಿ ಶುಲ್ಕವನ್ನು ಕೇವಲ ಅಧಿಕೃತ ಸರಕಾರಿ ಪೋರ್ಟಲ್‌ನಲ್ಲಿ ಮಾತ್ರ ಪಾವತಿಸಬೇಕು.\n" +
                "• ಯಾವುದೇ ನಕಲಿ ಏಜೆಂಟರು ಅಥವಾ ಮಧ್ಯವರ್ತಿಗಳ ಮಾತುಗಳನ್ನು ನಂಬಿ ಮೋಸಹೋಗದಂತೆ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ ಕಟ್ಟುನಿಟ್ಟಾಗಿ ಎಚ್ಚರಿಸಲಾಗಿದೆ."
            } else {
                "• Free Jobs NEVER solicits registration fees, deposits, or processing fees for jobs.\n" +
                "• All statutory examination fees must be deposited strictly through authorized government payment gateways.\n" +
                "• Candidates are cautioned against fraudulent claims by unverified job agents or third parties."
            }
        )
    }
}

@Composable
private fun ArticleHeaderCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    iconTint: Color,
    containerColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(iconTint.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconTint,
                    modifier = Modifier.size(28.dp)
                )
            }
            Spacer(modifier = Modifier.width(14.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun SectionBlock(title: String, body: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = body,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 22.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
