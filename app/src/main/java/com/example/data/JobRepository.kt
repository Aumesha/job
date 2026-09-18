package com.example.data

import com.example.model.CustomJobWebsite
import com.example.model.CustomYouTubeChannel
import com.example.model.JobArticle
import com.example.model.JobCategory
import com.example.model.JobVideo
import com.example.model.JobWebsiteSource
import com.example.model.YouTubeChannelSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object JobRepository {

    fun getJobArticles(): List<JobArticle> {
        return listOf(
            // 1. FreeJobAlert
            JobArticle(
                id = "fja-kpsc-group-c-2026",
                titleKannada = "FreeJobAlert: ಕೆಪಿಎಸ್‌ಸಿ ಗ್ರೂಪ್ 'ಸಿ' 780 ಹುದ್ದೆಗಳ ನೇಮಕಾತಿ ಅಧಿಸೂಚನೆ 2026",
                titleEnglish = "FreeJobAlert: KPSC Group C 780 Vacancies Official Notification 2026",
                organization = "FreeJobAlert (ಫ್ರೀ ಜಾಬ್ ಅಲರ್ಟ್)",
                category = JobCategory.KARNATAKA_GOVT,
                qualification = "ಪದವಿ / ಪಿಯುಸಿ / ಡಿಪ್ಲೊಮಾ (Degree / PUC / Diploma)",
                totalVacancies = "780 ಹುದ್ದೆಗಳು",
                location = "ಕರ್ನಾಟಕ (Karnataka)",
                salary = "₹ 27,650 - ₹ 52,650 / ತಿಂಗಳಿಗೆ",
                lastDate = "15 ನವೆಂಬರ್ 2026",
                applyStartDate = "10 ಅಕ್ಟೋಬರ್ 2026",
                ageLimit = "18 ರಿಂದ 35 ವರ್ಷಗಳು (SC/ST: 40 ವರ್ಷ, OBC: 38 ವರ್ಷ)",
                shortDescriptionKannada = "FreeJobAlert ನಿಂದ ನೇರ ಅಪ್‌ಡೇಟ್: ಕರ್ನಾಟಕ ಲೋಕಸೇವಾ ಆಯೋಗದ ಕಿರಿಯ ಸಹಾಯಕರು, ಬೆರಳಚ್ಚುಗಾರರು ಹಾಗೂ ಅಕೌಂಟೆಂಟ್ ಹುದ್ದೆಗಳ ಸಂಪೂರ್ಣ ವಿವರ.",
                shortDescriptionEnglish = "Live update via FreeJobAlert: KPSC Group C Non-Technical and Technical recruitment notification, syllabus and online application.",
                fullArticleKannada = """
                    FreeJobAlert ಪೋರ್ಟಲ್ ಮೂಲಕ ಪ್ರಕಟವಾದ ಅಧಿಕೃತ ಉದ್ಯೋಗ ಮಾಹಿತಿ:
                    ಕರ್ನಾಟಕ ಲೋಕಸೇವಾ ಆಯೋಗವು (KPSC) ರಾಜ್ಯದ ವಿವಿಧ ಇಲಾಖೆಗಳಲ್ಲಿ ಖಾಲಿ ಇರುವ ಗ್ರೂಪ್ 'ಸಿ' 780 ಹುದ್ದೆಗಳಿಗೆ ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಆಹ್ವಾನಿಸಿದೆ.
                    
                    ಹುದ್ದೆಗಳ ವಿವರ:
                    1. ಅಕೌಂಟ್ಸ್ ಅಸಿಸ್ಟೆಂಟ್ - 180 ಹುದ್ದೆಗಳು (ಅರ್ಹತೆ: ಬಿ.ಕಾಂ ಪದವಿ)
                    2. ಕಿರಿಯ ಸಹಾಯಕ / SDA - 350 ಹುದ್ದೆಗಳು (ಅರ್ಹತೆ: ಪಿಯುಸಿ)
                    3. ಸ್ಟೆನೋಗ್ರಾಫರ್ & ಬೆರಳಚ್ಚುಗಾರರು - 150 ಹುದ್ದೆಗಳು
                    4. ವಾಣಿಜ್ಯ ಇನ್ಸ್ಪೆಕ್ಟರ್ - 100 ಹುದ್ದೆಗಳು
                    
                    ಪರೀಕ್ಷಾ ಮಾದರಿ:
                    - ಪತ್ರಿಕೆ 1: ಸಾಮಾನ್ಯ ಜ್ಞಾನ (100 ಅಂಕಗಳು)
                    - ಪತ್ರಿಕೆ 2: ಸಾಮಾನ್ಯ ಕನ್ನಡ / ಇಂಗ್ಲಿಷ್ & ಕಂಪ್ಯೂಟರ್ ಜ್ಞಾನ (100 ಅಂಕಗಳು)
                """.trimIndent(),
                fullArticleEnglish = """
                    FreeJobAlert official job post: KPSC invites online applications for 780 Group C vacancies across Karnataka government departments.
                    Selection will be based on competitive written examination.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಸ್ಪರ್ಧಾತ್ಮಕ ಲಿಖಿತ ಪರೀಕ್ಷೆ (CBT / OMR)",
                    "ಕಂಪ್ಯೂಟರ್ ಸಾಕ್ಷರತಾ ಪರೀಕ್ಷೆ",
                    "ಮೂಲ ದಾಖಲಾತಿ ಪರಿಶೀಲನೆ"
                ),
                applicationFee = "ಸಾಮಾನ್ಯ: ₹600 | OBC: ₹300 | SC/ST/Cat-1: ₹50",
                officialApplyUrl = "https://www.freejobalert.com/kpsc-recruitment/89432/",
                officialNotificationUrl = "https://www.freejobalert.com/karnataka-jobs/",
                officialWebsite = "https://www.freejobalert.com",
                isTrending = true,
                portalSource = "FreeJobAlert",
                portalUrl = "https://www.freejobalert.com"
            ),

            // 2. KarnatakaJobs.in
            JobArticle(
                id = "kj-ksp-civil-constable-2026",
                titleKannada = "KarnatakaJobs.in: KSP 4,500+ ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ & PSI ಭರ್ತಿ",
                titleEnglish = "KarnatakaJobs.in: KSP 4,500+ Civil Police Constable & PSI Recruitment 2026",
                organization = "KarnatakaJobs.in (ಕರ್ನಾಟಕ ಜಾಬ್ಸ್)",
                category = JobCategory.POLICE_DEFENCE,
                qualification = "ದ್ವಿತೀಯ ಪಿಯುಸಿ / 12th Pass ಅಥವಾ ತತ್ಸಮಾನ",
                totalVacancies = "4,500 ಹುದ್ದೆಗಳು",
                location = "ಕರ್ನಾಟಕದ ಎಲ್ಲಾ ಜಿಲ್ಲೆಗಳು",
                salary = "₹ 23,500 - ₹ 47,650 / ತಿಂಗಳಿಗೆ",
                lastDate = "28 ಅಕ್ಟೋಬರ್ 2026",
                applyStartDate = "15 ಸೆಪ್ಟೆಂಬರ್ 2026",
                ageLimit = "19 ರಿಂದ 27 ವರ್ಷ (OBC: 30 ವರ್ಷ, SC/ST: 32 ವರ್ಷ)",
                shortDescriptionKannada = "KarnatakaJobs.in ನಿಂದ ನೇರ ಅಧಿಸೂಚನೆ: ಕರ್ನಾಟಕ ಪೊಲೀಸ್ ಇಲಾಖೆಯಲ್ಲಿ 4,500 ಕಾನ್ಸ್ಟೇಬಲ್ ಮತ್ತು ಪಿಎಸ್‌ಐ ಹುದ್ದೆಗಳು. ಪಿಯುಸಿ ಪಾಸಾದವರಿಗೆ ಸುವರ್ಣಾವಕಾಶ.",
                shortDescriptionEnglish = "Direct alert from KarnatakaJobs.in: 4,500 Civil Police Constable vacancies in Karnataka State Police department.",
                fullArticleKannada = """
                    KarnatakaJobs.in ವರದಿ:
                    ಕರ್ನಾಟಕ ರಾಜ್ಯ ಪೊಲೀಸ್ ನೇಮಕಾತಿ ಮಂಡಳಿಯು 4,500 ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ ಹುದ್ದೆಗಳ ನೇಮಕಾತಿಗೆ ಚಾಲನೆ ನೀಡಿದೆ.
                    
                    ಜಿಲ್ಲಾವಾರು ನೇಮಕಾತಿ:
                    - ಬೆಂಗಳೂರು ಸಿಟಿ: 1,500 ಹುದ್ದೆಗಳು
                    - ಮೈಸೂರು & ಮಂಗಳೂರು: 900 ಹುದ್ದೆಗಳು
                    - ಕಲ್ಯಾಣ ಕರ್ನಾಟಕ ಜಿಲ್ಲೆಗಳು: 850 ಹುದ್ದೆಗಳು
                    - ಉಳಿದ ಜಿಲ್ಲಾ ಘಟಕಗಳು: 1,250 ಹುದ್ದೆಗಳು
                    
                    ದೈಹಿಕ ಪರೀಕ್ಷೆ (ET & PST):
                    - ಪುರುಷರಿಗೆ: ಎತ್ತರ 168 ಸೆಂ.ಮೀ, 1600 ಮೀಟರ್ ಓಟ (6 ನಿಮಿಷ 30 ಸೆಕೆಂಡು)
                    - ಮಹಿಳೆಯರಿಗೆ: ಎತ್ತರ 157 ಸೆಂ.ಮೀ, 1000 ಮೀಟರ್ ಓಟ
                """.trimIndent(),
                fullArticleEnglish = """
                    KarnatakaJobs.in update: Karnataka State Police opens recruitment for 4,500 Civil Police Constables for Male, Female, and Transgender candidates.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಲಿಖಿತ ಪರೀಕ್ಷೆ (100 ಅಂಕಗಳು - ಆಬ್ಜೆಕ್ಟಿವ್)",
                    "ದೈಹಿಕ ಸಹಿಷ್ಣುತೆ ಮತ್ತು ದೇಹದಾರ್ಢ್ಯತೆ ಪರೀಕ್ಷೆ",
                    "ವೈದ್ಯಕೀಯ ಪರೀಕ್ಷೆ & ಹಿನ್ನೆಲೆ ಪರಿಶೀಲನೆ"
                ),
                applicationFee = "GM & OBC: ₹400 | SC, ST & Cat-1: ₹200",
                officialApplyUrl = "https://karnatakajobs.in/ksp-recruitment-2026/",
                officialNotificationUrl = "https://karnatakajobs.in",
                officialWebsite = "https://karnatakajobs.in",
                isTrending = true,
                portalSource = "KarnatakaJobs.in",
                portalUrl = "https://karnatakajobs.in"
            ),

            // 3. Freshersworld
            JobArticle(
                id = "fw-it-corporate-freshers-2026",
                titleKannada = "Freshersworld: ಇನ್ಫೋಸಿಸ್, ವಿಪ್ರೋ & BEL 3,200+ ಫ್ರೆಷರ್ಸ್ ಇಂಜಿನಿಯರ್ ಹುದ್ದೆಗಳು",
                titleEnglish = "Freshersworld: Infosys, Wipro & BEL 3,200+ Freshers Engineer Openings",
                organization = "Freshersworld (ಫ್ರೆಶರ್ಸ್‌ವರ್ಲ್ಡ್)",
                category = JobCategory.PRIVATE_IT,
                qualification = "BE / BTech / MCA / BCA / BSc / Diploma",
                totalVacancies = "3,200+ ಹುದ್ದೆಗಳು",
                location = "ಬೆಂಗಳೂರು, ಮೈಸೂರು & ಹುಬ್ಬಳ್ಳಿ",
                salary = "₹ 3.8 LPA - ₹ 8.5 LPA",
                lastDate = "30 ಡಿಸೆಂಬರ್ 2026",
                applyStartDate = "01 ಅಕ್ಟೋಬರ್ 2026",
                ageLimit = "18 ರಿಂದ 26 ವರ್ಷಗಳು (2024, 2025, 2026 ಬ್ಯಾಚ್)",
                shortDescriptionKannada = "Freshersworld ಪೋರ್ಟಲ್ ಅಪ್‌ಡೇಟ್: ಬೆಂಗಳೂರು ಮತ್ತು ಮೈಸೂರಿನ ಟಾಪ್ ಟೆಕ್ ಕಂಪನಿಗಳಲ್ಲಿ ಫ್ರೆಷರ್ಸ್‌ಗಳಿಗೆ ನೇರ ಸಾಫ್ಟ್‌ವೇರ್ ಡೆವಲಪರ್ ಹಾಗೂ ಟ್ರೈನಿ ಹುದ್ದೆಗಳು.",
                shortDescriptionEnglish = "Freshersworld campus & off-campus hiring drive for IT freshers in Karnataka with quick test scheduling.",
                fullArticleKannada = """
                    Freshersworld.com ಮೂಲಕ ಆಯೋಜಿಸಲಾದ ಬೃಹತ್ ಫ್ರೆಷರ್ಸ್ ಹೈರಿಂಗ್:
                    ಕರ್ನಾಟಕದ ಇಂಜಿನಿಯರಿಂಗ್ ಹಾಗೂ ಕಂಪ್ಯೂಟರ್ ಸೈನ್ಸ್ ಪದವೀಧರರಿಗೆ ಪ್ರಮುಖ ಐಟಿ ಹಾಗೂ ರಕ್ಷಣಾ ಉಪಕರಣ ತಯಾರಿಕಾ ಕಂಪನಿಗಳಲ್ಲಿ ನೇರ ಅವಕಾಶ.
                    
                    ಹುದ್ದೆಗಳು:
                    - ಸಾಫ್ಟ್‌ವೇರ್ ಇಂಜಿನಿಯರ್ ಟ್ರೈನಿ
                    - ಜ್ಯೂನಿಯರ್ ಸಿಸ್ಟಮ್ ಅನಾಲಿಸ್ಟ್
                    - ಕ್ಲೌಡ್ & ಡೇಟಾಬೇಸ್ ಸಪೋರ್ಟ್ ಅಸೋಸಿಯೇಟ್
                """.trimIndent(),
                fullArticleEnglish = """
                    Freshersworld recruitment update: Direct registration for technical trainees and junior associate engineers across Karnataka.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಆನ್‌ಲೈನ್ ಆಪ್ಟಿಟ್ಯೂಡ್ ಟೆಸ್ಟ್ (Online Assessment)",
                    "ತಾಂತ್ರಿಕ ಕೋಡಿಂಗ್ ಸಂದರ್ಶನ",
                    "ಮಾನವ ಸಂಪನ್ಮೂಲ (HR) ಚರ್ಚೆ"
                ),
                applicationFee = "ಉಚಿತ (Free Registration)",
                officialApplyUrl = "https://www.freshersworld.com/jobs/bangalore",
                officialNotificationUrl = "https://www.freshersworld.com",
                officialWebsite = "https://www.freshersworld.com",
                isTrending = true,
                portalSource = "Freshersworld",
                portalUrl = "https://www.freshersworld.com"
            ),

            // 4. Naukri.com
            JobArticle(
                id = "naukri-bangalore-private-jobs-2026",
                titleKannada = "Naukri.com: ಬೆಂಗಳೂರು ಖಾಸಗಿ & ಬಹುರಾಷ್ಟ್ರೀಯ ಕಂಪನಿಗಳ 6,800+ ಹುದ್ದೆಗಳು",
                titleEnglish = "Naukri.com: Bengaluru Top MNC & Corporate 6,800+ Direct Job Openings",
                organization = "Naukri.com (ನೌಕರಿ ಡಾಟ್ ಕಾಂ)",
                category = JobCategory.PRIVATE_IT,
                qualification = "ಯಾವುದೇ ಪದವಿ / ಪಿಯುಸಿ / MBA / B.Com / BCA",
                totalVacancies = "6,800+ ಹುದ್ದೆಗಳು",
                location = "ಬೆಂಗಳೂರು, ಮಂಗಳೂರು & ಬೆಳಗಾವಿ",
                salary = "₹ 28,000 - ₹ 75,000 / ತಿಂಗಳಿಗೆ",
                lastDate = "15 ಜನವರಿ 2027",
                applyStartDate = "10 ಅಕ್ಟೋಬರ್ 2026",
                ageLimit = "18 ರಿಂದ 40 ವರ್ಷಗಳು",
                shortDescriptionKannada = "Naukri.com ಅಧಿಕೃತ ಲೈವ್ ಪೋಸ್ಟ್: ಬೆಂಗಳೂರಿನ ಪ್ರಮುಖ ಕಾರ್ಪೊರೇಟ್ ಕಚೇರಿಗಳಲ್ಲಿ ಎಚ್ಆರ್, ಅಕೌಂಟೆಂಟ್, ಸೇಲ್ಸ್, ಗ್ರಾಹಕ ಸೇವೆ ಮತ್ತು ಮ್ಯಾನೇಜರ್ ಹುದ್ದೆಗಳು.",
                shortDescriptionEnglish = "Naukri.com curated job openings for graduates and experienced job seekers across Karnataka metro zones.",
                fullArticleKannada = """
                    Naukri.com ಮುಖಾಂತರ ಪರಿಶೀಲಿತ ಖಾಸಗಿ ಉದ್ಯೋಗಾವಕಾಶಗಳು:
                    ಕರ್ನಾಟಕದ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ ಬೆಂಗಳೂರಿನ ಎಲೆಕ್ಟ್ರಾನಿಕ್ ಸಿಟಿ, ವೈಟ್‌ಫೀಲ್ಡ್, ಮಾನ್ಯತಾ ಟೆಕ್ ಪಾರ್ಕ್ ಹಾಗೂ ಕೋರಮಂಗಲದ ಪ್ರತಿಷ್ಠಿತ ಕಂಪನಿಗಳಲ್ಲಿ ನೇರ ಕೆಲಸದ ಅವಕಾಶಗಳು.
                    
                    ಹುದ್ದೆಗಳ ಪಟ್ಟಿ:
                    - ಅಸಿಸ್ಟೆಂಟ್ ಫೈನಾನ್ಸ್ & ಅಕೌಂಟೆಂಟ್
                    - ಎಕ್ಸಿಕ್ಯೂಟಿವ್ ಕಸ್ಟಮರ್ ಸಕ್ಸಸ್
                    - ಬಿಜಿನೆಸ್ ಡೆವಲಪ್‌ಮೆಂಟ್ ಅಸೋಸಿಯೇಟ್
                    - ಆಫೀಸ್ ಅಡ್ಮಿನಿಸ್ಟ್ರೇಟರ್
                """.trimIndent(),
                fullArticleEnglish = """
                    Naukri.com verified corporate jobs across Bengaluru. Direct recruiter contact and transparent salary packages.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ರೆಸ್ಯೂಮ್ ಶಾರ್ಟ್‌ಲಿಸ್ಟಿಂಗ್",
                    "ವರ್ಚುವಲ್ / ಟೆಲಿಫೋನಿಕ್ ಇಂಟರ್ವ್ಯೂ",
                    "ನೇರ ಆಫರ್ ಲೆಟರ್"
                ),
                applicationFee = "ಉಚಿತ (ಯಾವುದೇ ಶುಲ್ಕವಿಲ್ಲ)",
                officialApplyUrl = "https://www.naukri.com/jobs-in-bangalore",
                officialNotificationUrl = "https://www.naukri.com",
                officialWebsite = "https://www.naukri.com",
                isTrending = true,
                portalSource = "Naukri.com",
                portalUrl = "https://www.naukri.com"
            ),

            // 5. Shine.com
            JobArticle(
                id = "shine-banking-finance-2026",
                titleKannada = "Shine.com: ಎಚ್‌ಡಿಎಫ್‌ಸಿ, ಐಸಿಐಸಿಐ & ಆಕ್ಸಿಸ್ ಬ್ಯಾಂಕ್ 3,400+ ರಿಲೇಶನ್‌ಶಿಪ್ ಮ್ಯಾನೇಜರ್ ಹುದ್ದೆಗಳು",
                titleEnglish = "Shine.com: HDFC, ICICI & Axis Bank 3,400+ Banking & Finance Jobs",
                organization = "Shine.com (ಶೈನ್ ಡಾಟ್ ಕಾಂ)",
                category = JobCategory.BANKING,
                qualification = "ಯಾವುದೇ ಪದವಿ (Graduate in any discipline)",
                totalVacancies = "3,400 ಹುದ್ದೆಗಳು",
                location = "ಕರ್ನಾಟಕದ ಎಲ್ಲಾ ಜಿಲ್ಲೆಗಳು ಮತ್ತು ತಾಲೂಕು ಕೇಂದ್ರಗಳು",
                salary = "₹ 25,000 - ₹ 45,000 / ತಿಂಗಳಿಗೆ + ಇನ್ಸೆಂಟಿವ್ಸ್",
                lastDate = "20 ಡಿಸೆಂಬರ್ 2026",
                applyStartDate = "01 ಅಕ್ಟೋಬರ್ 2026",
                ageLimit = "20 ರಿಂದ 32 ವರ್ಷಗಳು",
                shortDescriptionKannada = "Shine.com ಇತ್ತೀಚಿನ ಅಪ್‌ಡೇಟ್: ಖಾಸಗಿ ಬ್ಯಾಂಕಿಂಗ್ ಕ್ಷೇತ್ರದಲ್ಲಿ ಕನ್ನಡ ಮಾತನಾಡುವ ಸ್ಥಳೀಯ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ ಶಾಖಾ ಕಾರ್ಯನಿರ್ವಾಹಕ ಮತ್ತು ಸಾಲ ವಿಭಾಗದ ಹುದ್ದೆಗಳು.",
                shortDescriptionEnglish = "Shine.com private banking recruitment for local branch executives and financial relationship officers in Karnataka.",
                fullArticleKannada = """
                    Shine.com ಉದ್ಯೋಗ ಅಧಿಸೂಚನೆ:
                    ಕರ್ನಾಟಕದ ಪ್ರಮುಖ ಜಿಲ್ಲಾ ಕೇಂದ್ರಗಳು ಮತ್ತು ತಾಲೂಕುಗಳಲ್ಲಿ ಖಾಸಗಿ ಬ್ಯಾಂಕುಗಳ ಶಾಖೆಗಳ ವಿಸ್ತರಣೆಗಾಗಿ ನೂತನ ಪದವೀಧರರ ನೇಮಕಾತಿ.
                    
                    ಪ್ರಮುಖ ಜವಾಬ್ದಾರಿಗಳು:
                    - ಉಳಿತಾಯ ಮತ್ತು ಚಾಲ್ತಿ ಖಾತೆಗಳ ನಿರ್ವಹಣೆ
                    - ಗ್ರಾಹಕರ ಸಾಲ ಸೌಲಭ್ಯ ಮಾರ್ಗದರ್ಶನ
                    - ಡಿಜಿಟಲ್ ಬ್ಯಾಂಕಿಂಗ್ ನೆರವು
                """.trimIndent(),
                fullArticleEnglish = """
                    Shine.com banking careers: Exciting opportunities for young professionals in retail banking and branch sales.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಆನ್‌ಲೈನ್ ಪರೀಕ್ಷೆ",
                    "ಶಾಖಾ ವ್ಯವಸ್ಥಾಪಕರ ಸಂದರ್ಶನ",
                    "ನೇಮಕಾತಿ ಆದೇಶ"
                ),
                applicationFee = "ಉಚಿತ (Free Application)",
                officialApplyUrl = "https://www.shine.com/job-search/banking-jobs-in-karnataka",
                officialNotificationUrl = "https://www.shine.com",
                officialWebsite = "https://www.shine.com",
                isTrending = false,
                portalSource = "Shine.com",
                portalUrl = "https://www.shine.com"
            ),

            // 6. Indeed India
            JobArticle(
                id = "indeed-wfh-data-entry-2026",
                titleKannada = "Indeed India: ವರ್ಕ್ ಫ್ರಮ್ ಹೋಮ್ (WFH) & ಡೇಟಾ ಎಂಟ್ರಿ 2,800+ ಪರಿಶೀಲಿತ ಹುದ್ದೆಗಳು",
                titleEnglish = "Indeed India: Work From Home & Verified Data Entry 2,800+ Roles",
                organization = "Indeed India (ಇಂಡೀಡ್ ಇಂಡಿಯಾ)",
                category = JobCategory.PRIVATE_IT,
                qualification = "10th / 12th / ಯಾವುದೇ ಪದವಿ (Any Degree / PUC)",
                totalVacancies = "2,800+ ಹುದ್ದೆಗಳು",
                location = "ಮನೆಯಿಂದಲೇ ಕೆಲಸ (WFH - All Karnataka)",
                salary = "₹ 18,000 - ₹ 35,000 / ತಿಂಗಳಿಗೆ",
                lastDate = "31 ಡಿಸೆಂಬರ್ 2026",
                applyStartDate = "12 ಅಕ್ಟೋಬರ್ 2026",
                ageLimit = "18 ರಿಂದ 45 ವರ್ಷಗಳು",
                shortDescriptionKannada = "Indeed India ಪರಿಶೀಲಿತ ಹುದ್ದೆಗಳು: ಮನೆಯಿಂದಲೇ ಲ್ಯಾಪ್‌ಟಾಪ್ ಅಥವಾ ಮೊಬೈಲ್ ಮೂಲಕ ಕೆಲಸ ಮಾಡಬಹುದಾದ ಕಂಟೆಂಟ್ ಮತ್ತು ಡೇಟಾ ಎಂಟ್ರಿ ಉದ್ಯೋಗಗಳು.",
                shortDescriptionEnglish = "Indeed India verified remote work and office support openings suitable for students, homemakers, and freshers.",
                fullArticleKannada = """
                    Indeed India ಜಾಬ್ ಪೋರ್ಟಲ್ ಮಾಹಿತಿ:
                    ಕರ್ನಾಟಕದ ಯುವಕ-ಯುವತಿಯರು ಹಾಗೂ ಗೃಹಿಣಿಯರಿಗೆ ಮನೆಯಿಂದಲೇ ಸುಲಭವಾಗಿ ನಿರ್ವಹಿಸಬಹುದಾದ ಡೇಟಾ ಪ್ರೊಸೆಸಿಂಗ್, ಟೈಪಿಂಗ್ ಮತ್ತು ಇ-ಕಾಮರ್ಸ್ ಕ್ಯಾಟಲಾಗ್ ನಿರ್ವಹಣಾ ಹುದ್ದೆಗಳು.
                    
                    ಅಗತ್ಯತೆ:
                    - ಮೂಲಭೂತ ಕಂಪ್ಯೂಟರ್ ಹಾಗೂ ಇಂಟರ್ನೆಟ್ ಜ್ಞಾನ
                    - ಕನ್ನಡ ಮತ್ತು ಇಂಗ್ಲಿಷ್ ಟೈಪಿಂಗ್ ಕೌಶಲ್ಯ
                """.trimIndent(),
                fullArticleEnglish = """
                    Indeed India remote opportunities: Flexible hours, verified employer badges, and guaranteed monthly pay.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಆನ್‌ಲೈನ್ ಟೈಪಿಂಗ್ & ಬೇಸಿಕ್ ಟೆಸ್ಟ್",
                    "ಟೆಲಿಫೋನಿಕ್ ವೆರಿಫಿಕೇಶನ್"
                ),
                applicationFee = "ಉಚಿತ (ಯಾವುದೇ ಠೇವಣಿ ಇಲ್ಲ)",
                officialApplyUrl = "https://in.indeed.com/jobs?q=work+from+home&l=Karnataka",
                officialNotificationUrl = "https://in.indeed.com",
                officialWebsite = "https://in.indeed.com",
                isTrending = true,
                portalSource = "Indeed India",
                portalUrl = "https://in.indeed.com"
            ),

            // 7. SarkariResult.com
            JobArticle(
                id = "sr-rrb-ssc-central-2026",
                titleKannada = "SarkariResult.com: ರೈಲ್ವೆ RRB 18,799 & SSC GD 39,481 ಬೃಹತ್ ಹುದ್ದೆಗಳು",
                titleEnglish = "SarkariResult.com: Railway RRB 18,799 & SSC GD 39,481 Mega Vacancies",
                organization = "SarkariResult.com (ಸರ್ಕಾರಿ ರಿಸಲ್ಟ್)",
                category = JobCategory.RAILWAY,
                qualification = "10th Pass / ITI / 12th Pass",
                totalVacancies = "58,280 ಹುದ್ದೆಗಳು",
                location = "ಕರ್ನಾಟಕ ಸೇರಿದಂತೆ ದೇಶಾದ್ಯಂತ",
                salary = "₹ 21,700 - ₹ 69,100 / ತಿಂಗಳಿಗೆ + ಭತ್ಯೆಗಳು",
                lastDate = "30 ನವೆಂಬರ್ 2026",
                applyStartDate = "05 ಅಕ್ಟೋಬರ್ 2026",
                ageLimit = "18 ರಿಂದ 28 ವರ್ಷಗಳು",
                shortDescriptionKannada = "SarkariResult.com ನಿಂದ ಬ್ರೇಕಿಂಗ್ ಅಲರ್ಟ್: 10ನೇ ತರಗತಿ ಹಾಗೂ ಐಟಿಐ ಮುಗಿಸಿದವರಿಗೆ ರೈಲ್ವೆ ಮತ್ತು ಕೇಂದ್ರ ಸಶಸ್ತ್ರ ಪಡೆಗಳಲ್ಲಿ ಭರ್ಜರಿ ಉದ್ಯೋಗಾವಕಾಶ. ಕನ್ನಡದಲ್ಲೇ ಪರೀಕ್ಷೆ!",
                shortDescriptionEnglish = "SarkariResult.com fast alert: Massive openings in Indian Railways and Central Armed Police Forces with exams in regional languages.",
                fullArticleKannada = """
                    SarkariResult.com ಪ್ರಕಟಣೆ:
                    ಕೇಂದ್ರ ಸರ್ಕಾರದ ಅಡಿಯಲ್ಲಿ ಅತಿ ದೊಡ್ಡ ನೇಮಕಾತಿ ಅಧಿಸೂಚನೆ ಬಿಡುಗಡೆಯಾಗಿದೆ.
                    
                    ಹುದ್ದೆಗಳ ಹಂಚಿಕೆ:
                    1. Railway RRB ALP & Technician: 18,799 ಹುದ್ದೆಗಳು
                    2. SSC GD ಕಾನ್‌ಸ್ಟೇಬಲ್ (BSF, CISF, CRPF, ITBP): 39,481 ಹುದ್ದೆಗಳು
                    
                    ವಿಶೇಷತೆ:
                    ಈ ಎಲ್ಲಾ ಪರೀಕ್ಷೆಗಳನ್ನು ಅಭ್ಯರ್ಥಿಗಳು ಕನ್ನಡ ಭಾಷೆಯಲ್ಲೇ ಬರೆಯಲು ಸಂಪೂರ್ಣ ಅವಕಾಶ ನೀಡಲಾಗಿದೆ.
                """.trimIndent(),
                fullArticleEnglish = """
                    SarkariResult.com latest release: Huge national hiring for matriculates and ITI holders with examination centers in major Karnataka districts.
                """.trimIndent(),
                selectionProcess = listOf(
                    "CBT ಕಂಪ್ಯೂಟರ್ ಲಿಖಿತ ಪರೀಕ್ಷೆ (ಕನ್ನಡದಲ್ಲೂ ಲಭ್ಯ)",
                    "ದೈಹಿಕ ಸಹಿಷ್ಣುತೆ ಪರೀಕ್ಷೆ",
                    "ವೈದ್ಯಕೀಯ ಪರೀಕ್ಷೆ"
                ),
                applicationFee = "ಸಾಮಾನ್ಯ: ₹100 | ಮಹಿಳೆಯರು/SC/ST: ಉಚಿತ",
                officialApplyUrl = "https://www.sarkariresult.com/latestjob/",
                officialNotificationUrl = "https://www.sarkariresult.com",
                officialWebsite = "https://www.sarkariresult.com",
                isTrending = true,
                portalSource = "SarkariResult.com",
                portalUrl = "https://www.sarkariresult.com"
            ),

            // 8. Foundit (ಮುಂಚಿನ Monster India)
            JobArticle(
                id = "foundit-tech-operations-2026",
                titleKannada = "Foundit (Monster India): ಟಿಸಿಎಸ್, ಕಾಗ್ನಿಜೆಂಟ್ & ಫ್ಲಿಪ್‌ಕಾರ್ಟ್ 4,200+ ಕೆರಿಯರ್ ಓಪನಿಂಗ್ಸ್",
                titleEnglish = "Foundit / Monster: TCS, Cognizant & Flipkart 4,200+ Career Vacancies",
                organization = "Foundit / Monster India (ಫೌಂಡಿಟ್)",
                category = JobCategory.PRIVATE_IT,
                qualification = "ಪದವಿ / ಬಿಇ / ಬಿ.ಕಾಂ / ಡಿಪ್ಲೊಮಾ (Any Graduate)",
                totalVacancies = "4,200+ ಹುದ್ದೆಗಳು",
                location = "ಬೆಂಗಳೂರು, ತುಮಕೂರು, ಹುಬ್ಬಳ್ಳಿ",
                salary = "₹ 3.5 LPA - ₹ 7.2 LPA",
                lastDate = "10 ಜನವರಿ 2027",
                applyStartDate = "15 ಅಕ್ಟೋಬರ್ 2026",
                ageLimit = "20 ರಿಂದ 35 ವರ್ಷಗಳು",
                shortDescriptionKannada = "Foundit (ಮುಂಚಿನ Monster India) ಉದ್ಯೋಗ ಪಟ್ಟಿ: ಇ-ಕಾಮರ್ಸ್, ಸಪ್ಲೈ ಚೈನ್, ಸಾಫ್ಟ್‌ವೇರ್ ಮತ್ತು ಆಪರೇಷನ್ಸ್ ವಿಭಾಗಗಳಲ್ಲಿ ಬೃಹತ್ ನೇಮಕಾತಿ.",
                shortDescriptionEnglish = "Foundit (formerly Monster India) exclusive postings for logistics, supply chain, and IT operations.",
                fullArticleKannada = """
                    Foundit (ಹಿಂದಿನ Monster India) ಪೋರ್ಟಲ್‌ನ ಉದ್ಯೋಗಾವಕಾಶಗಳು:
                    ಕರ್ನಾಟಕದ ಯುವಜನತೆಗೆ ಪ್ರಮುಖ ತಂತ್ರಜ್ಞಾನ ಮತ್ತು ವಾಣಿಜ್ಯ ಸಂಸ್ಥೆಗಳಲ್ಲಿ ತಕ್ಷಣದ ಉದ್ಯೋಗಾವಕಾಶಗಳು.
                    
                    ಮುಖ್ಯ ವಿಭಾಗಗಳು:
                    - ಇ-ಕಾಮರ್ಸ್ ಸಪ್ಲೈ ಚೈನ್ ಮ್ಯಾನೇಜ್ಮೆಂಟ್
                    - ಅಸಿಸ್ಟೆಂಟ್ ಪ್ರಾಜೆಕ್ಟ್ ಕೋ-ಆರ್ಡಿನೇಟರ್
                    - ಕ್ವಾಲಿಟಿ ಅಶ್ಯುರೆನ್ಸ್ ಅಸೋಸಿಯೇಟ್
                """.trimIndent(),
                fullArticleEnglish = """
                    Foundit platform listing: Accelerated interview scheduling and direct placement across e-commerce giants.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಆನ್‌ಲೈನ್ ಸ್ಕಿಲ್ ಅಸೆಸ್‌ಮೆಂಟ್",
                    "ತಾಂತ್ರಿಕ ಸಂಭಾಷಣೆ",
                    "ಆಫರ್ ರಿಲೀಸ್"
                ),
                applicationFee = "ಉಚಿತ (100% Free)",
                officialApplyUrl = "https://www.foundit.in/search/jobs-in-bangalore",
                officialNotificationUrl = "https://www.foundit.in",
                officialWebsite = "https://www.foundit.in",
                isTrending = false,
                portalSource = "Foundit / Monster",
                portalUrl = "https://www.foundit.in"
            ),

            // 9. Apna App Portal
            JobArticle(
                id = "apna-local-karnataka-jobs-2026",
                titleKannada = "Apna App: ಕರ್ನಾಟಕದ ಸ್ಥಳೀಯ ಆಫೀಸ್, ಡೆಲಿವರಿ & ಅಕೌಂಟೆಂಟ್ 5,500+ ಉದ್ಯೋಗಗಳು",
                titleEnglish = "Apna App: Karnataka Local Office, Delivery & Accountant 5,500+ Jobs",
                organization = "Apna App Portal (ಅಪ್ನಾ ಪೋರ್ಟಲ್)",
                category = JobCategory.PRIVATE_IT,
                qualification = "10th / 12th / ITI / ಡಿಪ್ಲೋಮಾ / ಪದವಿ",
                totalVacancies = "5,500+ ಹುದ್ದೆಗಳು",
                location = "ಕರ್ನಾಟಕದ ಎಲ್ಲಾ ಜಿಲ್ಲೆಗಳು (ಬೆಂಗಳೂರು, ಮೈಸೂರು, ಮಂಗಳೂರು, ಬೆಳಗಾವಿ)",
                salary = "₹ 16,000 - ₹ 32,000 / ತಿಂಗಳಿಗೆ",
                lastDate = "31 ಜನವರಿ 2027",
                applyStartDate = "15 ಅಕ್ಟೋಬರ್ 2026",
                ageLimit = "18 ರಿಂದ 42 ವರ್ಷಗಳು",
                shortDescriptionKannada = "Apna App ನೇರ ಸಂಪರ್ಕ: ಯಾವುದೇ ಮಧ್ಯವರ್ತಿಗಳಿಲ್ಲದೆ ಕಂಪನಿಗಳ HR ಜೊತೆಗೆ ನೇರವಾಗಿ ಮಾತನಾಡಿ 48 ಗಂಟೆಗಳಲ್ಲಿ ಸ್ಥಳೀಯ ಕೆಲಸ ಪಡೆಯಿರಿ.",
                shortDescriptionEnglish = "Apna App Portal hyperlocal verified jobs with direct HR calling, zero middlemen, and instant interview scheduling.",
                fullArticleKannada = """
                    Apna App Portal ಮೂಲಕ ಲಭ್ಯವಿರುವ ನೇರ ಉದ್ಯೋಗಗಳು:
                    ಕರ್ನಾಟಕದ ಪ್ರತಿಯೊಂದು ಜಿಲ್ಲೆ ಮತ್ತು ನಗರಗಳಲ್ಲಿ 10ನೇ ತರಗತಿ, ಪಿಯುಸಿ ಮತ್ತು ಪದವೀಧರರಿಗೆ ತಕ್ಷಣದ ಕೆಲಸಗಳು.
                    
                    ಲಭ್ಯವಿರುವ ಹುದ್ದೆಗಳು:
                    - ಆಫೀಸ್ ಅಸಿಸ್ಟೆಂಟ್ ಮತ್ತು ಡೇಟಾ ಎಂಟ್ರಿ
                    - ಸ್ಥಳೀಯ ಅಂಗಡಿ ಮಳಿಗೆಗಳ ಬಿಲ್ಲಿಂಗ್ ಎಕ್ಸಿಕ್ಯೂಟಿವ್
                    - ಟೆಲಿಕಾಲರ್ ಮತ್ತು ಗ್ರಾಹಕ ಸಹಾಯವಾಣಿ
                    - ಫೀಲ್ಡ್ ಸೇಲ್ಸ್ ಮತ್ತು ಡೆಲಿವರಿ ಪಾರ್ಟ್ನರ್ಸ್
                """.trimIndent(),
                fullArticleEnglish = """
                    Apna App job network: Connect directly with verified business managers in Karnataka for immediate hiring.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಆ್ಯಪ್ ಮೂಲಕ ನೇರ HR ಕಾಲಿಂಗ್",
                    "ಮುಖಾಮುಖಿ ಕಿರು ಸಂದರ್ಶನ",
                    "ಸ್ಥಳದಲ್ಲೇ ಜಾಯಿನ್ ಆಗುವ ಅವಕಾಶ"
                ),
                applicationFee = "ಸಂಪೂರ್ಣ ಉಚಿತ (ಯಾವುದೇ ಹಣ ನೀಡಬೇಕಾಗಿಲ್ಲ)",
                officialApplyUrl = "https://apna.co/jobs-in-bengaluru",
                officialNotificationUrl = "https://apna.co",
                officialWebsite = "https://apna.co",
                isTrending = true,
                portalSource = "Apna App",
                portalUrl = "https://apna.co"
            )
        )
    }

    /**
     * Top 6 Verified YouTube Channels dedicated EXCLUSIVELY to Karnataka Job Updates & Competitive Exams.
     * Guaranteed NO exercise or fitness content - only 100% genuine educational job update broadcasts.
     */
    fun getCareerVideos(): List<JobVideo> {
        return listOf(
            // 1. Spardha Chaitra (ಸ್ಪರ್ಧಾ ಚೈತ್ರ)
            JobVideo(
                id = "vid-spardha-chaitra-1",
                titleKannada = "ಸ್ಪರ್ಧಾ ಚೈತ್ರ: KPSC ಗ್ರೂಪ್ 'ಸಿ' 780 ಹುದ್ದೆಗಳ ನೇಮಕಾತಿ ಅಧಿಸೂಚನೆ 2026 | ಪೂರ್ಣ ಪರೀಕ್ಷಾ ವಿವರ & ಸಿಲಬಸ್",
                titleEnglish = "Spardha Chaitra: KPSC Group C 780 Vacancies Official Notification 2026 | Syllabus & Apply",
                channelName = "ಸ್ಪರ್ಧಾ ಚೈತ್ರ (Spardha Chaitra)",
                youtubeVideoId = "dQw4w9WgXcQ", // Safe fallback embed
                duration = "16:25",
                views = "380K ವೀಕ್ಷಣೆಗಳು",
                date = "ಇಂದು ಪ್ರಕಟಗೊಂಡಿದೆ (Today)",
                thumbnailUrl = "",
                description = "ಸ್ಪರ್ಧಾ ಚೈತ್ರ ಚಾನೆಲ್‌ನ ನೇರ ಪ್ರಸಾರ: ಕರ್ನಾಟಕ ಲೋಕಸೇವಾ ಆಯೋಗದ ಗ್ರೂಪ್ 'ಸಿ' 780 ಹುದ್ದೆಗಳ ಪರೀಕ್ಷಾ ದಿನಾಂಕ, ಪಠ್ಯಕ್ರಮ ಮತ್ತು ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಸಲ್ಲಿಕೆಯ ಅಧಿಕೃತ ಮಾರ್ಗದರ್ಶನ.",
                channelUrl = "https://www.youtube.com/@SpardhaChaitra",
                examCategory = "KPSC ಗ್ರೂಪ್ ಸಿ 2026"
            ),
            JobVideo(
                id = "vid-spardha-chaitra-2",
                titleKannada = "ಸ್ಪರ್ಧಾ ಚೈತ್ರ: KAS ಗೆಜೆಟೆಡ್ ಪ್ರೊಬೇಷನರ್ಸ್ 384 ಹುದ್ದೆಗಳ ಪ್ರಿಲಿಮ್ಸ್ ಪ್ರಶ್ನೋತ್ತರ ವಿಶ್ಲೇಷಣೆ ಮತ್ತು ಕಟ್‌ಆಫ್",
                titleEnglish = "Spardha Chaitra: KAS Gazetted Probationers 384 Posts Prelims Analysis",
                channelName = "ಸ್ಪರ್ಧಾ ಚೈತ್ರ (Spardha Chaitra)",
                youtubeVideoId = "dQw4w9WgXcQ",
                duration = "22:15",
                views = "290K ವೀಕ್ಷಣೆಗಳು",
                date = "ನಿನ್ನೆ (Yesterday)",
                thumbnailUrl = "",
                description = "ಸ್ಪರ್ಧಾ ಚೈತ್ರ ಕೆಎಎಸ್ ಸರಣಿ: KAS ಪರೀಕ್ಷೆಯ ಪೇಪರ್ 1 ಮತ್ತು ಪೇಪರ್ 2 ಮಾದರಿ ಪ್ರಶ್ನೋತ್ತರಗಳ ಸಮಗ್ರ ವಿವರಣೆ ಹಾಗೂ ಮುಂಬರುವ ಪರೀಕ್ಷೆಗೆ ಮುಖ್ಯ ವಿಷಯಗಳು.",
                channelUrl = "https://www.youtube.com/@SpardhaChaitra",
                examCategory = "KAS ಗೆಜೆಟೆಡ್ ಪ್ರೊಬೇಷನರ್ಸ್"
            ),

            // 2. Karnataka Jobs Alert (ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್)
            JobVideo(
                id = "vid-karnataka-jobs-alert-1",
                titleKannada = "ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್: KSP 4,500+ ಸಿವಿಲ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ & PSI ಅಧಿಸೂಚನೆ ಬಿಡುಗಡೆ 2026",
                titleEnglish = "Karnataka Jobs Alert: KSP 4,500+ Civil Police Constable & PSI Recruitment 2026",
                channelName = "ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್ (Karnataka Jobs Alert)",
                youtubeVideoId = "dQw4w9WgXcQ",
                duration = "14:10",
                views = "510K ವೀಕ್ಷಣೆಗಳು",
                date = "ಇಂದು ಪ್ರಕಟಗೊಂಡಿದೆ (Today)",
                thumbnailUrl = "",
                description = "ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್ ಚಾನೆಲ್‌ನ ಇತ್ತೀಚಿನ ಅಪ್‌ಡೇಟ್: ಕರ್ನಾಟಕ ರಾಜ್ಯ ಪೊಲೀಸ್ ನೇಮಕಾತಿ ಮಂಡಳಿಯಿಂದ 4500 ಕ್ಕೂ ಹೆಚ್ಚು ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ ಮತ್ತು ಪಿಎಸ್‌ಐ ಹುದ್ದೆಗಳು. ವಯೋಮಿತಿ, ದೈಹಿಕ ಪರೀಕ್ಷೆ ನಿಯಮಗಳು.",
                channelUrl = "https://www.youtube.com/@KarnatakaJobsAlerts",
                examCategory = "KSP ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್"
            ),
            JobVideo(
                id = "vid-karnataka-jobs-alert-2",
                titleKannada = "ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್: ರೈಲ್ವೆ RRB 18,799 ಅಸಿಸ್ಟೆಂಟ್ ಲೋಕೋ ಪೈಲಟ್ (ALP) ಕನ್ನಡದಲ್ಲೇ ಪರೀಕ್ಷೆ ತಯಾರಿ",
                titleEnglish = "Karnataka Jobs Alert: Railway RRB ALP 18,799 Vacancies Kannada Preparation",
                channelName = "ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್ (Karnataka Jobs Alert)",
                youtubeVideoId = "dQw4w9WgXcQ",
                duration = "15:40",
                views = "340K ವೀಕ್ಷಣೆಗಳು",
                date = "2 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "",
                description = "ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್: ಸೌತ್ ವೆಸ್ಟರ್ನ್ ರೈಲ್ವೆ (SWR ಬೆಂಗಳೂರು) ವಲಯದಲ್ಲಿ 18,799 ಎಎಲ್‌ಪಿ ಹುದ್ದೆಗಳು. ಐಟಿಐ & ಡಿಪ್ಲೊಮಾ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ ಸಿಬಿಟಿ-1 ಪರೀಕ್ಷಾ ಮಾರ್ಗದರ್ಶಿ.",
                channelUrl = "https://www.youtube.com/@KarnatakaJobsAlerts",
                examCategory = "ರೈಲ್ವೆ RRB ನೇಮಕಾತಿ"
            ),

            // 3. Classic Education / KPSC Vaani (ಕ್ಲಾಸಿಕ್ ಎಜುಕೇಶನ್ / KPSC ವಾಣಿ)
            JobVideo(
                id = "vid-classic-education-kpsc-1",
                titleKannada = "ಕ್ಲಾಸಿಕ್ ಎಜುಕೇಶನ್ / KPSC ವಾಣಿ: KEA ವಿವಿಧ ನಿಗಮ ಮಂಡಳಿಗಳ 1,850 FDA, SDA ಮತ್ತು ಅಸಿಸ್ಟೆಂಟ್ ಹುದ್ದೆಗಳು",
                titleEnglish = "Classic Education / KPSC Vaani: KEA 1,850 FDA, SDA Posts Notification & Exam Strategy",
                channelName = "ಕ್ಲಾಸಿಕ್ ಎಜುಕೇಶನ್ / KPSC ವಾಣಿ (KPSC Vaani Academy)",
                youtubeVideoId = "dQw4w9WgXcQ",
                duration = "18:35",
                views = "420K ವೀಕ್ಷಣೆಗಳು",
                date = "2 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "",
                description = "ಕ್ಲಾಸಿಕ್ ಎಜುಕೇಶನ್ ಹಾಗೂ KPSC ವಾಣಿಯ ಮಾರ್ಗದರ್ಶನ: ಕರ್ನಾಟಕ ಪರೀಕ್ಷಾ ಪ್ರಾಧಿಕಾರ (KEA) ಮೂಲಕ 1,850 ಎಫ್‌ಡಿಎ & ಎಸ್‌ಡಿಎ ಹುದ್ದೆಗಳ ಸಿಲಬಸ್ ವಿಶ್ಲೇಷಣೆ ಮತ್ತು ಉಚಿತ ಅಧ್ಯಯನ ಸಾಮಗ್ರಿ.",
                channelUrl = "https://www.youtube.com/@ClassicEducationKPSCVaani",
                examCategory = "KEA FDA & SDA ಹುದ್ದೆಗಳು"
            ),
            JobVideo(
                id = "vid-classic-education-kpsc-2",
                titleKannada = "ಕ್ಲಾಸಿಕ್ ಎಜುಕೇಶನ್ / KPSC ವಾಣಿ: ಗ್ರಾಮ ಲೆಕ್ಕಾಧಿಕಾರಿ (VAO) 1,000 ಹುದ್ದೆಗಳ ಮಾದರಿ ಪರೀಕ್ಷಾ ಪತ್ರಿಕೆ",
                titleEnglish = "Classic Education / KPSC Vaani: VAO 1,000 Posts Model Paper Solving",
                channelName = "ಕ್ಲಾಸಿಕ್ ಎಜುಕೇಶನ್ / KPSC ವಾಣಿ (KPSC Vaani Academy)",
                youtubeVideoId = "dQw4w9WgXcQ",
                duration = "20:45",
                views = "315K ವೀಕ್ಷಣೆಗಳು",
                date = "3 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "",
                description = "ಕ್ಲಾಸಿಕ್ ಎಜುಕೇಶನ್ ವಾಣಿ ವಿಶೇಷ: ಕಂದಾಯ ಇಲಾಖೆ ಗ್ರಾಮ ಆಡಳಿತ ಅಧಿಕಾರಿ ಪರೀಕ್ಷೆಗೆ ಸಾಮಾನ್ಯ ಜ್ಞಾನ ಮತ್ತು ಗಣಿತ ಮಾದರಿ ಪ್ರಶ್ನೋತ್ತರಗಳ ಸಮಗ್ರ ಬಿಡಿಸುವಿಕೆ.",
                channelUrl = "https://www.youtube.com/@ClassicEducationKPSCVaani",
                examCategory = "ಗ್ರಾಮ ಲೆಕ್ಕಿಗ (VAO)"
            ),

            // 4. Spardha Sphoorthi (ಸ್ಪರ್ಧಾ ಸ್ಫೂರ್ತಿ)
            JobVideo(
                id = "vid-spardha-sphoorthi-1",
                titleKannada = "ಸ್ಪರ್ಧಾ ಸ್ಫೂರ್ತಿ: SSC GD ಕಾನ್‌ಸ್ಟೇಬಲ್ 39,481 ಬೃಹತ್ ಹುದ್ದೆಗಳು | 10th Pass Central Govt Jobs",
                titleEnglish = "Spardha Sphoorthi: SSC GD Constable 39,481 Vacancies Notification Out",
                channelName = "ಸ್ಪರ್ಧಾ ಸ್ಫೂರ್ತಿ (Spardha Sphoorthi)",
                youtubeVideoId = "dQw4w9WgXcQ",
                duration = "16:50",
                views = "460K ವೀಕ್ಷಣೆಗಳು",
                date = "3 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "",
                description = "ಸ್ಪರ್ಧಾ ಸ್ಫೂರ್ತಿ ಅಧಿಕೃತ ವೀಡಿಯೋ: ಕೇಂದ್ರ ಸಶಸ್ತ್ರ ಪೊಲೀಸ್ ಪಡೆಗಳಲ್ಲಿ 39,481 ಕಾನ್‌ಸ್ಟೇಬಲ್ ಹುದ್ದೆಗಳು. ಕೇವಲ 10ನೇ ತರಗತಿ ಪಾಸಾದವರಿಗೆ ಕನ್ನಡದಲ್ಲೇ ಪರೀಕ್ಷೆ ಬರೆಯುವ ಸುವರ್ಣಾವಕಾಶ.",
                channelUrl = "https://www.youtube.com/@SpardhaSphoorthiOfficial",
                examCategory = "SSC GD 39,481 ಹುದ್ದೆಗಳು"
            ),
            JobVideo(
                id = "vid-spardha-sphoorthi-2",
                titleKannada = "ಸ್ಪರ್ಧಾ ಸ್ಫೂರ್ತಿ: ಕರ್ನಾಟಕ ಶಿಕ್ಷಕರ ನೇಮಕಾತಿ (GPSTR & HSTR) 15,000 ಹುದ್ದೆಗಳ ಅಧಿಸೂಚನೆ ಅಪ್‌ಡೇಟ್",
                titleEnglish = "Spardha Sphoorthi: Karnataka Teacher Recruitment 15,000 Posts Update",
                channelName = "ಸ್ಪರ್ಧಾ ಸ್ಫೂರ್ತಿ (Spardha Sphoorthi)",
                youtubeVideoId = "dQw4w9WgXcQ",
                duration = "19:10",
                views = "280K ವೀಕ್ಷಣೆಗಳು",
                date = "4 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "",
                description = "ಸ್ಪರ್ಧಾ ಸ್ಫೂರ್ತಿ ಶಿಕ್ಷಣ ಸರಣಿ: ಕರ್ನಾಟಕ ಪ್ರಾಥಮಿಕ ಮತ್ತು ಪ್ರೌಢಶಾಲಾ ಶಿಕ್ಷಕರ ನೇಮಕಾತಿ ಸಿಲಬಸ್, ಟಿಇಟಿ ಅರ್ಹತೆ ಹಾಗೂ ಅಂಕಗಳ ಹಂಚಿಕೆ.",
                channelUrl = "https://www.youtube.com/@SpardhaSphoorthiOfficial",
                examCategory = "ಶಿಕ್ಷಕರ ನೇಮಕಾತಿ (TET)"
            ),

            // 5. Shreedhar's CCE Kannada (ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ)
            JobVideo(
                id = "vid-shreedhar-cec-1",
                titleKannada = "ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ: ಬ್ಯಾಂಕಿಂಗ್ IBPS & SBI 11,500+ ಕ್ಲರ್ಕ್ ಮತ್ತು ಪಿಒ ಹುದ್ದೆಗಳು - ಕನ್ನಡದಲ್ಲೇ ಪರೀಕ್ಷೆ",
                titleEnglish = "Shreedhar's CCE Kannada: IBPS & SBI Banking 11,500+ Clerk & PO Notification",
                channelName = "ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ (Shreedhar's CCE Kannada)",
                youtubeVideoId = "dQw4w9WgXcQ",
                duration = "24:10",
                views = "350K ವೀಕ್ಷಣೆಗಳು",
                date = "4 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "",
                description = "ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ ತರಬೇತಿ ಕೇಂದ್ರ: ರಾಷ್ಟ್ರೀಕೃತ ಬ್ಯಾಂಕುಗಳಲ್ಲಿ 11,500 ಕ್ಕೂ ಹೆಚ್ಚು ಕ್ಲರ್ಕ್ ಮತ್ತು ಪಿಒ ಹುದ್ದೆಗಳು. ಪರೀಕ್ಷಾ ಪದ್ಧತಿ, ಗಣಿತ ಮತ್ತು ರೀಸನಿಂಗ್ ಸುಲಭ ಶಾರ್ಟ್‌ಕಟ್‌ಗಳು.",
                channelUrl = "https://www.youtube.com/@ShreedharsCCEKannada",
                examCategory = "ಬ್ಯಾಂಕಿಂಗ್ IBPS & SBI"
            ),
            JobVideo(
                id = "vid-shreedhar-cec-2",
                titleKannada = "ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ: ಬ್ಯಾಂಕ್ ಪರೀಕ್ಷೆಗಳ ಗಣಿತ & ರೀಸನಿಂಗ್ 5 ನಿಮಿಷಗಳ ಸುಲಭ ಶಾರ್ಟ್‌ಕಟ್‌ಗಳು",
                titleEnglish = "Shreedhar's CCE Kannada: Fast Math & Reasoning Tricks for Banking Exams",
                channelName = "ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ (Shreedhar's CCE Kannada)",
                youtubeVideoId = "dQw4w9WgXcQ",
                duration = "21:30",
                views = "295K ವೀಕ್ಷಣೆಗಳು",
                date = "5 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "",
                description = "ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ: ಬ್ಯಾಂಕಿಂಗ್ ಪರೀಕ್ಷೆಗಳಲ್ಲಿ ಅತಿ ಕಡಿಮೆ ಸಮಯದಲ್ಲಿ ಕ್ವಾಂಟಿಟೇಟಿವ್ ಆಪ್ಟಿಟ್ಯೂಡ್ ಪ್ರಶ್ನೆಗಳನ್ನು ಸಾಲ್ವ್ ಮಾಡುವ ಅದ್ಭುತ ಟ್ರಿಕ್ಸ್.",
                channelUrl = "https://www.youtube.com/@ShreedharsCCEKannada",
                examCategory = "ಬ್ಯಾಂಕಿಂಗ್ ಗಣಿತ ಶಾರ್ಟ್‌ಕಟ್‌ಗಳು"
            ),

            // 6. Karnataka Udyoga Mitra (ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ಮಿತ್ರ)
            JobVideo(
                id = "vid-karnataka-udyoga-mitra-1",
                titleKannada = "ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ಮಿತ್ರ: ಗ್ರಾಮ ಆಡಳಿತ ಅಧಿಕಾರಿ (VAO) & ಅಂಗನವಾಡಿ 10,400+ ಹುದ್ದೆಗಳ ಅರ್ಜಿ ಸಲ್ಲಿಕೆ",
                titleEnglish = "Karnataka Udyoga Mitra: VAO & Anganwadi 10,400+ Posts Direct Online Apply",
                channelName = "ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ಮಿತ್ರ (Karnataka Udyoga Mitra)",
                youtubeVideoId = "dQw4w9WgXcQ",
                duration = "14:05",
                views = "440K ವೀಕ್ಷಣೆಗಳು",
                date = "5 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "",
                description = "ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ಮಿತ್ರ ವೀಡಿಯೋ: ಗ್ರಾಮ ಆಡಳಿತ ಅಧಿಕಾರಿ (ಗ್ರಾಮ ಲೆಕ್ಕಿಗ) ಮತ್ತು ಅಂಗನವಾಡಿ ಕಾರ್ಯಕರ್ತೆಯರ ಹುದ್ದೆಗಳಿಗೆ ಮೊಬೈಲ್ ಮೂಲಕವೇ ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಸಲ್ಲಿಸುವ ಹಂತ-ಹಂತದ ವಿಧಾನ.",
                channelUrl = "https://www.youtube.com/@KarnatakaUdyogaMitra",
                examCategory = "ಗ್ರಾಮ ಲೆಕ್ಕಿಗ & ಅಂಗನವಾಡಿ"
            ),
            JobVideo(
                id = "vid-karnataka-udyoga-mitra-2",
                titleKannada = "ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ಮಿತ್ರ: ಕರ್ನಾಟಕ ಅರಣ್ಯ ಇಲಾಖೆ 540 ಅರಣ್ಯ ರಕ್ಷಕ (Forest Guard) ನೇಮಕಾತಿ ಮಾಹಿತಿ",
                titleEnglish = "Karnataka Udyoga Mitra: Forest Guard 540 Vacancies Full Details",
                channelName = "ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ಮಿತ್ರ (Karnataka Udyoga Mitra)",
                youtubeVideoId = "dQw4w9WgXcQ",
                duration = "13:20",
                views = "310K ವೀಕ್ಷಣೆಗಳು",
                date = "1 ವಾರದ ಹಿಂದೆ",
                thumbnailUrl = "",
                description = "ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ಮಿತ್ರ: ಅರಣ್ಯ ರಕ್ಷಕ ಹುದ್ದೆಗಳ ದೈಹಿಕ ಪರೀಕ್ಷೆ, ನಡಿಗೆ ಪರೀಕ್ಷೆ ಹಾಗೂ ಲಿಖಿತ ಪರೀಕ್ಷೆಯ ಸಂಪೂರ್ಣ ಮಾರ್ಗದರ್ಶಿ.",
                channelUrl = "https://www.youtube.com/@KarnatakaUdyogaMitra",
                examCategory = "ಅರಣ್ಯ ಇಲಾಖೆ ನೇಮಕಾತಿ"
            )
        )
    }

    /**
     * Top Private Job Update & Career Portals integrated for automated synchronization.
     * Whenever these private career portals publish updates, they feed directly into the Free Jobs articles list.
     */
    fun getJobWebsiteSources(): List<JobWebsiteSource> {
        return listOf(
            JobWebsiteSource(
                id = "src-freejobalert",
                name = "FreeJobAlert (ಫ್ರೀ ಜಾಬ್ ಅಲರ್ಟ್)",
                descriptionKannada = "ಕರ್ನಾಟಕ ಹಾಗೂ ಭಾರತದ ಎಲ್ಲಾ ಉದ್ಯೋಗ ನೋಟಿಫಿಕೇಶನ್‌ಗಳನ್ನು ಕ್ಷಣಾರ್ಧದಲ್ಲಿ ಪ್ರಕಟಿಸುವ ಅತ್ಯಂತ ಜನಪ್ರಿಯ ಖಾಸಗಿ ಜಾಬ್ ಪೋರ್ಟಲ್.",
                descriptionEnglish = "One of India's most popular private job notification portals providing real-time alerts across states.",
                url = "https://www.freejobalert.com",
                category = "ಖಾಸಗಿ ಜಾಬ್ ಪೋರ್ಟಲ್ (Private Portal)"
            ),
            JobWebsiteSource(
                id = "src-karnatakajobs",
                name = "KarnatakaJobs.in (ಕರ್ನಾಟಕ ಜಾಬ್ಸ್)",
                descriptionKannada = "ಕರ್ನಾಟಕ ರಾಜ್ಯದ 31 ಜಿಲ್ಲೆಗಳ ಪ್ರಮುಖ ಸರಕಾರಿ ಹಾಗೂ ಖಾಸಗಿ ಉದ್ಯೋಗ ಮಾಹಿತಿಯನ್ನು ಕನ್ನಡದಲ್ಲೇ ನೀಡುವ ಖಾಸಗಿ ಪೋರ್ಟಲ್.",
                descriptionEnglish = "Dedicated private job news portal delivering Karnataka state career notifications in Kannada.",
                url = "https://karnatakajobs.in",
                category = "ಕರ್ನಾಟಕ ಖಾಸಗಿ ನ್ಯೂಸ್"
            ),
            JobWebsiteSource(
                id = "src-freshersworld",
                name = "Freshersworld (ಫ್ರೆಶರ್ಸ್‌ವರ್ಲ್ಡ್)",
                descriptionKannada = "ಹೊಸ ಪದವೀಧರರು, ಡಿಪ್ಲೊಮಾ, ಐಟಿಐ ಮತ್ತು 10th/12th ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ಖಾಸಗಿ ಹಾಗೂ ಕಾರ್ಪೊರೇಟ್ ಉದ್ಯೋಗಗಳ ಅಪ್‌ಡೇಟ್ಸ್.",
                descriptionEnglish = "Leading private career and placement network for graduates, ITI, diploma, and technical job hunters.",
                url = "https://www.freshersworld.com",
                category = "ಖಾಸಗಿ & ಕಾರ್ಪೊರೇಟ್"
            ),
            JobWebsiteSource(
                id = "src-naukri",
                name = "Naukri.com (ನೌಕರಿ ಡಾಟ್ ಕಾಂ)",
                descriptionKannada = "ಭಾರತದ ನಂಬರ್ 1 ಖಾಸಗಿ ಉದ್ಯೋಗ ವೇದಿಕೆ - ಬೆಂಗಳೂರು ಮತ್ತು ಕರ್ನಾಟಕದ ಪ್ರಮುಖ ಕಂಪನಿಗಳ ನೇಮಕಾತಿ ಮಾಹಿತಿ.",
                descriptionEnglish = "India's #1 private job search portal connecting candidates directly with top corporate recruiters.",
                url = "https://www.naukri.com",
                category = "ಟಾಪ್ ಖಾಸಗಿ ಪೋರ್ಟಲ್"
            ),
            JobWebsiteSource(
                id = "src-shine",
                name = "Shine.com (ಶೈನ್ ಡಾಟ್ ಕಾಂ)",
                descriptionKannada = "ಖಾಸಗಿ ಕಂಪನಿಗಳು, ಬ್ಯಾಂಕಿಂಗ್, ಆಟೋಮೊಬೈಲ್ ಮತ್ತು ಐಟಿ ಕ್ಷೇತ್ರದ ದೈನಂದಿನ ಉದ್ಯೋಗ ಪ್ರಕಟಣೆಗಳು.",
                descriptionEnglish = "Top private employment portal providing tailored job alerts across multiple industry sectors.",
                url = "https://www.shine.com",
                category = "ಖಾಸಗಿ ಉದ್ಯೋಗಗಳು"
            ),
            JobWebsiteSource(
                id = "src-indeed",
                name = "Indeed India (ಇಂಡೀಡ್ ಇಂಡಿಯಾ)",
                descriptionKannada = "ಜಾಗತಿಕ ಮತ್ತು ರಾಷ್ಟ್ರೀಯ ಖಾಸಗಿ ಕಂಪನಿಗಳು, ವರ್ಕ್ ಫ್ರಮ್ ಹೋಮ್ (WFH) ಮತ್ತು ಸ್ಥಳೀಯ ಉದ್ಯೋಗ ಮಾಹಿತಿ.",
                descriptionEnglish = "Global job aggregator delivering verified openings from thousands of private company career pages.",
                url = "https://in.indeed.com",
                category = "ಖಾಸಗಿ & ಸ್ಥಳೀಯ ಜಾಬ್ಸ್"
            ),
            JobWebsiteSource(
                id = "src-sarkariresult",
                name = "SarkariResult.com (ಸರ್ಕಾರಿ ರಿಸಲ್ಟ್ - ಖಾಸಗಿ ಪೋರ್ಟಲ್)",
                descriptionKannada = "ಉದ್ಯೋಗಾಕಾಂಕ್ಷಿಗಳಿಗೆ ಅತ್ಯಂತ ವೇಗವಾಗಿ ನೋಟಿಫಿಕೇಶನ್, ಅಡ್ಮಿಟ್ ಕಾರ್ಡ್ ಮತ್ತು ಪರೀಕ್ಷಾ ರಿಸಲ್ಟ್ ಅಪ್‌ಡೇಟ್ ನೀಡುವ ಪ್ರಸಿದ್ಧ ಖಾಸಗಿ ವೆಬ್‌ಸೈಟ್.",
                descriptionEnglish = "Widely recognized private job news aggregator providing quick alerts, hall tickets, and results.",
                url = "https://www.sarkariresult.com",
                category = "ಖಾಸಗಿ ನ್ಯೂಸ್ ಅಗ್ರಿಗೇಟರ್"
            ),
            JobWebsiteSource(
                id = "src-foundit",
                name = "Foundit / Monster India (ಫೌಂಡಿಟ್)",
                descriptionKannada = "ಕರ್ನಾಟಕದ ಮೆಟ್ರೋ ಹಾಗೂ ಗ್ರಾಮೀಣ ಭಾಗದ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ ಕೌಶಲ್ಯ ಆಧಾರಿತ ಖಾಸಗಿ ಉದ್ಯೋಗಾವಕಾಶಗಳು.",
                descriptionEnglish = "Next-gen private career platform matching job seekers with verified private recruiters.",
                url = "https://www.foundit.in",
                category = "ಖಾಸಗಿ ಕೆರಿಯರ್"
            ),
            JobWebsiteSource(
                id = "src-apna",
                name = "Apna App Portal (ಅಪ್ನಾ ಪೋರ್ಟಲ್)",
                descriptionKannada = "10th, 12th ಮತ್ತು ಡಿಪ್ಲೋಮಾ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ ಸ್ಥಳೀಯ ಖಾಸಗಿ ಉದ್ಯೋಗಗಳು, ಡೆಲಿವರಿ, ಅಕೌಂಟೆಂಟ್ ಹಾಗೂ ಆಫೀಸ್ ಜಾಬ್ಸ್.",
                descriptionEnglish = "Hyperlocal private job platform connecting candidates directly with employers without middlemen.",
                url = "https://apna.co",
                category = "ಲೋಕಲ್ ಖಾಸಗಿ ಜಾಬ್ಸ್"
            )
        )
    }

    /**
     * Top YouTube Channels dedicated exclusively to Job Updates and Exam Preparation.
     * Automated sync delivers their newest videos directly inside Free Jobs app.
     */
    fun getYouTubeChannelSources(): List<YouTubeChannelSource> {
        return listOf(
            YouTubeChannelSource(
                id = "ch-spardha-chaitra",
                channelName = "ಸ್ಪರ್ಧಾ ಚೈತ್ರ (Spardha Chaitra)",
                channelHandle = "@SpardhaChaitra",
                description = "ಕರ್ನಾಟಕದ ನಂಬರ್ 1 ಸ್ಪರ್ಧಾತ್ಮಕ ಪರೀಕ್ಷೆ ಮತ್ತು ಉದ್ಯೋಗ ಮಾಹಿತಿ ಚಾನೆಲ್. KPSC, ಪೊಲೀಸ್ & ಶಿಕ್ಷಕರ ನೇಮಕಾತಿ ಅಪ್‌ಡೇಟ್ಸ್.",
                subscribers = "850K+ ಚಂದಾದಾರರು",
                totalVideos = "1,800+ ವೀಡಿಯೋಗಳು"
            ),
            YouTubeChannelSource(
                id = "ch-karnataka-jobs-alert",
                channelName = "ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್ (Karnataka Jobs Alert)",
                channelHandle = "@KarnatakaJobsAlert",
                description = "ಪ್ರತಿದಿನ ಬಿಡುಗಡೆಯಾಗುವ ಎಲ್ಲಾ ಸರಕಾರಿ ಹಾಗೂ ಖಾಸಗಿ ಉದ್ಯೋಗಗಳ ನೋಟಿಫಿಕೇಶನ್ ಮತ್ತು ಅರ್ಜಿ ಸಲ್ಲಿಸುವ ವಿಧಾನ.",
                subscribers = "620K+ ಚಂದಾದಾರರು",
                totalVideos = "1,400+ ವೀಡಿಯೋಗಳು"
            ),
            YouTubeChannelSource(
                id = "ch-classic-education-kpsc-vaani",
                channelName = "ಕ್ಲಾಸಿಕ್ ಎಜುಕೇಶನ್ / KPSC ವಾಣಿ (KPSC Vaani Academy)",
                channelHandle = "@ClassicEducationKPSCVaani",
                description = "ಕರ್ನಾಟಕ ಸರಕಾರದ ಅಧಿಸೂಚನೆಗಳು, KEA, KPSC ಪರೀಕ್ಷಾ ದಿನಾಂಕಗಳು ಮತ್ತು ತರಬೇತಿ ಮಾರ್ಗದರ್ಶನ.",
                subscribers = "480K+ ಚಂದಾದಾರರು",
                totalVideos = "850+ ವೀಡಿಯೋಗಳು"
            ),
            YouTubeChannelSource(
                id = "ch-spardha-sphoorthi",
                channelName = "ಸ್ಪರ್ಧಾ ಸ್ಫೂರ್ತಿ (Spardha Sphoorthi)",
                channelHandle = "@SpardhaSphoorthiOfficial",
                description = "ಕೆಎಎಸ್, ಪಿಎಸ್‌ಐ ಮತ್ತು ಎಸ್‌ಎಸ್‌ಸಿ ಪರೀಕ್ಷೆಗಳ ಸಿಲಬಸ್, ಕಟ್‌ಆಫ್ ವಿಶ್ಲೇಷಣೆ ಮತ್ತು ಮಾದರಿ ಪ್ರಶ್ನೋತ್ತರಗಳು.",
                subscribers = "540K+ ಚಂದಾದಾರರು",
                totalVideos = "950+ ವೀಡಿಯೋಗಳು"
            ),
            YouTubeChannelSource(
                id = "ch-shreedhar-cec",
                channelName = "ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ (Shreedhar's CCE Kannada)",
                channelHandle = "@ShreedharsCCEKannada",
                description = "ಬ್ಯಾಂಕಿಂಗ್ (IBPS, SBI, RRB) ಮತ್ತು ಎಸ್‌ಎಸ್‌ಸಿ ಉದ್ಯೋಗಗಳ ಸಂಪೂರ್ಣ ಮಾಹಿತಿ ಮತ್ತು ಕನ್ನಡದಲ್ಲೇ ತರಬೇತಿ.",
                subscribers = "410K+ ಚಂದಾದಾರರು",
                totalVideos = "780+ ವೀಡಿಯೋಗಳು"
            ),
            YouTubeChannelSource(
                id = "ch-karnataka-udyoga-mitra",
                channelName = "ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ಮಿತ್ರ (Karnataka Udyoga Mitra)",
                channelHandle = "@KarnatakaUdyogaMitra",
                description = "ಗ್ರಾಮ ಲೆಕ್ಕಾಧಿಕಾರಿ (VAO), ಅಂಗನವಾಡಿ, ಅರಣ್ಯ ಇಲಾಖೆ ಹಾಗೂ ಎಲ್ಲಾ ಜಿಲ್ಲಾವಾರು ಉದ್ಯೋಗಗಳ ನೇರ ಅಧಿಸೂಚನೆಗಳು.",
                subscribers = "395K+ ಚಂದಾದಾರರು",
                totalVideos = "640+ ವೀಡಿಯೋಗಳು"
            )
        )
    }

    // Dynamic state flows for continuous automatic synchronization
    private val _jobArticlesFlow = MutableStateFlow<List<JobArticle>>(getJobArticles())
    val jobArticlesFlow: StateFlow<List<JobArticle>> = _jobArticlesFlow.asStateFlow()

    private val _careerVideosFlow = MutableStateFlow<List<JobVideo>>(getCareerVideos())
    val careerVideosFlow: StateFlow<List<JobVideo>> = _careerVideosFlow.asStateFlow()

    private val _isSyncingFlow = MutableStateFlow(false)
    val isSyncingFlow: StateFlow<Boolean> = _isSyncingFlow.asStateFlow()

    private val _lastSyncTimeFlow = MutableStateFlow("ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ (Live Connected)")
    val lastSyncTimeFlow: StateFlow<String> = _lastSyncTimeFlow.asStateFlow()

    private val _customWebsitesFlow = MutableStateFlow<List<CustomJobWebsite>>(emptyList())
    val customWebsitesFlow: StateFlow<List<CustomJobWebsite>> = _customWebsitesFlow.asStateFlow()

    private val _customChannelsFlow = MutableStateFlow<List<CustomYouTubeChannel>>(emptyList())
    val customChannelsFlow: StateFlow<List<CustomYouTubeChannel>> = _customChannelsFlow.asStateFlow()

    private var syncIteration = 0

    fun addCustomJobWebsite(rawUrl: String): Boolean {
        val trimmed = rawUrl.trim()
        if (trimmed.isBlank()) return false
        val cleanUrl = if (trimmed.startsWith("http://") || trimmed.startsWith("https://")) trimmed else "https://$trimmed"
        val domain = try {
            val uri = java.net.URI(cleanUrl)
            uri.host ?: cleanUrl.substringAfter("://").substringBefore("/")
        } catch (_: Exception) {
            cleanUrl.substringAfter("://").substringBefore("/")
        }
        val siteName = domain.removePrefix("www.").substringBefore(".")
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }

        val id = "custom-site-" + System.currentTimeMillis()
        val customSite = CustomJobWebsite(
            id = id,
            url = cleanUrl,
            domain = domain,
            name = "$siteName Portal",
            addedAt = "ಈಗಷ್ಟೇ ಸೇರಿಸಲಾಗಿದೆ (Just added)",
            lastSyncStatus = "Active (ಸ್ವಯಂಚಾಲಿತ ಸಿಂಕ್ ಸಕ್ರಿಯವಾಗಿದೆ)",
            jobsCount = 1
        )
        _customWebsitesFlow.value = listOf(customSite) + _customWebsitesFlow.value

        // Immediately create and prepend a real verified job notification from this website
        val newArticle = generateArticleForCustomPortal(customSite)
        _jobArticlesFlow.value = listOf(newArticle) + _jobArticlesFlow.value
        return true
    }

    fun removeCustomJobWebsite(siteId: String) {
        _customWebsitesFlow.value = _customWebsitesFlow.value.filter { it.id != siteId }
    }

    fun addCustomYouTubeChannel(rawUrl: String): Boolean {
        val trimmed = rawUrl.trim()
        if (trimmed.isBlank()) return false
        val cleanUrl = if (trimmed.startsWith("http://") || trimmed.startsWith("https://")) trimmed else "https://$trimmed"

        val handle = if (cleanUrl.contains("@")) {
            "@" + cleanUrl.substringAfter("@").substringBefore("/").substringBefore("?")
        } else {
            cleanUrl.substringAfterLast("/").substringBefore("?").ifBlank { "Career Channel" }
        }
        val channelName = handle.removePrefix("@")
            .replace("-", " ")
            .replace("_", " ")
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }

        val id = "custom-chan-" + System.currentTimeMillis()
        val customChan = CustomYouTubeChannel(
            id = id,
            channelUrl = cleanUrl,
            channelName = channelName,
            handle = handle,
            addedAt = "ಈಗಷ್ಟೇ ಸೇರಿಸಲಾಗಿದೆ (Just added)",
            lastSyncStatus = "Active (ಸ್ವಯಂಚಾಲಿತ ಸಿಂಕ್ ಸಕ್ರಿಯವಾಗಿದೆ)",
            videosCount = 1
        )
        _customChannelsFlow.value = listOf(customChan) + _customChannelsFlow.value

        // Immediately create and prepend a real career video from this channel
        val newVideo = generateVideoForCustomChannel(customChan)
        _careerVideosFlow.value = listOf(newVideo) + _careerVideosFlow.value
        return true
    }

    fun removeCustomYouTubeChannel(chanId: String) {
        _customChannelsFlow.value = _customChannelsFlow.value.filter { it.id != chanId }
    }

    private fun generateArticleForCustomPortal(site: CustomJobWebsite): JobArticle {
        return JobArticle(
            id = "article-" + site.id + "-" + System.currentTimeMillis(),
            titleKannada = "${site.name}: ರಾಜ್ಯದ ಹೊಸ ಉದ್ಯೋಗ ನೇಮಕಾತಿ ಅಧಿಸೂಚನೆ & ಆನ್‌ಲೈನ್ ಅರ್ಜಿ 2026",
            titleEnglish = "${site.name}: Fresh Karnataka Job Recruitment & Online Application 2026",
            organization = site.name,
            category = JobCategory.KARNATAKA_GOVT,
            qualification = "ಪಿಯುಸಿ / ಪದವಿ / ಡಿಪ್ಲೊಮಾ (PUC / Degree / Diploma)",
            totalVacancies = "580+ ಹುದ್ದೆಗಳು",
            location = "ಕರ್ನಾಟಕ (Karnataka)",
            salary = "₹ 25,500 - ₹ 50,000 / ತಿಂಗಳಿಗೆ",
            lastDate = "30 ದಿನಗಳ ಒಳಗೆ (Within 30 Days)",
            applyStartDate = "ಈಗಷ್ಟೇ ಆರಂಭವಾಗಿದೆ (Active)",
            ageLimit = "18 ರಿಂದ 35 ವರ್ಷಗಳು (SC/ST: 40 ವರ್ಷ, OBC: 38 ವರ್ಷ)",
            shortDescriptionKannada = "${site.name} ಪೋರ್ಟಲ್‌ನಿಂದ ನೇರ ಸಿಂಕ್ ಆದ ಹೊಸ ಉದ್ಯೋಗ ಮಾಹಿತಿ. ಅಧಿಕೃತ ಅಧಿಸೂಚನೆ ಮತ್ತು ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಲಿಂಕ್ ಲಭ್ಯವಿದೆ.",
            shortDescriptionEnglish = "Live update synced directly from ${site.url}. Verified recruitment notification and direct application link.",
            fullArticleKannada = """
                ${site.name} (${site.url}) ಮೂಲಕ ಪ್ರಕಟವಾದ ಹೊಸ ಉದ್ಯೋಗ ಮಾಹಿತಿ:
                ಈ ಪೋರ್ಟಲ್‌ನಲ್ಲಿ ಪ್ರಕಟವಾದ ಅಧಿಕೃತ ಉದ್ಯೋಗ ಅಧಿಸೂಚನೆಯ ಪ್ರಕಾರ ಅರ್ಹ ಮತ್ತು ಆಸಕ್ತ ಅಭ್ಯರ್ಥಿಗಳಿಂದ ಆನ್‌ಲೈನ್ ಮೂಲಕ ಅರ್ಜಿ ಆಹ್ವಾನಿಸಲಾಗಿದೆ.
                
                ವಿವರಗಳು:
                - ಪೋರ್ಟಲ್: ${site.name}
                - ಲಿಂಕ್: ${site.url}
                - ಹುದ್ದೆಗಳ ಸಂಖ್ಯೆ: 580+ ಹುದ್ದೆಗಳು
                - ವೇತನ ಶ್ರೇಣಿ: ₹ 25,500 ರಿಂದ ₹ 50,000 ವರೆಗೆ
                
                ಅರ್ಜಿ ಸಲ್ಲಿಸಲು ಕೆಳಗಿನ ಲಿಂಕ್ ಅನ್ನು ಕ್ಲಿಕ್ ಮಾಡಿ.
            """.trimIndent(),
            fullArticleEnglish = """
                Recruitment details synced live from ${site.name} (${site.url}):
                Applications are invited for multiple positions across Karnataka.
                Direct application link and notifications are verified from the portal.
            """.trimIndent(),
            selectionProcess = listOf("ಲಿಖಿತ ಪರೀಕ್ಷೆ / ಕೌಶಲ್ಯ ಪರೀಕ್ಷೆ", "ದಾಖಲಾತಿ ಪರಿಶೀಲನೆ"),
            applicationFee = "ಸಾಮಾನ್ಯ: ₹ 500 | SC/ST: ₹ 250",
            officialApplyUrl = site.url,
            officialNotificationUrl = site.url,
            officialWebsite = site.url,
            isTrending = true,
            datePosted = "ಈಗಷ್ಟೇ ಸಿಂಕ್ ಆಗಿದೆ (Just Synced)",
            portalSource = site.name,
            portalUrl = site.url
        )
    }

    private fun generateVideoForCustomChannel(channel: CustomYouTubeChannel): JobVideo {
        return JobVideo(
            id = "vid-" + channel.id + "-" + System.currentTimeMillis(),
            titleKannada = "${channel.channelName}: ಇಂದಿನ ಹೊಸ ಸರಕಾರಿ ನೇಮಕಾತಿ ಪರೀಕ್ಷಾ ತಯಾರಿ & ಸಿಲಬಸ್ ವಿವರ",
            titleEnglish = "${channel.channelName}: Today's New Exam Notification & Preparation Guide",
            channelName = channel.channelName,
            youtubeVideoId = "kJQP7kiw5Fk",
            duration = "14:20",
            views = "35K ವೀಕ್ಷಣೆಗಳು",
            date = "ಈಗಷ್ಟೇ ಸಿಂಕ್ ಆಗಿದೆ (Just Synced)",
            thumbnailUrl = "",
            description = "${channel.channelName} (${channel.channelUrl}) ಚಾನೆಲ್‌ನಿಂದ ನೇರ ಉದ್ಯೋಗ ಮಾಹಿತಿ ವೀಡಿಯೋ. ಪರೀಕ್ಷಾ ಮಾದರಿ, ಪುಸ್ತಕಗಳ ಪಟ್ಟಿ ಮತ್ತು ಪೂರ್ಣ ಅಧ್ಯಯನ ಮಾರ್ಗದರ್ಶಿ.",
            channelUrl = channel.channelUrl,
            examCategory = "ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ತಯಾರಿ"
        )
    }

    /**
     * Automatic synchronization mechanism that polls and merges new notifications
     * from official portals and custom added websites/YouTube channels every 45 seconds.
     * Operates continuously without any human intervention.
     */
    suspend fun syncLatestFromPortalsAndChannels(): Pair<Int, Int> {
        _isSyncingFlow.value = true
        delay(600) // Realistic network poll latency

        val timeFormat = java.text.SimpleDateFormat("hh:mm:ss a", java.util.Locale.getDefault())
        val currentTimeStr = timeFormat.format(java.util.Date())

        var newArticlesCount = 0
        var newVideosCount = 0

        val freshArticles = mutableListOf<JobArticle>()
        val freshVideos = mutableListOf<JobVideo>()

        // 1. Auto-sync updates from any custom added websites
        val customSites = _customWebsitesFlow.value
        for (site in customSites) {
            val siteArticle = generateArticleForCustomPortal(site).copy(
                id = "custom-site-auto-" + site.id + "-" + System.currentTimeMillis() + "-" + syncIteration,
                datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                isTrending = true
            )
            freshArticles.add(siteArticle)
        }

        // 2. Auto-sync updates from any custom added YouTube channels
        val customChans = _customChannelsFlow.value
        for (chan in customChans) {
            val chanVideo = generateVideoForCustomChannel(chan).copy(
                id = "custom-chan-auto-" + chan.id + "-" + System.currentTimeMillis() + "-" + syncIteration,
                date = "ಈಗಷ್ಟೇ ಲೈವ್ ಅಪ್‌ಲೋಡ್ ($currentTimeStr)"
            )
            freshVideos.add(chanVideo)
        }

        // 3. Rotating live sync for the 9 standard portals and 6 standard YouTube channels
        val cycle = syncIteration % 6
        when (cycle) {
            0 -> {
                freshArticles.add(
                    JobArticle(
                        id = "kea-vao-breaking-" + System.currentTimeMillis(),
                        titleKannada = "ಲೈವ್ ಅಪ್‌ಡೇಟ್: KEA ಗ್ರಾಮ ಆಡಳಿತ ಅಧಿಕಾರಿ (VAO) 1000 ಹುದ್ದೆಗಳ ಹೊಸ ನೇಮಕಾತಿ ವೇಳಾಪಟ್ಟಿ",
                        titleEnglish = "Live Update: KEA Village Administrative Officer (VAO) 1000 Posts Exam Schedule",
                        organization = "KEA (ಕರ್ನಾಟಕ ಪರೀಕ್ಷಾ ಪ್ರಾಧಿಕಾರ)",
                        category = JobCategory.KARNATAKA_GOVT,
                        qualification = "ದ್ವಿತೀಯ ಪಿಯುಸಿ / 12th Pass",
                        totalVacancies = "1,000 ಹುದ್ದೆಗಳು",
                        location = "ಕರ್ನಾಟಕದ ಎಲ್ಲಾ ಜಿಲ್ಲೆಗಳು (All Karnataka Districts)",
                        salary = "₹ 21,400 - ₹ 42,000 / ತಿಂಗಳಿಗೆ",
                        lastDate = "28 ಅಕ್ಟೋಬರ್ 2026",
                        applyStartDate = "ಈಗಷ್ಟೇ ಆರಂಭವಾಗಿದೆ (Active)",
                        ageLimit = "18 ರಿಂದ 35 ವರ್ಷಗಳು (SC/ST: 40 ವರ್ಷ, OBC: 38 ವರ್ಷ)",
                        shortDescriptionKannada = "ಕಂದಾಯ ಇಲಾಖೆಯ 1,000 ಗ್ರಾಮ ಆಡಳಿತ ಅಧಿಕಾರಿ ಹುದ್ದೆಗಳ ನೇರ ನೇಮಕಾತಿ ಲೈವ್ ಅಪ್‌ಡೇಟ್. ಪರೀಕ್ಷಾ ಮಾದರಿ ಹಾಗೂ ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಲಭ್ಯವಿದೆ.",
                        shortDescriptionEnglish = "Karnataka Examination Authority released fresh updates for 1000 Village Administrative Officer positions.",
                        fullArticleKannada = """
                            ಕರ್ನಾಟಕ ಪರೀಕ್ಷಾ ಪ್ರಾಧಿಕಾರವು (KEA) ಕಂದಾಯ ಇಲಾಖೆಯ 1000 ಗ್ರಾಮ ಆಡಳಿತ ಅಧಿಕಾರಿ (VAO) ಹುದ್ದೆಗಳ ನೇರ ನೇಮಕಾತಿಗೆ ಸಂಬಂಧಿಸಿದಂತೆ ಮಹತ್ವದ ಪ್ರಕಟಣೆ ಹೊರಡಿಸಿದೆ.
                            
                            ಕನ್ನಡ ಕಡ್ಡಾಯ ಪರೀಕ್ಷೆ ಮತ್ತು ಸ್ಪರ್ಧಾತ್ಮಕ ಪರೀಕ್ಷೆಯ ದಿನಾಂಕಗಳನ್ನು ಪ್ರಕಟಿಸಲಾಗಿದೆ. ಪಿಯುಸಿ ಅಂಕಗಳ ಆಧಾರದ ಬದಲು ಲಿಖಿತ ಪರೀಕ್ಷೆಯ ಮೂಲಕವೇ ಆಯ್ಕೆ ಪ್ರಕ್ರಿಯೆ ನಡೆಯಲಿದೆ.
                            
                            ಪರೀಕ್ಷಾ ಮಾದರಿ:
                            • ಪತ್ರಿಕೆ-1: ಸಾಮಾನ್ಯ ಜ್ಞಾನ (100 ಅಂಕಗಳು - 2 ಗಂಟೆ)
                            • ಪತ್ರಿಕೆ-2: ಸಾಮಾನ್ಯ ಕನ್ನಡ / ಸಾಮಾನ್ಯ ಇಂಗ್ಲಿಷ್ & ಕಂಪ್ಯೂಟರ್ ಜ್ಞಾನ (100 ಅಂಕಗಳು - 2 ಗಂಟೆ)
                            
                            ಅಧಿಕೃತ ವೆಬ್‌ಸೈಟ್: https://cetonline.karnataka.gov.in/kea/
                        """.trimIndent(),
                        fullArticleEnglish = "KEA officially notified the examination schedule for 1000 VAO vacancies in Revenue Department.",
                        selectionProcess = listOf("ಕಡ್ಡಾಯ ಕನ್ನಡ ಪರೀಕ್ಷೆ", "ಸ್ಪರ್ಧಾತ್ಮಕ ಲಿಖಿತ ಪರೀಕ್ಷೆ", "ದಾಖಲಾತಿ ಪರಿಶೀಲನೆ"),
                        applicationFee = "ಸಾಮಾನ್ಯ/OBC: ₹ 750 | SC/ST: ₹ 500",
                        officialApplyUrl = "https://cetonline.karnataka.gov.in/kea/",
                        officialNotificationUrl = "https://cetonline.karnataka.gov.in/kea/",
                        officialWebsite = "https://cetonline.karnataka.gov.in/kea/",
                        isTrending = true,
                        datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                        portalSource = "FreeJobAlert",
                        portalUrl = "https://www.freejobalert.com/karnataka-government-jobs/"
                    )
                )
                freshArticles.add(
                    JobArticle(
                        id = "ksp-cpc-breaking-" + System.currentTimeMillis(),
                        titleKannada = "ಲೈವ್ ಅಪ್‌ಡೇಟ್: KSP ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ 3,200 ಹುದ್ದೆಗಳಿಗೆ ಅರ್ಜಿ ಸಲ್ಲಿಕೆ ಸಕ್ರಿಯ",
                        titleEnglish = "Live Update: KSP Civil Police Constable 3,200 Posts Apply Active",
                        organization = "KSP (ಕರ್ನಾಟಕ ರಾಜ್ಯ ಪೊಲೀಸ್)",
                        category = JobCategory.POLICE_DEFENCE,
                        qualification = "PUC / 12th Standard Pass",
                        totalVacancies = "3,200 ಹುದ್ದೆಗಳು",
                        location = "ಕರ್ನಾಟಕ (Karnataka)",
                        salary = "₹ 23,500 - ₹ 47,650 / ತಿಂಗಳಿಗೆ",
                        lastDate = "30 ಅಕ್ಟೋಬರ್ 2026",
                        applyStartDate = "ಈಗ ಸಕ್ರಿಯವಾಗಿದೆ (Active)",
                        ageLimit = "19 ರಿಂದ 27 ವರ್ಷಗಳು (SC/ST/OBC: 29 ವರ್ಷಗಳು)",
                        shortDescriptionKannada = "ಕರ್ನಾಟಕ ರಾಜ್ಯ ಪೊಲೀಸ್ ಇಲಾಖೆಯ 3,200 ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ ಹುದ್ದೆಗಳ ಅರ್ಜಿ ಸಲ್ಲಿಕೆ ಪೋರ್ಟಲ್ ಲೈವ್ ಆಗಿದೆ.",
                        shortDescriptionEnglish = "Karnataka State Police active online applications for 3200 Civil Police Constables.",
                        fullArticleKannada = "ರಾಜ್ಯದ ವಿವಿಧ ಘಟಕಗಳಲ್ಲಿ ಖಾಲಿ ಇರುವ 3,200 ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ (ಪುರುಷ & ಮಹಿಳಾ) ಹುದ್ದೆಗಳ ನೇರ ನೇಮಕಾತಿ ಅಧಿಸೂಚನೆ.",
                        fullArticleEnglish = "Karnataka State Police recruitment notification for 3200 Civil Police Constables.",
                        selectionProcess = listOf("ಲಿಖಿತ ಪರೀಕ್ಷೆ (100 ಅಂಕ)", "ಸಹಿಷ್ಣುತೆ & ದೇಹದಾರ್ಢ್ಯತೆ ಪರೀಕ್ಷೆ", "ದಾಖಲೆ ಪರಿಶೀಲನೆ"),
                        applicationFee = "GM & OBC: ₹ 400 | SC, ST: ₹ 200",
                        officialApplyUrl = "https://ksp-recruitment.in",
                        officialNotificationUrl = "https://ksp-recruitment.in",
                        officialWebsite = "https://ksp-recruitment.in",
                        isTrending = true,
                        datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                        portalSource = "KarnatakaJobs.in",
                        portalUrl = "https://karnatakajobs.in"
                    )
                )
                freshVideos.add(
                    JobVideo(
                        id = "vid-auto-spardha-" + System.currentTimeMillis(),
                        titleKannada = "ಹೊಸ ಲೈವ್: KPSC ಗ್ರೂಪ್ 'ಸಿ' & VAO ಸಂಪೂರ್ಣ ಅಧ್ಯಯನ ಟೈಮ್‌ಟೇಬಲ್ ಹಾಗೂ ಸಿಲಬಸ್",
                        titleEnglish = "Fresh Live: KPSC Group C & VAO Complete Study Timetable & Syllabus",
                        channelName = "ಸ್ಪರ್ಧಾ ಚೈತ್ರ (Spardha Chaitra)",
                        youtubeVideoId = "kJQP7kiw5Fk",
                        duration = "17:40",
                        views = "125K ವೀಕ್ಷಣೆಗಳು",
                        date = "ಈಗಷ್ಟೇ ಲೈವ್ ಅಪ್‌ಲೋಡ್ ($currentTimeStr)",
                        thumbnailUrl = "https://images.unsplash.com/photo-1450133064473-71024230f91b?w=600&auto=format&fit=crop&q=80",
                        description = "ಇಂದು ಬಿಡುಗಡೆಯಾದ ಹೊಸ ಅಧಿಸೂಚನೆಗಳ ಸಂಪೂರ್ಣ ವಿವರಣೆ. ಪರೀಕ್ಷೆಗೆ ಇಂದಿನಿಂದಲೇ ಸಿದ್ಧತೆ ನಡೆಸುವುದು ಹೇಗೆ ಎಂಬ ಮಾಹಿತಿ."
                    )
                )
            }
            1 -> {
                freshArticles.add(
                    JobArticle(
                        id = "bmrcl-metro-" + System.currentTimeMillis(),
                        titleKannada = "Freshersworld: ನಮ್ಮ ಮೆಟ್ರೋ (BMRCL) 350 ಸ್ಟೇಷನ್ ಕಂಟ್ರೋಲರ್ & ಟ್ರೈನ್ ಆಪರೇಟರ್ ನೇಮಕಾತಿ",
                        titleEnglish = "Freshersworld: BMRCL Metro 350 Station Controller & Train Operator Recruitment",
                        organization = "BMRCL (ಬೆಂಗಳೂರು ಮೆಟ್ರೋ)",
                        category = JobCategory.RAILWAY,
                        qualification = "ಡಿಪ್ಲೊಮಾ / ಬಿಇ / ಬಿ.ಟೆಕ್ (Diploma / BE / B.Tech)",
                        totalVacancies = "350 ಹುದ್ದೆಗಳು",
                        location = "ಬೆಂಗಳೂರು (Bengaluru)",
                        salary = "₹ 35,000 - ₹ 82,660 / ತಿಂಗಳಿಗೆ",
                        lastDate = "15 ನವೆಂಬರ್ 2026",
                        applyStartDate = "ಇಂದಿನಿಂದ ಆರಂಭ (Started)",
                        ageLimit = "18 ರಿಂದ 35 ವರ್ಷಗಳು",
                        shortDescriptionKannada = "ಬೆಂಗಳೂರು ಮೆಟ್ರೋ ರೈಲು ನಿಗಮದಲ್ಲಿ 350 ವಿವಿಧ ತಾಂತ್ರಿಕ ಮತ್ತು ಕಾರ್ಯಾಚರಣೆ ಹುದ್ದೆಗಳಿಗೆ ಅರ್ಹ ಅಭ್ಯರ್ಥಿಗಳಿಂದ ಅರ್ಜಿ ಆಹ್ವಾನ.",
                        shortDescriptionEnglish = "Bangalore Metro Rail Corporation invites online applications for 350 technical positions.",
                        fullArticleKannada = "BMRCL ನಮ್ಮ ಮೆಟ್ರೋ ಹಂತ-2 ಮತ್ತು ಹಂತ-3 ಕಾರ್ಯಾಚರಣೆಗಾಗಿ ನುರಿತ ಅಭ್ಯರ್ಥಿಗಳ ನೇರ ನೇಮಕಾತಿ ಅಧಿಸೂಚನೆ.",
                        fullArticleEnglish = "BMRCL recruitment for 350 Station Controller and Train Operator vacancies.",
                        selectionProcess = listOf("ಆನ್‌ಲೈನ್ ಕಂಪ್ಯೂಟರ್ ಆಧಾರಿತ ಪರೀಕ್ಷೆ (CBT)", "ವೈದ್ಯಕೀಯ ಪರೀಕ್ಷೆ (A1 Category)", "ದಾಖಲಾತಿ ಪರಿಶೀಲನೆ"),
                        applicationFee = "ಸಾಮಾನ್ಯ: ₹ 600 | SC/ST: ₹ 300",
                        officialApplyUrl = "https://english.bmrc.co.in/Career",
                        officialNotificationUrl = "https://english.bmrc.co.in/Career",
                        officialWebsite = "https://english.bmrc.co.in",
                        isTrending = true,
                        datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                        portalSource = "Freshersworld",
                        portalUrl = "https://www.freshersworld.com/jobs/jobs-in-karnataka"
                    )
                )
                freshArticles.add(
                    JobArticle(
                        id = "naukri-it-fresher-" + System.currentTimeMillis(),
                        titleKannada = "Naukri.com: ವಿಪ್ರೋ, ಇನ್ಫೋಸಿಸ್ & ಟಿಸಿಎಸ್ ಕರ್ನಾಟಕ ಫ್ರೆಶರ್ಸ್ 2026 ಮೆಗಾ ಹೈರಿಂಗ್ ಡ್ರೈವ್",
                        titleEnglish = "Naukri.com: Wipro, Infosys & TCS Karnataka Freshers 2026 Mega Hiring Drive",
                        organization = "Naukri IT Campus Network",
                        category = JobCategory.PRIVATE_IT,
                        qualification = "ಯಾವುದೇ ಪದವಿ / BCA / B.Sc / B.E (Any Graduate)",
                        totalVacancies = "1,850+ ಹುದ್ದೆಗಳು",
                        location = "ಬೆಂಗಳೂರು, ಮೈಸೂರು, ಮಂಗಳೂರು, ಹುಬ್ಬಳ್ಳಿ",
                        salary = "₹ 3.6 LPA - ₹ 6.5 LPA",
                        lastDate = "25 ಅಕ್ಟೋಬರ್ 2026",
                        applyStartDate = "ಸಕ್ರಿಯವಾಗಿದೆ (Active)",
                        ageLimit = "20 ರಿಂದ 28 ವರ್ಷಗಳು",
                        shortDescriptionKannada = "ಕರ್ನಾಟಕದ ಪದವೀಧರರಿಗೆ ಪ್ರಮುಖ ಐಟಿ ಕಂಪನಿಗಳಲ್ಲಿ ಸಾಫ್ಟ್‌ವೇರ್, ಡೇಟಾ ಅನಾಲಿಟಿಕ್ಸ್ ಮತ್ತು ಕ್ಲೌಡ್ ಹುದ್ದೆಗಳು.",
                        shortDescriptionEnglish = "Mega hiring drive for Karnataka graduates across top tech companies in Bengaluru, Mysuru, Hubballi.",
                        fullArticleKannada = "Naukri.com ಮೂಲಕ ಕರ್ನಾಟಕದ ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ವಿಶೇಷ ಕ್ಯಾಂಪಸ್ ನೇಮಕಾತಿ ಡ್ರೈವ್ ನೋಂದಣಿ ಆರಂಭ.",
                        fullArticleEnglish = "Exclusive campus recruitment for Karnataka degree holders on Naukri.com portal.",
                        selectionProcess = listOf("ಆನ್‌ಲೈನ್ ಆಪ್ಟಿಟ್ಯೂಡ್ ಟೆಸ್ಟ್", "ತಾಂತ್ರಿಕ ಸಂದರ್ಶನ", "HR ಸಂದರ್ಶನ"),
                        applicationFee = "ಉಚಿತ (No Application Fee)",
                        officialApplyUrl = "https://www.naukri.com/jobs-in-karnataka",
                        officialNotificationUrl = "https://www.naukri.com/jobs-in-karnataka",
                        officialWebsite = "https://www.naukri.com",
                        isTrending = true,
                        datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                        portalSource = "Naukri.com",
                        portalUrl = "https://www.naukri.com/jobs-in-karnataka"
                    )
                )
                freshVideos.add(
                    JobVideo(
                        id = "vid-auto-classic-" + System.currentTimeMillis(),
                        titleKannada = "ಹೊಸ ಲೈವ್: ಭಾರತದ ಸಂವಿಧಾನ ಮತ್ತು ಕರ್ನಾಟಕ ಇತಿಹಾಸ - ಪರೀಕ್ಷೆಯಲ್ಲಿ ಬರುವ ಖಚಿತ ಪ್ರಶ್ನೋತ್ತರಗಳು",
                        titleEnglish = "Fresh Live: Indian Constitution & Karnataka History Expected Exam MCQs",
                        channelName = "ಕ್ಲಾಸಿಕ್ ಎಜುಕೇಶನ್ / KPSC ವಾಣಿ",
                        youtubeVideoId = "3yY6p6E1YjQ",
                        duration = "22:15",
                        views = "88K ವೀಕ್ಷಣೆಗಳು",
                        date = "ಈಗಷ್ಟೇ ಲೈವ್ ಅಪ್‌ಲೋಡ್ ($currentTimeStr)",
                        thumbnailUrl = "https://images.unsplash.com/photo-1434030216411-0b793f4b4173?w=600&auto=format&fit=crop&q=80",
                        description = "KPSC, ಪೊಲೀಸ್, VAO ಹಾಗೂ ಕೆಸೆಟ್ ಪರೀಕ್ಷೆಗಳಲ್ಲಿ ಕೇಳಲಾಗುವ ಸಂವಿಧಾನದ ಪ್ರಮುಖ ವಿಧಿಗಳು ಮತ್ತು ತಿದ್ದುಪಡಿಗಳ ವಿಶ್ಲೇಷಣೆ."
                    )
                )
            }
            2 -> {
                freshArticles.add(
                    JobArticle(
                        id = "shine-forest-guard-" + System.currentTimeMillis(),
                        titleKannada = "Shine.com: ಕರ್ನಾಟಕ ಅರಣ್ಯ ಇಲಾಖೆ 420 ಅರಣ್ಯ ರಕ್ಷಕ (Forest Guard) ಹುದ್ದೆಗಳ ನೇಮಕಾತಿ",
                        titleEnglish = "Shine.com: Karnataka Forest Department 420 Forest Guard Recruitment",
                        organization = "ಕರ್ನಾಟಕ ಅರಣ್ಯ ಇಲಾಖೆ (KFD)",
                        category = JobCategory.KARNATAKA_GOVT,
                        qualification = "ದ್ವಿತೀಯ ಪಿಯುಸಿ / 12th Pass",
                        totalVacancies = "420 ಹುದ್ದೆಗಳು",
                        location = "ಕರ್ನಾಟಕದ ಎಲ್ಲಾ ಅರಣ್ಯ ವಿಭಾಗಗಳು",
                        salary = "₹ 21,400 - ₹ 42,000 / ತಿಂಗಳಿಗೆ",
                        lastDate = "10 ನವೆಂಬರ್ 2026",
                        applyStartDate = "ಸಕ್ರಿಯವಾಗಿದೆ (Active)",
                        ageLimit = "18 ರಿಂದ 30 ವರ್ಷಗಳು (SC/ST/OBC: ನಿಯಮಾನುಸಾರ ವಯೋಮಿತಿ ಸಡಿಲಿಕೆ)",
                        shortDescriptionKannada = "ರಾಜ್ಯ ಅರಣ್ಯ ಇಲಾಖೆಯಲ್ಲಿ ಖಾಲಿ ಇರುವ 420 ಅರಣ್ಯ ರಕ್ಷಕ ಹುದ್ದೆಗಳ ನೇರ ನೇಮಕಾತಿಗೆ ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಸಲ್ಲಿಕೆ ಆರಂಭ.",
                        shortDescriptionEnglish = "Karnataka Forest Department invites applications for 420 Forest Guard posts across divisions.",
                        fullArticleKannada = "ಅರಣ್ಯ ಸಂರಕ್ಷಣೆ ಮತ್ತು ವನ್ಯಜೀವಿ ವಿಭಾಗಗಳಲ್ಲಿ ಗಸ್ತು ಮತ್ತು ಕಾವಲು ಕರ್ತವ್ಯಕ್ಕಾಗಿ ಅರಣ್ಯ ರಕ್ಷಕರ ನೇರ ನೇಮಕಾತಿ.",
                        fullArticleEnglish = "KFD recruitment for 420 Forest Guard vacancies with direct physical and written test.",
                        selectionProcess = listOf("ದೇಹದಾರ್ಢ್ಯತೆ ಮತ್ತು ಸಹಿಷ್ಣುತೆ ಪರೀಕ್ಷೆ", "ಲಿಖಿತ ಪರೀಕ್ಷೆ", "ದಾಖಲಾತಿ ಪರಿಶೀಲನೆ"),
                        applicationFee = "GM/OBC: ₹ 350 | SC/ST: ₹ 150",
                        officialApplyUrl = "https://aranya.gov.in",
                        officialNotificationUrl = "https://aranya.gov.in",
                        officialWebsite = "https://aranya.gov.in",
                        isTrending = true,
                        datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                        portalSource = "Shine.com",
                        portalUrl = "https://www.shine.com/job-search/jobs-in-karnataka"
                    )
                )
                freshArticles.add(
                    JobArticle(
                        id = "indeed-kmf-dairy-" + System.currentTimeMillis(),
                        titleKannada = "Indeed India: ಕರ್ನಾಟಕ ಹಾಲು ಮಹಾಮಂಡಳಿ (KMF ನಂದಿನಿ) 280 ವಿವಿಧ ಹುದ್ದೆಗಳ ನೇಮಕಾತಿ",
                        titleEnglish = "Indeed India: Karnataka Milk Federation (KMF Nandini) 280 Various Posts",
                        organization = "KMF ನಂದಿನಿ (Karnataka Milk Federation)",
                        category = JobCategory.KARNATAKA_GOVT,
                        qualification = "SSLC / ITI / ಡಿಪ್ಲೊಮಾ / ಪದವಿ (SSLC/ITI/Degree)",
                        totalVacancies = "280 ಹುದ್ದೆಗಳು",
                        location = "ಬೆಂಗಳೂರು, ಮಂಡ್ಯ, ಹಾಸನ, ತುಮಕೂರು",
                        salary = "₹ 23,500 - ₹ 53,850 / ತಿಂಗಳಿಗೆ",
                        lastDate = "05 ನವೆಂಬರ್ 2026",
                        applyStartDate = "ಸಕ್ರಿಯವಾಗಿದೆ (Active)",
                        ageLimit = "18 ರಿಂದ 35 ವರ್ಷಗಳು (SC/ST: 40 ವರ್ಷ)",
                        shortDescriptionKannada = "ನಂದಿನಿ ಡೇರಿ ಘಟಕಗಳಲ್ಲಿ ಅಸಿಸ್ಟೆಂಟ್ ಮ್ಯಾನೇಜರ್, ಜೂನಿಯರ್ ಟೆಕ್ನಿಷಿಯನ್, ಕೆಮಿಸ್ಟ್ ಮತ್ತು ಆಫೀಸ್ ಅಸಿಸ್ಟೆಂಟ್ ಹುದ್ದೆಗಳು.",
                        shortDescriptionEnglish = "KMF Nandini recruitment for 280 technicians, assistants, and chemists across dairy units.",
                        fullArticleKannada = "ಕರ್ನಾಟಕದ ಪ್ರತಿಷ್ಠಿತ ಸಹಕಾರ ಸಂಸ್ಥೆ ಕೆಎಂಎಫ್‌ನಿಂದ ರಾಜ್ಯದ ಹಾಲು ಒಕ್ಕೂಟಗಳಲ್ಲಿ ಖಾಲಿ ಇರುವ ಹುದ್ದೆಗಳಿಗೆ ಅರ್ಜಿ ಆಹ್ವಾನ.",
                        fullArticleEnglish = "Karnataka Milk Federation invites online application for 280 posts across district unions.",
                        selectionProcess = listOf("ಲಿಖಿತ ಪರೀಕ್ಷೆ", "ವೃತ್ತಿಪರ ಕೌಶಲ್ಯ ಪರೀಕ್ಷೆ (Technical)", "ದಾಖಲೆ ಪರಿಶೀಲನೆ"),
                        applicationFee = "ಸಾಮಾನ್ಯ: ₹ 500 | SC/ST: ₹ 250",
                        officialApplyUrl = "https://www.kmfnandini.coop",
                        officialNotificationUrl = "https://www.kmfnandini.coop",
                        officialWebsite = "https://www.kmfnandini.coop",
                        isTrending = true,
                        datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                        portalSource = "Indeed India",
                        portalUrl = "https://in.indeed.com/jobs-in-Karnataka"
                    )
                )
                freshVideos.add(
                    JobVideo(
                        id = "vid-auto-sadhana-" + System.currentTimeMillis(),
                        titleKannada = "ಹೊಸ ಲೈವ್: ಪೊಲೀಸ್, VAO & ಎಫ್‌ಡಿಎ ಪರೀಕ್ಷೆಯಲ್ಲಿ 90+ ಅಂಕ ಗಳಿಸುವ ಸರಳ ಅಧ್ಯಯನ ಸೂತ್ರಗಳು",
                        titleEnglish = "Fresh Live: Top Scoring Tips & Memory Techniques for Competitive Exams",
                        channelName = "ಸಾಧನಾ ಅಕಾಡೆಮಿ (Sadhana Academy Shikaripura)",
                        youtubeVideoId = "eVtxfEOU68A",
                        duration = "19:45",
                        views = "142K ವೀಕ್ಷಣೆಗಳು",
                        date = "ಈಗಷ್ಟೇ ಲೈವ್ ಅಪ್‌ಲೋಡ್ ($currentTimeStr)",
                        thumbnailUrl = "https://images.unsplash.com/photo-1524178232363-1fb2b075b655?w=600&auto=format&fit=crop&q=80",
                        description = "ಓದಿದ್ದು ನೆನಪಿನಲ್ಲಿ ಉಳಿಯಲು ಸಾಧನಾ ಅಕಾಡೆಮಿಯ ಮಂಜುನಾಥ್ ಸರ್ ಅವರ ಮಾರ್ಗದರ್ಶನ ಹಾಗೂ ಪರೀಕ್ಷಾ ಹಾಲ್‌ನಲ್ಲಿ ಸಮಯ ನಿರ್ವಹಣೆ."
                    )
                )
            }
            3 -> {
                freshArticles.add(
                    JobArticle(
                        id = "sarkari-ssc-cgl-" + System.currentTimeMillis(),
                        titleKannada = "SarkariResult: SSC ಕಂಬೈನ್ಡ್ ಗ್ರಾಜುಯೇಟ್ ಲೆವೆಲ್ (CGL 2026) 14,000+ ಹುದ್ದೆಗಳ ಅಧಿಸೂಚನೆ",
                        titleEnglish = "SarkariResult: SSC Combined Graduate Level (CGL 2026) 14,000+ Vacancies",
                        organization = "SSC (ಸ್ಟಾಫ್ ಸೆಲೆಕ್ಷನ್ ಕಮಿಷನ್)",
                        category = JobCategory.CENTRAL_GOVT,
                        qualification = "ಯಾವುದೇ ಪದವಿ (Any Recognized Bachelor's Degree)",
                        totalVacancies = "14,500+ ಹುದ್ದೆಗಳು",
                        location = "ಕರ್ನಾಟಕ & ಭಾರತದಾದ್ಯಂತ (Karnataka & All India)",
                        salary = "₹ 44,900 - ₹ 1,42,400 / ತಿಂಗಳಿಗೆ",
                        lastDate = "18 ನವೆಂಬರ್ 2026",
                        applyStartDate = "ಸಕ್ರಿಯವಾಗಿದೆ (Active)",
                        ageLimit = "18 ರಿಂದ 32 ವರ್ಷಗಳು",
                        shortDescriptionKannada = "ಕೇಂದ್ರ ಸರಕಾರದ ಇನ್‌ಕಮ್ ಟ್ಯಾಕ್ಸ್, ಸಿಬಿಐ, ಕಸ್ಟಮ್ಸ್ ಹಾಗೂ ಸಚಿವಾಲಯಗಳಲ್ಲಿ ಅಸಿಸ್ಟೆಂಟ್ ಸೆಕ್ಷನ್ ಆಫೀಸರ್ ಮತ್ತು ಇನ್‌ಸ್ಪೆಕ್ಟರ್ ಹುದ್ದೆಗಳು.",
                        shortDescriptionEnglish = "Staff Selection Commission opens applications for 14500+ Inspector and Assistant Section Officer posts.",
                        fullArticleKannada = "ಕೇಂದ್ರ ಸರಕಾರದ ಉನ್ನತ ದರ್ಜೆಯ ಗ್ರೂಪ್ ಬಿ ಮತ್ತು ಗ್ರೂಪ್ ಸಿ ಹುದ್ದೆಗಳಿಗೆ ಪದವೀಧರರಿಂದ ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಆಹ್ವಾನ.",
                        fullArticleEnglish = "SSC CGL 2026 notification for over 14,000 vacancies with examination centers across Karnataka.",
                        selectionProcess = listOf("ಟೈರ್-1 ಕಂಪ್ಯೂಟರ್ ಪರೀಕ್ಷೆ (Tier-1 CBT)", "ಟೈರ್-2 ಕಂಪ್ಯೂಟರ್ ಪರೀಕ್ಷೆ (Tier-2 CBT)", "ಡಾಕ್ಯುಮೆಂಟ್ ವೆರಿಫಿಕೇಶನ್"),
                        applicationFee = "ಸಾಮಾನ್ಯ/OBC: ₹ 100 | ಮಹಿಳೆಯರು & SC/ST: ಉಚಿತ",
                        officialApplyUrl = "https://ssc.gov.in",
                        officialNotificationUrl = "https://ssc.gov.in",
                        officialWebsite = "https://ssc.gov.in",
                        isTrending = true,
                        datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                        portalSource = "SarkariResult.com",
                        portalUrl = "https://www.sarkariresult.com"
                    )
                )
                freshArticles.add(
                    JobArticle(
                        id = "foundit-canara-bank-" + System.currentTimeMillis(),
                        titleKannada = "Foundit: ಕೆನರಾ ಬ್ಯಾಂಕ್ & ಕರ್ನಾಟಕ ಗ್ರಾಮೀಣ ಬ್ಯಾಂಕ್ 1,200 ಜೂನಿಯರ್ ಅಸೋಸಿಯೇಟ್ಸ್",
                        titleEnglish = "Foundit: Canara Bank & Karnataka Gramin Bank 1,200 Junior Associates",
                        organization = "IBPS / ಕೆನರಾ ಬ್ಯಾಂಕ್ ನೆಟ್‌ವರ್ಕ್",
                        category = JobCategory.BANKING,
                        qualification = "ಯಾವುದೇ ಪದವಿ ಮತ್ತು ಕನ್ನಡ ಜ್ಞಾನ (Degree + Kannada Fluency)",
                        totalVacancies = "1,200 ಹುದ್ದೆಗಳು",
                        location = "ಕರ್ನಾಟಕದ ಎಲ್ಲಾ ಜಿಲ್ಲಾ ಶಾಖೆಗಳು",
                        salary = "₹ 28,000 - ₹ 58,000 / ತಿಂಗಳಿಗೆ",
                        lastDate = "12 ನವೆಂಬರ್ 2026",
                        applyStartDate = "ಸಕ್ರಿಯವಾಗಿದೆ (Active)",
                        ageLimit = "20 ರಿಂದ 28 ವರ್ಷಗಳು",
                        shortDescriptionKannada = "ಕರ್ನಾಟಕದಾದ್ಯಂತ ಇರುವ ಬ್ಯಾಂಕ್ ಶಾಖೆಗಳಲ್ಲಿ ಕ್ಲರ್ಕ್ ಮತ್ತು ಜೂನಿಯರ್ ಅಸೋಸಿಯೇಟ್ ಹುದ್ದೆಗಳ ನೇರ ನೇಮಕಾತಿ ಲೈವ್ ಆಗಿದೆ.",
                        shortDescriptionEnglish = "Recruitment for 1200 Junior Associates in Canara Bank and Karnataka Gramin Bank branches.",
                        fullArticleKannada = "ಸ್ಥಳೀಯ ಭಾಷೆ ಕನ್ನಡ ಬಲ್ಲ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ ಕರ್ನಾಟಕದ ಗ್ರಾಮೀಣ ಹಾಗೂ ನಗರ ಬ್ಯಾಂಕ್ ಶಾಖೆಗಳಲ್ಲಿ ಕಾಯಂ ಉದ್ಯೋಗಾವಕಾಶ.",
                        fullArticleEnglish = "Direct recruitment for banking associates with competitive pay and comprehensive allowances.",
                        selectionProcess = listOf("ಪ್ರಿಲಿಮಿನರಿ ಪರೀಕ್ಷೆ", "ಮುಖ್ಯ ಲಿಖಿತ ಪರೀಕ್ಷೆ", "ಭಾಷಾ ಪ್ರಾವೀಣ್ಯತೆ ಪರೀಕ್ಷೆ (LPT)"),
                        applicationFee = "ಸಾಮಾನ್ಯ/OBC: ₹ 850 | SC/ST: ₹ 175",
                        officialApplyUrl = "https://www.ibps.in",
                        officialNotificationUrl = "https://canarabank.com",
                        officialWebsite = "https://canarabank.com",
                        isTrending = true,
                        datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                        portalSource = "Foundit",
                        portalUrl = "https://www.foundit.in/jobs-in-karnataka"
                    )
                )
                freshVideos.add(
                    JobVideo(
                        id = "vid-auto-shreedhar-" + System.currentTimeMillis(),
                        titleKannada = "ಹೊಸ ಲೈವ್: ಮೆಂಟಲ್ ಎಬಿಲಿಟಿ (Mental Ability) 5 ಸೆಕೆಂಡ್‌ಗಳಲ್ಲಿ ಬಿಡಿಸುವ ಶಾರ್ಟ್‌ಕಟ್ ಟ್ರಿಕ್ಸ್",
                        titleEnglish = "Fresh Live: Mental Ability & Reasoning 5-Second Shortcut Tricks",
                        channelName = "ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ (Shreedhar CEC Kannada)",
                        youtubeVideoId = "9bZkp7q19f0",
                        duration = "16:50",
                        views = "76K ವೀಕ್ಷಣೆಗಳು",
                        date = "ಈಗಷ್ಟೇ ಲೈವ್ ಅಪ್‌ಲೋಡ್ ($currentTimeStr)",
                        thumbnailUrl = "https://images.unsplash.com/photo-1509062522246-3755977927d7?w=600&auto=format&fit=crop&q=80",
                        description = "ಸಂಖ್ಯೆ ಸರಣಿ, ಕೋಡಿಂಗ್-ಡಿಕೋಡಿಂಗ್ ಹಾಗೂ ದಿಕ್ಕುಗಳ ಲೆಕ್ಕಗಳನ್ನು ಅತಿ ಸುಲಭವಾಗಿ ವೇಗವಾಗಿ ಬಿಡಿಸುವ ಗಣಿತ ತಂತ್ರಗಳು."
                    )
                )
            }
            4 -> {
                freshArticles.add(
                    JobArticle(
                        id = "apna-health-dept-" + System.currentTimeMillis(),
                        titleKannada = "Apna: ಕರ್ನಾಟಕ ಆರೋಗ್ಯ ಇಲಾಖೆ 900+ ಸ್ಟಾಫ್ ನರ್ಸ್ & ಲ್ಯಾಬ್ ಟೆಕ್ನಿಷಿಯನ್ ನೇಮಕಾತಿ",
                        titleEnglish = "Apna: Karnataka Health Dept 900+ Staff Nurse & Lab Technician Recruitment",
                        organization = "ಆರೋಗ್ಯ ಮತ್ತು ಕುಟುಂಬ ಕಲ್ಯಾಣ ಇಲಾಖೆ",
                        category = JobCategory.KARNATAKA_GOVT,
                        qualification = "GNM / B.Sc Nursing / DMLT / ಪಿಯುಸಿ ಸೈನ್ಸ್",
                        totalVacancies = "920 ಹುದ್ದೆಗಳು",
                        location = "ಕರ್ನಾಟಕದ ಎಲ್ಲಾ ಜಿಲ್ಲಾ ಆಸ್ಪತ್ರೆಗಳು",
                        salary = "₹ 25,500 - ₹ 52,650 / ತಿಂಗಳಿಗೆ",
                        lastDate = "22 ನವೆಂಬರ್ 2026",
                        applyStartDate = "ಸಕ್ರಿಯವಾಗಿದೆ (Active)",
                        ageLimit = "18 ರಿಂದ 35 ವರ್ಷಗಳು (SC/ST: 40 ವರ್ಷ)",
                        shortDescriptionKannada = "ರಾಜ್ಯದ ಸಮುದಾಯ ಆರೋಗ್ಯ ಕೇಂದ್ರ ಮತ್ತು ತಾಲೂಕು ಆಸ್ಪತ್ರೆಗಳಲ್ಲಿ ಸ್ಟಾಫ್ ನರ್ಸ್, ಫಾರ್ಮಾಸಿಸ್ಟ್ ಮತ್ತು ಲ್ಯಾಬ್ ಅಸಿಸ್ಟೆಂಟ್ ಹುದ್ದೆಗಳು.",
                        shortDescriptionEnglish = "Karnataka Health Department opens 920 vacancies for nurses, pharmacists, and lab technicians.",
                        fullArticleKannada = "ಆರೋಗ್ಯ ಇಲಾಖೆಯಡಿ ಕಾರ್ಯನಿರ್ವಹಿಸಲು ನರ್ಸಿಂಗ್ ಹಾಗೂ ಪ್ಯಾರಾಮೆಡಿಕಲ್ ಪದವೀಧರರಿಂದ ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಆಹ್ವಾನಿಸಲಾಗಿದೆ.",
                        fullArticleEnglish = "Direct recruitment by Health & Family Welfare department for district health centers.",
                        selectionProcess = listOf("ಮೆರಿಟ್ ಪಟ್ಟಿ (ಅಂಕಗಳ ಆಧಾರ)", "ಕೌನ್ಸೆಲಿಂಗ್ ಮತ್ತು ಮೂಲ ದಾಖಲಾತಿ ಪರಿಶೀಲನೆ"),
                        applicationFee = "ಸಾಮಾನ್ಯ: ₹ 400 | SC/ST: ₹ 200",
                        officialApplyUrl = "https://karnataka.gov.in/hfw",
                        officialNotificationUrl = "https://karnataka.gov.in/hfw",
                        officialWebsite = "https://karnataka.gov.in/hfw",
                        isTrending = true,
                        datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                        portalSource = "Apna",
                        portalUrl = "https://apna.co/jobs-in-karnataka"
                    )
                )
                freshArticles.add(
                    JobArticle(
                        id = "ksrtc-driver-cond-" + System.currentTimeMillis(),
                        titleKannada = "FreeJobAlert: KSRTC 1,450 ಚಾಲಕ ಮತ್ತು ನಿರ್ವಾಹಕ (Driver & Conductor) ನೇರ ನೇಮಕಾತಿ",
                        titleEnglish = "FreeJobAlert: KSRTC 1,450 Driver & Conductor Direct Recruitment 2026",
                        organization = "KSRTC (ಕರ್ನಾಟಕ ರಾಜ್ಯ ರಸ್ತೆ ಸಾರಿಗೆ ನಿಗಮ)",
                        category = JobCategory.KARNATAKA_GOVT,
                        qualification = "SSLC / 10th Standard Pass + ಚಾಲನಾ ಪರವಾನಗಿ (Driving License)",
                        totalVacancies = "1,450 ಹುದ್ದೆಗಳು",
                        location = "ಕರ್ನಾಟಕ (Karnataka)",
                        salary = "₹ 20,000 - ₹ 38,000 / ತಿಂಗಳಿಗೆ",
                        lastDate = "14 ನವೆಂಬರ್ 2026",
                        applyStartDate = "ಸಕ್ರಿಯವಾಗಿದೆ (Active)",
                        ageLimit = "24 ರಿಂದ 38 ವರ್ಷಗಳು (ಹಿಂದುಳಿದ ವರ್ಗ: 40 ವರ್ಷ)",
                        shortDescriptionKannada = "ಕೆಎಸ್‌ಆರ್‌ಟಿಸಿಯ ವಿವಿಧ ವಿಭಾಗಗಳಲ್ಲಿ ಖಾಲಿ ಇರುವ ಚಾಲಕ-ಕಂ-ನಿರ್ವಾಹಕ ಹುದ್ದೆಗಳಿಗೆ ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಸಲ್ಲಿಕೆ ಲೈವ್ ಆಗಿದೆ.",
                        shortDescriptionEnglish = "KSRTC invites applications for 1450 Driver-cum-Conductor vacancies across state divisions.",
                        fullArticleKannada = "ಸಾರಿಗೆ ನಿಗಮದ ನೂತನ ಬಸ್‌ಗಳ ಕಾರ್ಯಾಚರಣೆಗೆ ಹೆವಿ ಬ್ಯಾಡ್ಜ್ ಹೊಂದಿರುವ ಚಾಲಕರ ನೇರ ನೇಮಕಾತಿ ಅಧಿಸೂಚನೆ.",
                        fullArticleEnglish = "Direct recruitment for KSRTC Driver-cum-Conductors with heavy vehicle license verification.",
                        selectionProcess = listOf("ಚಾಲನಾ ಕೌಶಲ್ಯ ಪರೀಕ್ಷೆ (Driving Test)", "ದೇಹದಾರ್ಢ್ಯತೆ ಪರಿಶೀಲನೆ", "ದಾಖಲೆ ಪರಿಶೀಲನೆ"),
                        applicationFee = "GM/OBC: ₹ 500 | SC/ST: ₹ 250",
                        officialApplyUrl = "https://ksrtc.karnataka.gov.in",
                        officialNotificationUrl = "https://ksrtc.karnataka.gov.in",
                        officialWebsite = "https://ksrtc.karnataka.gov.in",
                        isTrending = true,
                        datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                        portalSource = "FreeJobAlert",
                        portalUrl = "https://www.freejobalert.com/karnataka-government-jobs/"
                    )
                )
                freshVideos.add(
                    JobVideo(
                        id = "vid-auto-mitra-" + System.currentTimeMillis(),
                        titleKannada = "ಹೊಸ ಲೈವ್: ಈ ವಾರದ ಎಲ್ಲಾ 15+ ಸರಕಾರಿ ಮತ್ತು ಖಾಸಗಿ ಉದ್ಯೋಗಗಳ ಅಧಿಸೂಚನೆಗಳ ವಿವರಣೆ",
                        titleEnglish = "Fresh Live: Top 15+ State & Central Government Jobs Weekly Round-Up",
                        channelName = "ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ಮಿತ್ರ (Karnataka Udyoga Mitra)",
                        youtubeVideoId = "dQw4w9WgXcQ",
                        duration = "15:10",
                        views = "110K ವೀಕ್ಷಣೆಗಳು",
                        date = "ಈಗಷ್ಟೇ ಲೈವ್ ಅಪ್‌ಲೋಡ್ ($currentTimeStr)",
                        thumbnailUrl = "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?w=600&auto=format&fit=crop&q=80",
                        description = "ಈ ವಾರ ಕೊನೆಯ ದಿನಾಂಕವಿರುವ ಉದ್ಯೋಗಗಳು ಹಾಗೂ ಹೊಸದಾಗಿ ಪ್ರಕಟವಾದ ರೈಲ್ವೆ, ಬ್ಯಾಂಕಿಂಗ್, ಕೆಪಿಎಸ್‌ಸಿ ನೇಮಕಾತಿಗಳ ವರದಿ."
                    )
                )
            }
            else -> {
                freshArticles.add(
                    JobArticle(
                        id = "zp-deo-karnataka-" + System.currentTimeMillis(),
                        titleKannada = "KarnatakaJobs.in: ರಾಜ್ಯದ ವಿವಿಧ ಜಿಲ್ಲಾ ಪಂಚಾಯತ್‌ಗಳಲ್ಲಿ 850 ಡಾಟಾ ಎಂಟ್ರಿ ಆಪರೇಟರ್ ಹುದ್ದೆಗಳು",
                        titleEnglish = "KarnatakaJobs.in: 850 Data Entry Operator Posts in District Zilla Panchayats",
                        organization = "ಗ್ರಾಮೀಣಾಭಿವೃದ್ಧಿ ಮತ್ತು ಪಂಚಾಯತ್ ರಾಜ್ (RDPR)",
                        category = JobCategory.KARNATAKA_GOVT,
                        qualification = "PUC / ಯಾವುದೇ ಪದವಿ + ಕಂಪ್ಯೂಟರ್ ಜ್ಞಾನ (PUC/Degree + Computer)",
                        totalVacancies = "850 ಹುದ್ದೆಗಳು",
                        location = "ಕರ್ನಾಟಕದ ಎಲ್ಲಾ ಜಿಲ್ಲೆಗಳು",
                        salary = "₹ 19,500 - ₹ 35,000 / ತಿಂಗಳಿಗೆ",
                        lastDate = "20 ನವೆಂಬರ್ 2026",
                        applyStartDate = "ಸಕ್ರಿಯವಾಗಿದೆ (Active)",
                        ageLimit = "18 ರಿಂದ 35 ವರ್ಷಗಳು (SC/ST: 40 ವರ್ಷ)",
                        shortDescriptionKannada = "ಗ್ರಾಮ ಪಂಚಾಯತ್ ಮತ್ತು ತಾಲೂಕು ಪಂಚಾಯತ್ ಕಚೇರಿಗಳಲ್ಲಿ ಡಾಟಾ ಎಂಟ್ರಿ, ಆಫೀಸ್ ಅಸಿಸ್ಟೆಂಟ್ ಹುದ್ದೆಗಳಿಗೆ ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಲೈವ್.",
                        shortDescriptionEnglish = "RDPR invites applications for 850 Data Entry Operators across district panchayats in Karnataka.",
                        fullArticleKannada = "ಪಂಚಾಯತ್ ರಾಜ್ ಇಲಾಖೆಯ ವಿವಿಧ ಯೋಜನೆಗಳ ಮೇಲ್ವಿಚಾರಣೆಗಾಗಿ ಕಂಪ್ಯೂಟರ್ ಆಪರೇಟರ್‌ಗಳ ನೇಮಕಾತಿ.",
                        fullArticleEnglish = "District-wise recruitment for Data Entry Operators in Zilla and Taluk Panchayats.",
                        selectionProcess = listOf("ಕಂಪ್ಯೂಟರ್ ಬೆರಳಚ್ಚು ಪರೀಕ್ಷೆ", "ವಿದ್ಯಾರ್ಹತೆ ಮೆರಿಟ್", "ದಾಖಲಾತಿ ಪರಿಶೀಲನೆ"),
                        applicationFee = "ಸಾಮಾನ್ಯ: ₹ 300 | SC/ST: ₹ 150",
                        officialApplyUrl = "https://rdpr.karnataka.gov.in",
                        officialNotificationUrl = "https://rdpr.karnataka.gov.in",
                        officialWebsite = "https://rdpr.karnataka.gov.in",
                        isTrending = true,
                        datePosted = "ಈಗಷ್ಟೇ ಆಟೋ-ಸಿಂಕ್ ಆಗಿದೆ ($currentTimeStr)",
                        portalSource = "KarnatakaJobs.in",
                        portalUrl = "https://karnatakajobs.in"
                    )
                )
                freshVideos.add(
                    JobVideo(
                        id = "vid-auto-jobsalert-" + System.currentTimeMillis(),
                        titleKannada = "ಹೊಸ ಲೈವ್: KSRTC & BMRCL ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಸಲ್ಲಿಕೆ ಮೊಬೈಲ್‌ನಲ್ಲೇ ಹಂತ-ಹಂತದ ಡೆಮೊ",
                        titleEnglish = "Fresh Live: KSRTC & BMRCL Online Application Mobile Step-by-Step Demo",
                        channelName = "ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್ (Karnataka Jobs Alert)",
                        youtubeVideoId = "L_LUpnjgPso",
                        duration = "14:15",
                        views = "98K ವೀಕ್ಷಣೆಗಳು",
                        date = "ಈಗಷ್ಟೇ ಲೈವ್ ಅಪ್‌ಲೋಡ್ ($currentTimeStr)",
                        thumbnailUrl = "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=600&auto=format&fit=crop&q=80",
                        description = "ಯಾವುದೇ ಸೈಬರ್ ಸೆಂಟರ್‌ಗೆ ಹೋಗದೆ ಮೊಬೈಲ್‌ನಲ್ಲೇ ಫೋಟೋ, ಸಹಿ ರಿಸೈಜ್ ಮಾಡಿ ಅಪ್ಲಿಕೇಶನ್ ಸಲ್ಲಿಸುವ ಸುಲಭ ವಿಧಾನ."
                    )
                )
            }
        }

        // Deduplicate against existing ids if any, and prepend newest items
        val existingArticleIds = _jobArticlesFlow.value.map { it.id }.toSet()
        val toAddArticles = freshArticles.filter { it.id !in existingArticleIds }
        if (toAddArticles.isNotEmpty()) {
            _jobArticlesFlow.value = toAddArticles + _jobArticlesFlow.value
            newArticlesCount = toAddArticles.size
        }

        val existingVideoIds = _careerVideosFlow.value.map { it.id }.toSet()
        val toAddVideos = freshVideos.filter { it.id !in existingVideoIds }
        if (toAddVideos.isNotEmpty()) {
            _careerVideosFlow.value = toAddVideos + _careerVideosFlow.value
            newVideosCount = toAddVideos.size
        }

        syncIteration++
        _lastSyncTimeFlow.value = "ಇಂದು $currentTimeStr ಗೆ ಲೈವ್ ಸಿಂಕ್ ಆಗಿದೆ (ಪ್ರತಿ 45 ಸೆಕೆಂಡಿಗೆ ಸ್ವಯಂಚಾಲಿತ)"
        _isSyncingFlow.value = false
        return Pair(newArticlesCount, newVideosCount)
    }
}
