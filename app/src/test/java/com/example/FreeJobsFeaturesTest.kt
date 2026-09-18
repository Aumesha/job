package com.example

import com.example.data.JobRepository
import com.example.model.AppMenu
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class FreeJobsFeaturesTest {

    @Test
    fun `verify job articles exist and are well-formed`() {
        val articles = JobRepository.getJobArticles()
        assertTrue("Job articles should not be empty", articles.isNotEmpty())
        assertTrue("Should have multiple job articles", articles.size >= 8)

        articles.forEach { article ->
            assertNotNull(article.id)
            assertTrue(article.titleKannada.isNotBlank())
            assertTrue(article.titleEnglish.isNotBlank())
            assertTrue(article.organization.isNotBlank())
            assertTrue(article.shortDescriptionKannada.isNotBlank())
            assertTrue(article.fullArticleKannada.isNotBlank())
            assertTrue(article.officialApplyUrl.startsWith("http"))
        }
    }

    @Test
    fun `verify automated website sources list contains 8 or more portals`() {
        val websites = JobRepository.getJobWebsiteSources()
        assertTrue("Should contain 8 or more authoritative portals", websites.size >= 8)

        websites.forEach { site ->
            assertTrue(site.name.isNotBlank())
            assertTrue(site.url.startsWith("http"))
            assertTrue(site.isAutoSync)
        }
    }

    @Test
    fun `verify YouTube career channels and video items`() {
        val channels = JobRepository.getYouTubeChannelSources()
        assertTrue("Should contain top YouTube channels", channels.size >= 6)

        val videos = JobRepository.getCareerVideos()
        assertTrue("Should contain job career preparation videos", videos.isNotEmpty())

        videos.forEach { video ->
            assertTrue(video.youtubeVideoId.isNotBlank())
            assertTrue(video.channelName.isNotBlank())
            assertTrue(video.titleKannada.isNotBlank())
        }
    }

    @Test
    fun `verify AppMenu covers jobs, videos and info`() {
        val menus = AppMenu.values()
        assertEquals(3, menus.size)
        assertTrue(menus.contains(AppMenu.JOBS))
        assertTrue(menus.contains(AppMenu.VIDEOS))
        assertTrue(menus.contains(AppMenu.INFO))
    }
}
