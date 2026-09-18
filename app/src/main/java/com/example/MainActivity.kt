package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.model.JobArticle
import com.example.model.JobVideo
import com.example.model.UnityAdConfig
import com.example.ui.JobDetailScreen
import com.example.ui.MainScreen
import com.example.ui.VideoDetailScreen
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                FreeJobsApp()
            }
        }
    }
}

@Composable
fun FreeJobsApp() {
    var selectedJobArticle by remember { mutableStateOf<JobArticle?>(null) }
    var selectedVideo by remember { mutableStateOf<JobVideo?>(null) }
    var isKannada by remember { mutableStateOf(true) }
    var adConfig by remember { mutableStateOf(UnityAdConfig()) }

    val toggleLanguage = { isKannada = !isKannada }

    when {
        selectedJobArticle != null -> {
            BackHandler {
                selectedJobArticle = null
            }
            JobDetailScreen(
                article = selectedJobArticle!!,
                isKannada = isKannada,
                onToggleLanguage = toggleLanguage,
                adConfig = adConfig,
                onBack = { selectedJobArticle = null },
                modifier = Modifier.fillMaxSize()
            )
        }
        selectedVideo != null -> {
            BackHandler {
                selectedVideo = null
            }
            VideoDetailScreen(
                video = selectedVideo!!,
                isKannada = isKannada,
                adConfig = adConfig,
                onBack = { selectedVideo = null },
                modifier = Modifier.fillMaxSize()
            )
        }
        else -> {
            MainScreen(
                onOpenJobDetail = { article -> selectedJobArticle = article },
                onOpenVideoDetail = { video -> selectedVideo = video },
                isKannada = isKannada,
                onToggleLanguage = toggleLanguage,
                adConfig = adConfig,
                onUpdateAdConfig = { newConfig -> adConfig = newConfig },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
