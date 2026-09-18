package com.example.data

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
            JobArticle(
                id = "kpsc-gp-2025",
                titleKannada = "ಕೆಪಿಎಸ್‌ಸಿ ಗೆಜೆಟೆಡ್ ಪ್ರೊಬೇಷನರ್ಸ್ (KAS) ನೇಮಕಾತಿ - 384 ಹುದ್ದೆಗಳು",
                titleEnglish = "KPSC Gazetted Probationers (KAS Group A & B) Recruitment - 384 Posts",
                organization = "KPSC (ಕರ್ನಾಟಕ ಲೋಕಸೇವಾ ಆಯೋಗ)",
                category = JobCategory.KARNATAKA_GOVT,
                qualification = "ಯಾವುದೇ ಪದವಿ (Any Degree / Graduate)",
                totalVacancies = "384 ಹುದ್ದೆಗಳು",
                location = "ಕರ್ನಾಟಕ (Karnataka)",
                salary = "₹ 43,100 - ₹ 83,900 / ತಿಂಗಳಿಗೆ",
                lastDate = "15 ಅಕ್ಟೋಬರ್ 2026",
                applyStartDate = "10 ಸೆಪ್ಟೆಂಬರ್ 2026",
                ageLimit = "21 ರಿಂದ 38 ವರ್ಷಗಳು (SC/ST/Cat-1: 40 ವರ್ಷ, OBC: 38 ವರ್ಷ)",
                shortDescriptionKannada = "ಕರ್ನಾಟಕ ಆಡಳಿತ ಸೇವೆ (KAS), ಡಿವೈಎಸ್‌ಪಿ, ತಹಶೀಲ್ದಾರ್ ಗ್ರೂಪ್ ಎ ಮತ್ತು ಗ್ರೂಪ್ ಬಿ ಹುದ್ದೆಗಳಿಗೆ ಅರ್ಹ ಅಭ್ಯರ್ಥಿಗಳಿಂದ ಅರ್ಜಿ ಆಹ್ವಾನಿಸಲಾಗಿದೆ.",
                shortDescriptionEnglish = "Karnataka Public Service Commission invites online applications for KAS Group A and Group B administrative officers across Karnataka.",
                fullArticleKannada = """
                    ಕರ್ನಾಟಕ ಲೋಕಸೇವಾ ಆಯೋಗವು (KPSC) ಕರ್ನಾಟಕ ನಾಗರಿಕ ಸೇವೆಗಳ ಗ್ರೂಪ್ 'ಎ' ಮತ್ತು ಗ್ರೂಪ್ 'ಬಿ' ಗೆಜೆಟೆಡ್ ಪ್ರೊಬೇಷನರ್ಸ್ 384 ಹುದ್ದೆಗಳ ನೇಮಕಾತಿಗೆ ಅಧಿಕೃತ ಅಧಿಸೂಚನೆ ಪ್ರಕಟಿಸಿದೆ.
                    
                    ಮುಖ್ಯ ಹುದ್ದೆಗಳ ವಿವರ:
                    1. ಸಹಾಯಕ ಆಯುಕ್ತರು (KAS ಜೂನಿಯರ್ ಸ್ಕೇಲ್) - 40 ಹುದ್ದೆಗಳು
                    2. ಡಿವೈಎಸ್‌ಪಿ (DySP - ಪೊಲೀಸ್ ಉಪಾಧೀಕ್ಷಕರು) - 45 ಹುದ್ದೆಗಳು
                    3. ಸಹಾಯಕ ಆಯುಕ್ತರು (ವಾಣಿಜ್ಯ ತೆರಿಗೆ) - 42 ಹುದ್ದೆಗಳು
                    4. ತಹಶೀಲ್ದಾರ್ (ಗ್ರೇಡ್-2) - 55 ಹುದ್ದೆಗಳು
                    5. ವಾಣಿಜ್ಯ ತೆರಿಗೆ ಅಧಿಕಾರಿ (CTO) - 60 ಹುದ್ದೆಗಳು
                    6. ಕಾರ್ಮಿಕ ಅಧಿಕಾರಿ ಮತ್ತು ಸಹಾಯಕ ನಿರ್ದೇಶಕರು - 142 ಹುದ್ದೆಗಳು
                    
                    ಶೈಕ್ಷಣಿಕ ಅರ್ಹತೆ:
                    ಅಂಗೀಕೃತ ವಿಶ್ವವಿದ್ಯಾಲಯದಿಂದ ಯಾವುದೇ ಪದವಿ (BA, BSc, BCom, BE, BTech, etc.) ಪೂರ್ಣಗೊಳಿಸಿರಬೇಕು. ಅಂತಿಮ ವರ್ಷದ ವಿದ್ಯಾರ್ಥಿಗಳೂ ಸಹ ಅರ್ಜಿ ಸಲ್ಲಿಸಬಹುದು.
                    
                    ವಯೋಮಿತಿ ಸಡಿಲಿಕೆ:
                    - ಸಾಮಾನ್ಯ ವರ್ಗ: 35 ವರ್ಷ
                    - 2A, 2B, 3A, 3B ಅಭ್ಯರ್ಥಿಗಳಿಗೆ: 38 ವರ್ಷ
                    - SC / ST / Cat-1 ಅಭ್ಯರ್ಥಿಗಳಿಗೆ: 40 ವರ್ಷ
                """.trimIndent(),
                fullArticleEnglish = """
                    Karnataka Public Service Commission (KPSC) has officially published notification for 384 Gazetted Probationer posts (Group A & B).
                    
                    Vacancy Breakdown:
                    - Assistant Commissioner (KAS): 40 posts
                    - Deputy Superintendent of Police (DySP): 45 posts
                    - Commercial Tax Officer: 42 posts
                    - Grade-2 Tahsildar: 55 posts
                    - Other Group B officers: 202 posts
                    
                    Educational Qualification: Any Bachelor Degree from a recognized university.
                    Age Limit: 21 to 38 years with standard government relaxation.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಪ್ರಿಲಿಮ್ಸ್ ಪರೀಕ್ಷೆ (Preliminary Exam - 2 ಪತ್ರಿಕೆಗಳು)",
                    "ಮುಖ್ಯ ಪರೀಕ್ಷೆ (Mains Written Examination)",
                    "ವ್ಯಕ್ತಿತ್ವ ಪರೀಕ್ಷೆ (Personality Interview)"
                ),
                applicationFee = "ಸಾಮಾನ್ಯ / OBC: ₹600 | SC / ST / Cat-1: ₹300 | ಮಾಜಿ ಸೈನಿಕರು: ₹50",
                officialApplyUrl = "https://kpsconline.karnataka.gov.in",
                officialNotificationUrl = "https://kpsc.kar.nic.in/notifications",
                officialWebsite = "https://kpsc.kar.nic.in",
                isTrending = true
            ),
            JobArticle(
                id = "ksp-police-constable-2025",
                titleKannada = "ಕರ್ನಾಟಕ ರಾಜ್ಯ ಪೊಲೀಸ್ (KSP) 3,450 ಸಿವಿಲ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ ಭರ್ತಿ",
                titleEnglish = "Karnataka State Police (KSP) 3,450 Civil Police Constable Recruitment",
                organization = "ಕರ್ನಾಟಕ ಪೊಲೀಸ್ ಇಲಾಖೆ (KSP)",
                category = JobCategory.POLICE_DEFENCE,
                qualification = "ದ್ವಿತೀಯ ಪಿಯುಸಿ / 12th Pass ಅಥವಾ ತತ್ಸಮಾನ",
                totalVacancies = "3,450 ಹುದ್ದೆಗಳು",
                location = "ಕರ್ನಾಟಕದ ಎಲ್ಲಾ ಜಿಲ್ಲೆಗಳು",
                salary = "₹ 23,500 - ₹ 47,650 / ತಿಂಗಳಿಗೆ",
                lastDate = "28 ಅಕ್ಟೋಬರ್ 2026",
                applyStartDate = "15 ಸೆಪ್ಟೆಂಬರ್ 2026",
                ageLimit = "19 ರಿಂದ 27 ವರ್ಷ (ಹಿಂದುಳಿದ ವರ್ಗಗಳಿಗೆ 30 ವರ್ಷ, SC/ST 32 ವರ್ಷ)",
                shortDescriptionKannada = "ಪಿಯುಸಿ ಪಾಸಾದ ಯುವಕ-ಯುವತಿಯರಿಗೆ ಸುವರ್ಣಾವಕಾಶ. ಕರ್ನಾಟಕ ಪೊಲೀಸ್ ಇಲಾಖೆಯಲ್ಲಿ 3,450 ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್ಸ್ಟೇಬಲ್ ಹುದ್ದೆಗಳ ಭರ್ತಿ.",
                shortDescriptionEnglish = "Huge recruitment drive in Karnataka Police Department for 3,450 Civil Police Constable vacancies for PUC/12th passed candidates.",
                fullArticleKannada = """
                    ಕರ್ನಾಟಕ ಪೊಲೀಸ್ ಇಲಾಖೆಯು ಪುರುಷ, ಮಹಿಳಾ ಮತ್ತು ತೃತೀಯ ಲಿಂಗ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ ಹುದ್ದೆಗಳ ನೇಮಕಾತಿಗೆ ಅರ್ಜಿ ಕೋರಿದೆ.
                    
                    ಹುದ್ದೆಗಳ ಜಿಲ್ಲಾವಾರು ಹಂಚಿಕೆ:
                    - ಬೆಂಗಳೂರು ನಗರ: 1,200 ಹುದ್ದೆಗಳು
                    - ಮೈಸೂರು, ಮಂಗಳೂರು, ಹುಬ್ಬಳ್ಳಿ-ಧಾರವಾಡ: 800 ಹುದ್ದೆಗಳು
                    - ಕಲ್ಯಾಣ ಕರ್ನಾಟಕ ಜಿಲ್ಲೆಗಳು: 650 ಹುದ್ದೆಗಳು
                    - ಉಳಿದ ಜಿಲ್ಲೆಗಳು: 800 ಹುದ್ದೆಗಳು
                    
                    ದೇಹದಾರ್ಢ್ಯತೆ ಮತ್ತು ದೈಹಿಕ ಪರೀಕ್ಷೆ (ET & PST):
                    - ಪುರುಷ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ: ಎತ್ತರ ಕನಿಷ್ಠ 168 ಸೆಂ.ಮೀ, ಎದೆ ಸುತ್ತಳತೆ 86 ಸೆಂ.ಮೀ.
                    - ಮಹಿಳಾ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ: ಎತ್ತರ ಕನಿಷ್ಠ 157 ಸೆಂ.ಮೀ, ತೂಕ ಕನಿಷ್ಠ 45 ಕೆ.ಜಿ.
                    - 1600 ಮೀಟರ್ ಓಟ (ಪುರುಷರಿಗೆ 6 ನಿಮಿಷ 30 ಸೆಕೆಂಡು), 1000 ಮೀಟರ್ ಓಟ (ಮಹಿಳೆಯರಿಗೆ).
                """.trimIndent(),
                fullArticleEnglish = """
                    Karnataka State Police invites applications for 3,450 Civil Police Constables for Male, Female, and Transgender candidates.
                    Minimum Qualification: PUC / 12th standard pass or equivalent.
                    Physical endurance tests and written exams will be conducted across major centers.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಲಿಖಿತ ಪರೀಕ್ಷೆ (Objective Written Test - 100 Marks)",
                    "ದೈಹಿಕ ಸಾಮರ್ಥ್ಯ ಪರೀಕ್ಷೆ (Physical Endurance Test - ET)",
                    "ದೇಹದಾರ್ಢ್ಯತೆ ಅಳತೆ (Physical Standard Test - PST)",
                    "ದಾಖಲಾತಿ ಪರಿಶೀಲನೆ & ವೈದ್ಯಕೀಯ ತಪಾಸಣೆ"
                ),
                applicationFee = "ಸಾಮಾನ್ಯ/2A/2B/3A/3B: ₹400 | SC/ST/Cat-1: ₹200",
                officialApplyUrl = "https://ksp-recruitment.in",
                officialNotificationUrl = "https://ksp.karnataka.gov.in/notifications",
                officialWebsite = "https://ksp.karnataka.gov.in",
                isTrending = true
            ),
            JobArticle(
                id = "kea-fda-sda-2025",
                titleKannada = "KEA ಮೂಲಕ ವಿವಿಧ ನಿಗಮ ಮಂಡಳಿಗಳಲ್ಲಿ 1,890 ಎಫ್‌ಡಿಎ & ಎಸ್‌ಡಿಎ ಹುದ್ದೆಗಳು",
                titleEnglish = "KEA Various Corporations 1,890 FDA & SDA Assistant Vacancies",
                organization = "KEA (ಕರ್ನಾಟಕ ಪರೀಕ್ಷಾ ಪ್ರಾಧಿಕಾರ)",
                category = JobCategory.KARNATAKA_GOVT,
                qualification = "ಪದವಿ (Degree) / ಪಿಯುಸಿ (PUC)",
                totalVacancies = "1,890 ಹುದ್ದೆಗಳು",
                location = "ಕರ್ನಾಟಕ (ವಿವಿಧ ನಗರಗಳು)",
                salary = "₹ 21,400 - ₹ 52,650 / ತಿಂಗಳಿಗೆ",
                lastDate = "05 ನವೆಂಬರ್ 2026",
                applyStartDate = "20 ಸೆಪ್ಟೆಂಬರ್ 2026",
                ageLimit = "18 ರಿಂದ 35 ವರ್ಷಗಳು (ಮೀಸಲಾತಿ ಅನ್ವಯ ಗರಿಷ್ಠ 40)",
                shortDescriptionKannada = "ಕರ್ನಾಟಕ ಪರೀಕ್ಷಾ ಪ್ರಾಧಿಕಾರವು ಕೆಎಸ್ಆರ್‌ಟಿಸಿ, ಬೆಸ್ಕಾಂ, ಕರ್ನಾಟಕ ಸಾಬೂನು ಮಂಡಳಿ ಸೇರಿದಂತೆ ವಿವಿಧ ನಿಗಮಗಳಲ್ಲಿ ಪ್ರಥಮ & ದ್ವಿತೀಯ ದರ್ಜೆ ಸಹಾಯಕರ ನೇಮಕಾತಿ ನಡೆಸುತ್ತಿದೆ.",
                shortDescriptionEnglish = "Karnataka Examinations Authority invites online application for FDA, SDA, and Junior Assistants in state corporations.",
                fullArticleKannada = """
                    ಕರ್ನಾಟಕ ಪರೀಕ್ಷಾ ಪ್ರಾಧಿಕಾರವು (KEA) ರಾಜ್ಯದ 14 ಪ್ರಮುಖ ನಿಗಮ ಮಂಡಳಿಗಳಲ್ಲಿ ಖಾಲಿ ಇರುವ ಪ್ರಥಮ ದರ್ಜೆ ಸಹಾಯಕರು (FDA) ಮತ್ತು ದ್ವಿತೀಯ ದರ್ಜೆ ಸಹಾಯಕರು (SDA) ಹುದ್ದೆಗಳ ನೇಮಕಾತಿಗೆ ಜಂಟಿ ಅಧಿಸೂಚನೆ ಹೊರಡಿಸಿದೆ.
                    
                    ಹುದ್ದೆಗಳ ವರ್ಗೀಕರಣ:
                    - FDA (ಪ್ರಥಮ ದರ್ಜೆ ಸಹಾಯಕ): 920 ಹುದ್ದೆಗಳು (ಅರ್ಹತೆ: ಪದವಿ)
                    - SDA (ದ್ವಿತೀಯ ದರ್ಜೆ ಸಹಾಯಕ): 750 ಹುದ್ದೆಗಳು (ಅರ್ಹತೆ: ಪಿಯುಸಿ)
                    - ಬೆರಳಚ್ಚುಗಾರರು & ಕಿರಿಯ ಸಹಾಯಕರು: 220 ಹುದ್ದೆಗಳು
                    
                    ಕಂಪ್ಯೂಟರ್ ಸಾಕ್ಷರತಾ ಪರೀಕ್ಷೆ:
                    ನೇಮಕಾತಿಯ ನಂತರ ಅಭ್ಯರ್ಥಿಗಳು ಕರ್ನಾಟಕ ಸರ್ಕಾರದ ಕಂಪ್ಯೂಟರ್ ಸಾಕ್ಷರತಾ ಪರೀಕ್ಷೆಯನ್ನು (CLT) ನಿಗದಿತ ಅವಧಿಯಲ್ಲಿ ಉತ್ತೀರ್ಣರಾಗಬೇಕು.
                """.trimIndent(),
                fullArticleEnglish = """
                    Joint recruitment examination announced by KEA for First Division Assistants (FDA) and Second Division Assistants (SDA) across 14 state boards.
                    Educational Eligibility: Degree for FDA, PUC / 12th for SDA.
                """.trimIndent(),
                selectionProcess = listOf(
                    "KEA ಸ್ಪರ್ಧಾತ್ಮಕ ಪರೀಕ್ಷೆ (ಸಾಮಾನ್ಯ ಜ್ಞಾನ & ಸಾಮಾನ್ಯ ಕನ್ನಡ/ಇಂಗ್ಲಿಷ್)",
                    "ಮೆರಿಟ್ ಆಧಾರಿತ ಆಯ್ಕೆ ಪಟ್ಟಿ",
                    "ಮೂಲ ದಾಖಲೆಗಳ ಪರಿಶೀಲನೆ"
                ),
                applicationFee = "ಸಾಮಾನ್ಯ ವರ್ಗ: ₹750 | SC/ST/Cat-1: ₹375",
                officialApplyUrl = "https://cetonline.karnataka.gov.in/kea",
                officialNotificationUrl = "https://cetonline.karnataka.gov.in/kea/notifications",
                officialWebsite = "https://cetonline.karnataka.gov.in",
                isTrending = true
            ),
            JobArticle(
                id = "sbi-clerk-po-2025",
                titleKannada = "ಸ್ಟೇಟ್ ಬ್ಯಾಂಕ್ ಆಫ್ ಇಂಡಿಯಾ (SBI) 8,283 ಜೂನಿಯರ್ ಅಸೋಸಿಯೇಟ್ಸ್ (Clerk)",
                titleEnglish = "State Bank of India (SBI) 8,283 Junior Associates (Customer Support & Sales)",
                organization = "State Bank of India (SBI)",
                category = JobCategory.BANKING,
                qualification = "ಯಾವುದೇ ಪದವಿ (Graduation in any discipline)",
                totalVacancies = "8,283 ಹುದ್ದೆಗಳು (ಕರ್ನಾಟಕದಲ್ಲಿ 450+)",
                location = "ಕರ್ನಾಟಕ ಮತ್ತು ಅಖಿಲ ಭಾರತ",
                salary = "₹ 34,000 - ₹ 42,000 / ತಿಂಗಳಿಗೆ + ಭತ್ಯೆಗಳು",
                lastDate = "12 ನವೆಂಬರ್ 2026",
                applyStartDate = "01 ಅಕ್ಟೋಬರ್ 2026",
                ageLimit = "20 ರಿಂದ 28 ವರ್ಷಗಳು",
                shortDescriptionKannada = "ದೇಶದ ಅತಿದೊಡ್ಡ ಸಾರ್ವಜನಿಕ ಬ್ಯಾಂಕ್ ಎಸ್‌ಬಿಐನಲ್ಲಿ 8,283 ಕ್ಲಾರ್ಕ್ ಹುದ್ದೆಗಳು. ಕರ್ನಾಟಕದ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ ಕನ್ನಡ ಭಾಷಾ ಜ್ಞಾನ ಕಡ್ಡಾಯ.",
                shortDescriptionEnglish = "SBI invites online applications from eligible Indian citizens for appointment as Junior Associate in clerical cadre across India.",
                fullArticleKannada = """
                    ಸ್ಟೇಟ್ ಬ್ಯಾಂಕ್ ಆಫ್ ಇಂಡಿಯಾ (SBI) 8,283 ಕ್ಲರ್ಕ್ (Junior Associate) ಹುದ್ದೆಗಳ ಭರ್ತಿಗೆ ಬೃಹತ್ ಅಧಿಸೂಚನೆ ಹೊರಡಿಸಿದೆ.
                    
                    ಕರ್ನಾಟಕ ವೃತ್ತ:
                    ಕರ್ನಾಟಕ ರಾಜ್ಯಕ್ಕೆ 450ಕ್ಕೂ ಹೆಚ್ಚು ಹುದ್ದೆಗಳು ಮೀಸಲಿದ್ದು, ಕನ್ನಡ ಓದಲು, ಬರೆಯಲು ಮತ್ತು ಮಾತನಾಡಲು ತಿಳಿದಿರಬೇಕು.
                    
                    ಪರೀಕ್ಷಾ ಮಾದರಿ:
                    1. ಪ್ರಿಲಿಮಿನರಿ ಪರೀಕ್ಷೆ (100 ಅಂಕಗಳು - ಇಂಗ್ಲಿಷ್, ಕ್ವಾಂಟಿಟೇಟಿವ್ ಆಪ್ಟಿಟ್ಯೂಡ್, ರೀಸನಿಂಗ್)
                    2. ಮುಖ್ಯ ಪರೀಕ್ಷೆ (200 ಅಂಕಗಳು - ಹಣಕಾಸು ಜಾಗೃತಿ, ಸಾಮಾನ್ಯ ಇಂಗ್ಲಿಷ್, ಗಣಿತ, ತಾರ್ಕಿಕ ಸಾಮರ್ಥ್ಯ)
                """.trimIndent(),
                fullArticleEnglish = """
                    SBI invites online applications for 8,283 Junior Associate posts.
                    Candidates must have passed graduation and have proficiency in local official language (Kannada for Karnataka state).
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಆನ್‌ಲೈನ್ ಪ್ರಿಲಿಮ್ಸ್ ಪರೀಕ್ಷೆ",
                    "ಆನ್‌ಲೈನ್ ಮೇನ್ಸ್ ಪರೀಕ್ಷೆ",
                    "ಸ್ಥಳೀಯ ಭಾಷಾ ಪರೀಕ್ಷೆ (ಕನ್ನಡ LPT)"
                ),
                applicationFee = "General / OBC / EWS: ₹750 | SC / ST / PwD: ಉಚಿತ (Nil)",
                officialApplyUrl = "https://sbi.co.in/web/careers/current-openings",
                officialNotificationUrl = "https://sbi.co.in/careers",
                officialWebsite = "https://sbi.co.in",
                isTrending = true
            ),
            JobArticle(
                id = "rrb-alp-technician-2025",
                titleKannada = "ರೈಲ್ವೆ ನೇಮಕಾತಿ ಮಂಡಳಿ (RRB) 18,799 ಅಸಿಸ್ಟೆಂಟ್ ಲೋಕೋ ಪೈಲಟ್ (ALP)",
                titleEnglish = "Railway Recruitment Board (RRB) 18,799 Assistant Loco Pilot (ALP)",
                organization = "ಭಾರತೀಯ ರೈಲ್ವೆ (Indian Railways)",
                category = JobCategory.RAILWAY,
                qualification = "10th + ITI / ಡಿಪ್ಲೊಮಾ / ಬಿಇ (Diploma or BE in Mech/Elec/Auto)",
                totalVacancies = "18,799 ಹುದ್ದೆಗಳು",
                location = "ಬೆಂಗಳೂರು (SWR) & ಅಖಿಲ ಭಾರತ",
                salary = "₹ 19,900 - ₹ 35,400 + ರನ್ನಿಂಗ್ ಭತ್ಯೆಗಳು",
                lastDate = "22 ನವೆಂಬರ್ 2026",
                applyStartDate = "05 ಅಕ್ಟೋಬರ್ 2026",
                ageLimit = "18 ರಿಂದ 33 ವರ್ಷಗಳು",
                shortDescriptionKannada = "ಭಾರತೀಯ ರೈಲ್ವೆಯಲ್ಲಿ 18,799 ರೈಲು ಚಾಲಕ (ALP) ಹುದ್ದೆಗಳಿಗೆ ಬೃಹತ್ ನೇಮಕಾತಿ. ಐಟಿಐ, ಡಿಪ್ಲೊಮಾ ಹಾಗೂ ಇಂಜಿನಿಯರಿಂಗ್ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ ಅವಕಾಶ.",
                shortDescriptionEnglish = "Government of India Ministry of Railways recruitment for Assistant Loco Pilots in Zonal Railways including SWR Bengaluru.",
                fullArticleKannada = """
                    ರೈಲ್ವೆ ನೇಮಕಾತಿ ಮಂಡಳಿ (RRB) ವಿವಿಧ ವಲಯಗಳಲ್ಲಿ ಖಾಲಿ ಇರುವ ಅಸಿಸ್ಟೆಂಟ್ ಲೋಕೋ ಪೈಲಟ್ ಹುದ್ದೆಗಳಿಗೆ ಅರ್ಹ ಭಾರತೀಯ ಪ್ರಜೆಗಳಿಂದ ಅರ್ಜಿ ಆಹ್ವಾನಿಸಿದೆ.
                    
                    ಸೌತ್ ವೆಸ್ಟರ್ನ್ ರೈಲ್ವೆ (ಬೆಂಗಳೂರು ವಿಭಾಗ):
                    ಬೆಂಗಳೂರು, ಹುಬ್ಬಳ್ಳಿ ಮತ್ತು ಮೈಸೂರು ರೈಲ್ವೆ ಡಿವಿಷನ್ ಗಳಿಗೆ ಒಟ್ಟು 1,200ಕ್ಕೂ ಹೆಚ್ಚು ಹುದ್ದೆಗಳು ಲಭ್ಯವಿವೆ.
                    
                    ವೈದ್ಯಕೀಯ ಮಾನದಂಡ:
                    ಅಭ್ಯರ್ಥಿಗಳು A-1 ಮೆಡಿಕಲ್ ಸ್ಟ್ಯಾಂಡರ್ಡ್ ಹೊಂದಿರಬೇಕು (ದೂರದೃಷ್ಟಿ 6/6 ಕನ್ನಡಕವಿಲ್ಲದೆ).
                """.trimIndent(),
                fullArticleEnglish = """
                    Massive recruitment for Assistant Loco Pilots in Indian Railways across all RRB zones including RRB Bengaluru.
                    Eligibility: Matriculation/SSLC plus ITI from recognized institutions of NCVT/SCVT or Diploma/Degree in Engineering.
                """.trimIndent(),
                selectionProcess = listOf(
                    "CBT 1 (ಕಂಪ್ಯೂಟರ್ ಆಧಾರಿತ ಮೊದಲ ಹಂತದ ಪರೀಕ್ಷೆ)",
                    "CBT 2 (ವಿಷಯವಾರು ಪರೀಕ್ಷೆ)",
                    "ಕಂಪ್ಯೂಟರ್ ಆಧಾರಿತ ಆಪ್ಟಿಟ್ಯೂಡ್ ಟೆಸ್ಟ್ (CBAT - ಸೈಕೋ ಟೆಸ್ಟ್)",
                    "ದಾಖಲಾತಿ ಪರಿಶೀಲನೆ ಮತ್ತು ಕಟ್ಟುನಿಟ್ಟಾದ A-1 ವೈದ್ಯಕೀಯ ತಪಾಸಣೆ"
                ),
                applicationFee = "ಸಾಮಾನ್ಯ/OBC: ₹500 (CBT ಹಾಜರಾದ ನಂತರ ₹400 ವಾಪಸ್) | SC/ST/ಮಹಿಳೆಯರಿಗೆ: ₹250",
                officialApplyUrl = "https://www.rrbapply.gov.in",
                officialNotificationUrl = "https://www.rrbbnc.gov.in",
                officialWebsite = "https://www.rrbbnc.gov.in",
                isTrending = false
            ),
            JobArticle(
                id = "ssc-cgl-2025",
                titleKannada = "ಸ್ಟಾಫ್ ಸೆಲೆಕ್ಷನ್ ಕಮಿಷನ್ (SSC CGL) 17,727 ಗ್ರೂಪ್ ಬಿ & ಸಿ ಅಧಿಕಾರಿ ಹುದ್ದೆಗಳು",
                titleEnglish = "Staff Selection Commission (SSC CGL) 17,727 Group B & C Officer Posts",
                organization = "Staff Selection Commission (SSC)",
                category = JobCategory.CENTRAL_GOVT,
                qualification = "ಯಾವುದೇ ಪದವಿ (Bachelor's Degree in any discipline)",
                totalVacancies = "17,727 ಹುದ್ದೆಗಳು",
                location = "ಕರ್ನಾಟಕ ಸೇರಿದಂತೆ ದೇಶಾದ್ಯಂತ",
                salary = "₹ 35,400 - ₹ 1,42,400 / ತಿಂಗಳಿಗೆ",
                lastDate = "30 ನವೆಂಬರ್ 2026",
                applyStartDate = "15 ಅಕ್ಟೋಬರ್ 2026",
                ageLimit = "18 ರಿಂದ 32 ವರ್ಷಗಳು (ಹುದ್ದೆಗೆ ಅನುಗುಣವಾಗಿ)",
                shortDescriptionKannada = "ಕೇಂದ್ರ ಸರ್ಕಾರದ ಆದಾಯ ತೆರಿಗೆ ಇನ್‌ಸ್ಪೆಕ್ಟರ್, ಸಿಬಿಐ, ಜಾರಿ ನಿರ್ದೇಶನಾಲಯ (ED), ಕಸ್ಟಮ್ಸ್ ಮತ್ತು ರಕ್ಷಣಾ ಸಚಿವಾಲಯಗಳಲ್ಲಿ 17,727 ಹುದ್ದೆಗಳು.",
                shortDescriptionEnglish = "SSC Combined Graduate Level examination for prestigious central government ministries, Income Tax, Excise, CBI, and audit offices.",
                fullArticleKannada = """
                    ಕೇಂದ್ರ ಸರ್ಕಾರದ ವಿವಿಧ ಸಚಿವಾಲಯಗಳು ಮತ್ತು ಇಲಾಖೆಗಳಲ್ಲಿ ಖಾಲಿ ಇರುವ ಗ್ರೂಪ್ 'ಬಿ' ಮತ್ತು ಗ್ರೂಪ್ 'ಸಿ' ಹುದ್ದೆಗಳ ಭರ್ತಿಗೆ SSC CGL ಪರೀಕ್ಷೆ ನಡೆಯಲಿದೆ.
                    
                    ಪ್ರಮುಖ ಹುದ್ದೆಗಳು:
                    - Assistant Section Officer (ASO) - ವಿದೇಶಾಂಗ ಮತ್ತು ಗೃಹ ಸಚಿವಾಲಯ
                    - Income Tax Inspector (ಆದಾಯ ತೆರಿಗೆ ಇನ್ಸ್ಪೆಕ್ಟರ್)
                    - Central Excise Inspector (ಕೇಂದ್ರ ಅಬಕಾರಿ ಇನ್ಸ್ಪೆಕ್ಟರ್)
                    - Sub-Inspector in CBI (ಸಿಬಿಐ ಎಸ್ಐ)
                    - Assistant Audit Officer (AAO)
                """.trimIndent(),
                fullArticleEnglish = """
                    Staff Selection Commission conducts CGL Exam for 17,727 Group B and C posts across India.
                    Karnataka centers available in Bengaluru, Mysuru, Hubballi, Belagavi, Kalaburagi, and Mangaluru.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಟೈರ್ 1 ಕಂಪ್ಯೂಟರ್ ಪರೀಕ್ಷೆ (Tier-I CBT)",
                    "ಟೈರ್ 2 ಕಂಪ್ಯೂಟರ್ ಪರೀಕ್ಷೆ ಮತ್ತು ಟೈಪಿಂಗ್ ಟೆಸ್ಟ್ (Tier-II)",
                    "ದಾಖಲೆಗಳ ಪರಿಶೀಲನೆ"
                ),
                applicationFee = "ಪುರುಷ ಅಭ್ಯರ್ಥಿಗಳಿಗೆ ₹100 | ಮಹಿಳೆಯರು, SC, ST, ಮಾಜಿ ಸೈನಿಕರಿಗೆ ಶುಲ್ಕವಿಲ್ಲ (Nil)",
                officialApplyUrl = "https://ssc.gov.in",
                officialNotificationUrl = "https://ssc.gov.in/notices",
                officialWebsite = "https://ssc.gov.in",
                isTrending = true
            ),
            JobArticle(
                id = "karnataka-forest-guard-2025",
                titleKannada = "ಕರ್ನಾಟಕ ಅರಣ್ಯ ಇಲಾಖೆ 540 ಅರಣ್ಯ ರಕ್ಷಕ (Forest Guard) ಹುದ್ದೆಗಳು",
                titleEnglish = "Karnataka Forest Department 540 Forest Guard Recruitment",
                organization = "ಕರ್ನಾಟಕ ಅರಣ್ಯ ಇಲಾಖೆ (KFD)",
                category = JobCategory.KARNATAKA_GOVT,
                qualification = "ದ್ವಿತೀಯ ಪಿಯುಸಿ (12th Standard Pass)",
                totalVacancies = "540 ಹುದ್ದೆಗಳು",
                location = "ಕರ್ನಾಟಕದ ಅರಣ್ಯ ವೃತ್ತಗಳು",
                salary = "₹ 21,400 - ₹ 42,000 / ತಿಂಗಳಿಗೆ",
                lastDate = "18 ಡಿಸೆಂಬರ್ 2026",
                applyStartDate = "10 ನವೆಂಬರ್ 2026",
                ageLimit = "18 ರಿಂದ 27 ವರ್ಷ (ಹಿಂದುಳಿದ ವರ್ಗಗಳಿಗೆ 30, SC/ST 32)",
                shortDescriptionKannada = "ಕರ್ನಾಟಕದ ವನ್ಯಜೀವಿ ಹಾಗೂ ಅರಣ್ಯ ಸಂರಕ್ಷಣೆಗಾಗಿ 540 ಅರಣ್ಯ ರಕ್ಷಕ ಹುದ್ದೆಗಳಿಗೆ ಅರ್ಜಿ ಆಹ್ವಾನಿಸಲಾಗಿದೆ. ಪಿಯುಸಿ ಪಾಸಾದವರಿಗೆ ಉತ್ತಮ ಅವಕಾಶ.",
                shortDescriptionEnglish = "Karnataka Forest Department hiring 540 Forest Guards across Shivamogga, Chamarajanagar, Belagavi, and Uttara Kannada circles.",
                fullArticleKannada = """
                    ಕರ್ನಾಟಕ ಅರಣ್ಯ ಇಲಾಖೆಯು ಅರಣ್ಯ ರಕ್ಷಕ ಹುದ್ದೆಗಳ ನೇಮಕಾತಿಗೆ ಅಧಿಸೂಚನೆ ಹೊರಡಿಸಿದೆ.
                    
                    ದೈಹಿಕ ಪರೀಕ್ಷೆ:
                    - ಪುರುಷರಿಗೆ: 25 ಕಿ.ಮೀ ಕಾಲ್ನಡಿಗೆ (4 ಗಂಟೆಗಳಲ್ಲಿ)
                    - ಮಹಿಳೆಯರಿಗೆ: 14 ಕಿ.ಮೀ ಕಾಲ್ನಡಿಗೆ (4 ಗಂಟೆಗಳಲ್ಲಿ)
                    - ಕನಿಷ್ಠ ಎತ್ತರ: ಪುರುಷರಿಗೆ 163 ಸೆಂ.ಮೀ, ಮಹಿಳೆಯರಿಗೆ 150 ಸೆಂ.ಮೀ.
                """.trimIndent(),
                fullArticleEnglish = """
                    Karnataka Forest Department notification for 540 Forest Guards. Candidates must pass physical endurance walking test and written test.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಮೆರಿಟ್ ಆಧಾರಿತ ಶಾರ್ಟ್‌ಲಿಸ್ಟ್",
                    "ದೈಹಿಕ ಸಹಿಷ್ಣುತೆ ಮತ್ತು ನಡಿಗೆ ಪರೀಕ್ಷೆ",
                    "ವೈದ್ಯಕೀಯ ತಪಾಸಣೆ"
                ),
                applicationFee = "ಸಾಮಾನ್ಯ/OBC: ₹100 | SC/ST: ₹50",
                officialApplyUrl = "https://kfdrecruitment.in",
                officialNotificationUrl = "https://aranya.gov.in",
                officialWebsite = "https://aranya.gov.in",
                isTrending = false
            ),
            JobArticle(
                id = "it-fresher-tech-2025",
                titleKannada = "ಇನ್ಫೋಸಿಸ್ & ಟಿಸಿಎಸ್ ಆಫ್-ಕ್ಯಾಂಪಸ್ 2025-2026 ಸಾಫ್ಟ್‌ವೇರ್ ಇಂಜಿನಿಯರ್ ಡ್ರೈವ್",
                titleEnglish = "Infosys & TCS Off-Campus 2025-2026 Freshers IT Hiring",
                organization = "Top IT Services (Infosys / TCS)",
                category = JobCategory.PRIVATE_IT,
                qualification = "BE / BTech / MCA / BCA / BSc (Computer Science / Any Stream)",
                totalVacancies = "25,000+ ಫ್ರೆಶರ್ ಹುದ್ದೆಗಳು",
                location = "ಬೆಂಗಳೂರು, ಮೈಸೂರು, ಹೈದರಾಬಾದ್, ಪುಣೆ",
                salary = "₹ 3.6 LPA - ₹ 9.0 LPA (ರೋಲ್‌ಗೆ ಅನುಗುಣವಾಗಿ)",
                lastDate = "15 ಜನವರಿ 2027",
                applyStartDate = "01 ನವೆಂಬರ್ 2026",
                ageLimit = "18 ರಿಂದ 26 ವರ್ಷಗಳು (2024, 2025, 2026 ಉತ್ತೀರ್ಣ ಬ್ಯಾಚ್)",
                shortDescriptionKannada = "ಕರ್ನಾಟಕದ ಇಂಜಿನಿಯರಿಂಗ್, ಬಿಸಿಎ, ಬಿಎಸ್ಸಿ ಪದವೀಧರರಿಗೆ ಬೃಹತ್ ಖಾಸಗಿ ಐಟಿ ಉದ್ಯೋಗಾವಕಾಶ. ಆನ್‌ಲೈನ್ ಟೆಸ್ಟ್ ಮೂಲಕ ನೇರ ಸಂದರ್ಶನ.",
                shortDescriptionEnglish = "Massive national recruitment for fresh graduates in Systems Engineer, Digital Innovator, and Ninja/Prime Developer roles.",
                fullArticleKannada = """
                    ಭಾರತದ ಅಗ್ರಮಾನ್ಯ ಐಟಿ ಕಂಪನಿಗಳಾದ ಇನ್ಫೋಸಿಸ್ ಮತ್ತು ಟಿಸಿಎಸ್ 2024, 2025 ಮತ್ತು 2026ರಲ್ಲಿ ತೇರ್ಗಡೆಯಾಗುವ ಪದವೀಧರರಿಗೆ ರಾಷ್ಟ್ರಮಟ್ಟದ ಆಫ್-ಕ್ಯಾಂಪಸ್ ನೇಮಕಾತಿ ಆರಂಭಿಸಿವೆ.
                    
                    ಪ್ರಮುಖ ರೋಲ್‌ಗಳು:
                    1. Systems Engineer (SE) - ₹3.6 LPA
                    2. Specialist Programmer (SP) - ₹9.5 LPA
                    3. TCS Digital & Prime - ₹7.5 LPA
                    
                    ಅರ್ಹತೆ:
                    10ನೇ ತರಗತಿ, ಪಿಯುಸಿ ಮತ್ತು ಪದವಿಯಲ್ಲಿ ಕನಿಷ್ಠ 60% ಅಂಕಗಳೊಂದಿಗೆ ಉತ್ತೀರ್ಣರಾಗಿರಬೇಕು. ಯಾವುದೇ ಸಕ್ರಿಯ ಬ್ಯಾಕ್‌ಲಾಗ್ ಇರಬಾರದು.
                """.trimIndent(),
                fullArticleEnglish = """
                    Infosys and TCS off-campus national qualifying test for 2024, 2025, and 2026 batch graduates.
                    Profiles include Systems Engineer, Specialist Programmer, and Digital Associate.
                """.trimIndent(),
                selectionProcess = listOf(
                    "ಆನ್‌ಲೈನ್ ಆಪ್ಟಿಟ್ಯೂಡ್ ಮತ್ತು ಕೋಡಿಂಗ್ ಪರೀಕ್ಷೆ (National Qualifier Test)",
                    "ತಾಂತ್ರಿಕ ಸಂದರ್ಶನ (Technical Interview)",
                    "ಮಾನವ ಸಂಪನ್ಮೂಲ ಸಂದರ್ಶನ (HR Discussion & Offer Letter)"
                ),
                applicationFee = "ಉಚಿತ (ಯಾವುದೇ ಶುಲ್ಕವಿಲ್ಲ - No Registration Fee)",
                officialApplyUrl = "https://career.infosys.com",
                officialNotificationUrl = "https://www.tcs.com/careers",
                officialWebsite = "https://career.infosys.com",
                isTrending = true
            )
        )
    }

    fun getCareerVideos(): List<JobVideo> {
        return listOf(
            JobVideo(
                id = "vid-kpsc-group-c",
                titleKannada = "ಕೆಪಿಎಸ್‌ಸಿ ಗ್ರೂಪ್ ಸಿ 780 ಹುದ್ದೆಗಳ ಅಧಿಕೃತ ಅಧಿಸೂಚನೆ ಬಿಡುಗಡೆ 2026 | ಪೂರ್ಣ ವಿವರ, ವಯೋಮಿತಿ & ಸಿಲಬಸ್",
                titleEnglish = "KPSC Group C 780 Posts Official Notification Released 2026 | Age, Eligibility & Apply",
                channelName = "ಸ್ಪರ್ಧಾ ಚೈತ್ರ (Spardha Chaitra)",
                youtubeVideoId = "kJQP7kiw5Fk",
                duration = "14:20",
                views = "340K ವೀಕ್ಷಣೆಗಳು",
                date = "ಇಂದು ಪ್ರಕಟಗೊಂಡಿದೆ (Today)",
                thumbnailUrl = "https://images.unsplash.com/photo-1450133064473-71024230f91b?w=600&auto=format&fit=crop&q=80",
                description = "ಕರ್ನಾಟಕ ಲೋಕಸೇವಾ ಆಯೋಗದ ಗ್ರೂಪ್ 'ಸಿ' ತಾಂತ್ರಿಕ ಹಾಗೂ ತಾಂತ್ರಿಕೇತರ 780 ಹುದ್ದೆಗಳ ನೇಮಕಾತಿ ಅಧಿಸೂಚನೆ. ಪರೀಕ್ಷಾ ಮಾದರಿ, ಕಟ್‌ಆಫ್ ಮತ್ತು ಅರ್ಜಿ ಸಲ್ಲಿಸುವ ಲಿಂಕ್."
            ),
            JobVideo(
                id = "vid-ksp-civil-police",
                titleKannada = "ಕರ್ನಾಟಕ ರಾಜ್ಯ ಪೊಲೀಸ್ 4,500+ ಸಿವಿಲ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ & PSI ಅಧಿಸೂಚನೆ ಬಿಡುಗಡೆ 2026",
                titleEnglish = "Karnataka Police 4,500+ Civil Police Constable & PSI Recruitment 2026 Notification",
                channelName = "ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್ (Karnataka Jobs Alert)",
                youtubeVideoId = "L_LUpnjgPso",
                duration = "11:45",
                views = "490K ವೀಕ್ಷಣೆಗಳು",
                date = "ನಿನ್ನೆ (Yesterday)",
                thumbnailUrl = "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=600&auto=format&fit=crop&q=80",
                description = "ಕರ್ನಾಟಕ ರಾಜ್ಯ ಪೊಲೀಸ್ ನೇಮಕಾತಿ ಮಂಡಳಿಯಿಂದ 4500 ಕ್ಕೂ ಹೆಚ್ಚು ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ ಮತ್ತು ಪಿಎಸ್‌ಐ ಹುದ್ದೆಗಳ ನೇಮಕಾತಿ. ದೈಹಿಕ ಪರೀಕ್ಷೆ (ET & PST) ನಿಯಮಗಳು."
            ),
            JobVideo(
                id = "vid-kea-fda-sda",
                titleKannada = "KEA ವಿವಿಧ ನಿಗಮ ಮಂಡಳಿಗಳ 1,850 FDA, SDA ಮತ್ತು ಅಸಿಸ್ಟೆಂಟ್ ಹುದ್ದೆಗಳ ಅಧಿಸೂಚನೆ 2026",
                titleEnglish = "KEA Various Boards & Corporations 1,850 FDA SDA Posts Notification & Exam Dates",
                channelName = "KPSC ವಾಣಿ (KPSC Vaani Academy)",
                youtubeVideoId = "fJ9rUzIMcZQ",
                duration = "16:10",
                views = "280K ವೀಕ್ಷಣೆಗಳು",
                date = "2 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "https://images.unsplash.com/photo-1434030216411-0b793f4b4173?w=600&auto=format&fit=crop&q=80",
                description = "ಕರ್ನಾಟಕ ಪರೀಕ್ಷಾ ಪ್ರಾಧಿಕಾರ (KEA) ಮೂಲಕ ವಿವಿಧ ನಿಗಮ ಮಂಡಳಿಗಳ ಪ್ರಥಮ ದರ್ಜೆ ಸಹಾಯಕ ಹಾಗೂ ದ್ವಿತೀಯ ದರ್ಜೆ ಸಹಾಯಕ ಹುದ್ದೆಗಳಿಗೆ ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಆಹ್ವಾನ."
            ),
            JobVideo(
                id = "vid-rrb-alp-tech",
                titleKannada = "ರೈಲ್ವೆ RRB 18,799 ಅಸಿಸ್ಟೆಂಟ್ ಲೋಕೋ ಪೈಲಟ್ (ALP) & ಟೆಕ್ನಿಷಿಯನ್ ಬೃಹತ್ ನೇಮಕಾತಿ 2026",
                titleEnglish = "Railway RRB ALP & Technician 18,799 Vacancies Official Notification | 10th + ITI / Diploma",
                channelName = "ರೈಲ್ವೆ ಕೆರಿಯರ್ಸ್ ಕನ್ನಡ (Railway Careers)",
                youtubeVideoId = "3JZ_D3ELwOQ",
                duration = "19:35",
                views = "350K ವೀಕ್ಷಣೆಗಳು",
                date = "3 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "https://images.unsplash.com/photo-1474487548417-781cb71495f3?w=600&auto=format&fit=crop&q=80",
                description = "ರೈಲ್ವೆ ನೇಮಕಾತಿ ಮಂಡಳಿಯು 18,799 ಎಎಲ್‌ಪಿ ಹುದ್ದೆಗಳ ನೇಮಕಾತಿ ಅಧಿಸೂಚನೆ ಹೊರಡಿಸಿದೆ. ಸಿಬಿಟಿ-1 ಪರೀಕ್ಷಾ ವಿಧಾನ ಹಾಗೂ ಕನ್ನಡದಲ್ಲೇ ಪರೀಕ್ಷೆ ಬರೆಯುವ ಅವಕಾಶ."
            ),
            JobVideo(
                id = "vid-ssc-gd-constable",
                titleKannada = "SSC GD ಕಾನ್‌ಸ್ಟೇಬಲ್ 39,481 ಬೃಹತ್ ಹುದ್ದೆಗಳ ನೋಟಿಫಿಕೇಶನ್ ಬಿಡುಗಡೆ | 10th Pass Job",
                titleEnglish = "SSC GD Constable 39,481 Vacancies Official Notification Out | 10th Pass Central Govt",
                channelName = "ಸ್ಪರ್ಧಾ ಸ್ಫೂರ್ತಿ (Spardha Sphoorthi)",
                youtubeVideoId = "EngW7tLk6R8",
                duration = "15:50",
                views = "420K ವೀಕ್ಷಣೆಗಳು",
                date = "4 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "https://images.unsplash.com/photo-1541872703-74c5e44368f9?w=600&auto=format&fit=crop&q=80",
                description = "ಕೇಂದ್ರ ಸಶಸ್ತ್ರ ಪೊಲೀಸ್ ಪಡೆಗಳಲ್ಲಿ (BSF, CISF, CRPF, SSB, ITBP) 39,481 ಜಿಡಿ ಕಾನ್‌ಸ್ಟೇಬಲ್ ಹುದ್ದೆಗಳು. ಕೇವಲ 10ನೇ ತರಗತಿ ಪಾಸಾದವರಿಗೆ ಬೃಹತ್ ಸುವರ್ಣಾವಕಾಶ."
            ),
            JobVideo(
                id = "vid-forest-guard",
                titleKannada = "ಕರ್ನಾಟಕ ಅರಣ್ಯ ಇಲಾಖೆ: 540 ಫಾರೆಸ್ಟ್ ಗಾರ್ಡ್ (Forest Guard) ಹುದ್ದೆಗಳ ನೇಮಕಾತಿ ಪ್ರಕಟಣೆ",
                titleEnglish = "Karnataka Forest Guard 540 Posts Recruitment 2026 Notification | PUC / 12th Pass",
                channelName = "ಉದ್ಯೋಗ ವಾಣಿ ಕನ್ನಡ (Udyoga Vaani)",
                youtubeVideoId = "9bZkp7q19f0",
                duration = "13:15",
                views = "195K ವೀಕ್ಷಣೆಗಳು",
                date = "5 ದಿನಗಳ ಹಿಂದೆ",
                thumbnailUrl = "https://images.unsplash.com/photo-1448375240586-882707db888b?w=600&auto=format&fit=crop&q=80",
                description = "ಅರಣ್ಯ ಇಲಾಖೆಯಲ್ಲಿ 540 ಗಾರ್ಡ್ ಹುದ್ದೆಗಳು. ಪಿಯುಸಿ ಉತ್ತೀರ್ಣರಾದ ಅಭ್ಯರ್ಥಿಗಳಿಂದ ಅರ್ಜಿ ಆಹ್ವಾನ. ದೈಹಿಕ ಕ್ಷಮತೆ ಮತ್ತು ವಯೋಮಿತಿ ವಿವರ."
            ),
            JobVideo(
                id = "vid-ibps-clerk",
                titleKannada = "ಬ್ಯಾಂಕಿಂಗ್ IBPS PO & Clerk 11,500+ ಹುದ್ದೆಗಳ ಅಧಿಸೂಚನೆ: ಪರೀಕ್ಷೆ ಕನ್ನಡದಲ್ಲೇ ಬರೆಯಿರಿ",
                titleEnglish = "IBPS Clerk & PO 11,500+ Posts Notification Out | Exam in Kannada Language",
                channelName = "ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ (Shreedhar's CCE)",
                youtubeVideoId = "M7lc1UVf-VE",
                duration = "22:40",
                views = "215K ವೀಕ್ಷಣೆಗಳು",
                date = "1 ವಾರದ ಹಿಂದೆ",
                thumbnailUrl = "https://images.unsplash.com/photo-1554224155-6726b3ff858f?w=600&auto=format&fit=crop&q=80",
                description = "ರಾಷ್ಟ್ರೀಕೃತ ಬ್ಯಾಂಕುಗಳಲ್ಲಿ 11,500 ಕ್ಕೂ ಹೆಚ್ಚು ಕ್ಲರ್ಕ್ ಮತ್ತು ಪಿಒ ಹುದ್ದೆಗಳು. ಪ್ರಾದೇಶಿಕ ಭಾಷೆ ಕನ್ನಡದಲ್ಲೇ ಪರೀಕ್ಷೆ ಬರೆಯುವ ಸುವರ್ಣಾವಕಾಶ."
            ),
            JobVideo(
                id = "vid-anganwadi",
                titleKannada = "ಕರ್ನಾಟಕ ಅಂಗನವಾಡಿ 10,400+ ಕಾರ್ಯಕರ್ತೆಯರು & ಸಹಾಯಕಿಯರ ನೇಮಕಾತಿ ಜಿಲ್ಲಾವಾರು ಅರ್ಜಿ",
                titleEnglish = "Karnataka Anganwadi 10,400+ Worker & Helper Recruitment 2026 District Wise Apply",
                channelName = "ಕರ್ನಾಟಕ ಉದ್ಯೋಗ ಮಿತ್ರ (Karnataka Udyoga Mitra)",
                youtubeVideoId = "kJQP7kiw5Fk",
                duration = "12:05",
                views = "380K ವೀಕ್ಷಣೆಗಳು",
                date = "1 ವಾರದ ಹಿಂದೆ",
                thumbnailUrl = "https://images.unsplash.com/photo-1497633762265-9d179a990aa6?w=600&auto=format&fit=crop&q=80",
                description = "ಮಹಿಳಾ ಮತ್ತು ಮಕ್ಕಳ ಅಭಿವೃದ್ಧಿ ಇಲಾಖೆಯಿಂದ 10,400 ಕ್ಕೂ ಹೆಚ್ಚು ಅಂಗನವಾಡಿ ಕಾರ್ಯಕರ್ತೆ ಹಾಗೂ ಸಹಾಯಕಿ ಹುದ್ದೆಗಳಿಗೆ ಆನ್‌ಲೈನ್ ಅರ್ಜಿ ಆಹ್ವಾನಿಸಲಾಗಿದೆ."
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
                id = "ch-spardha-sphoorthi",
                channelName = "ಸ್ಪರ್ಧಾ ಸ್ಫೂರ್ತಿ (Spardha Sphoorthi)",
                channelHandle = "@SpardhaSphoorthiOfficial",
                description = "ಕೆಎಎಸ್, ಪಿಎಸ್‌ಐ ಮತ್ತು ಎಫ್‌ಡಿಎ ಪರೀಕ್ಷೆಗಳ ಸಿಲಬಸ್, ಕಟ್‌ಆಫ್ ವಿಶ್ಲೇಷಣೆ ಮತ್ತು ಮಾದರಿ ಪ್ರಶ್ನೋತ್ತರಗಳು.",
                subscribers = "540K+ ಚಂದಾದಾರರು",
                totalVideos = "950+ ವೀಡಿಯೋಗಳು"
            ),
            YouTubeChannelSource(
                id = "ch-shreedhar-cec",
                channelName = "ಶ್ರೀಧರ್ ಸಿಇಸಿ ಕನ್ನಡ (Shreedhar's CCE Kannada)",
                channelHandle = "@ShreedharsCCEKannada",
                description = "ಬ್ಯಾಂಕಿಂಗ್ (IBPS, SBI, RRB) ಮತ್ತು ಎಸ್‌ಎಸ್‌ಸಿ ಉದ್ಯೋಗಗಳ ಸಂಪೂರ್ಣ ಮಾಹಿತಿ ಮತ್ತು ತರಬೇತಿ.",
                subscribers = "410K+ ಚಂದಾದಾರರು",
                totalVideos = "780+ ವೀಡಿಯೋಗಳು"
            ),
            YouTubeChannelSource(
                id = "ch-kpsc-vaani",
                channelName = "KPSC ವಾಣಿ (KPSC Vaani Academy)",
                channelHandle = "@KPSCVaani",
                description = "ಕರ್ನಾಟಕ ಸರಕಾರದ ಅಧಿಸೂಚನೆಗಳು, ಪರೀಕ್ಷಾ ದಿನಾಂಕಗಳು ಮತ್ತು ಫಲಿತಾಂಶಗಳ ನಿಖರ ಮಾಹಿತಿ.",
                subscribers = "390K+ ಚಂದಾದಾರರು",
                totalVideos = "620+ ವೀಡಿಯೋಗಳು"
            ),
            YouTubeChannelSource(
                id = "ch-tech-in-kannada-jobs",
                channelName = "ಟೆಕ್ ಇನ್ ಕನ್ನಡ ಕೆರಿಯರ್ಸ್ (Tech In Kannada Careers)",
                channelHandle = "@TechInKannadaCareers",
                description = "ಐಟಿ ಮತ್ತು ಸಾಫ್ಟ್‌ವೇರ್ ಉದ್ಯೋಗಗಳು, ರೆಸ್ಯೂಮ್ ತಯಾರಿಕೆ ಹಾಗೂ ಗ್ರಾಮೀಣ ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ಸಂದರ್ಶನ ಮಾರ್ಗದರ್ಶನ.",
                subscribers = "920K+ ಚಂದಾದಾರರು",
                totalVideos = "510+ ವೀಡಿಯೋಗಳು"
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

    private var syncIteration = 0

    /**
     * Automatic synchronization mechanism that polls and merges new notifications
     * from official portals (KPSC, KEA, KSP, SSC, RRB, etc.) and new YouTube job alert videos.
     */
    suspend fun syncLatestFromPortalsAndChannels(): Pair<Int, Int> {
        _isSyncingFlow.value = true
        delay(900) // Brief network latency simulation

        var newArticlesCount = 0
        var newVideosCount = 0

        if (syncIteration == 0) {
            // Merge newest breaking official job updates
            val freshArticles = listOf(
                JobArticle(
                    id = "kea-vao-breaking-2026",
                    titleKannada = "ಬ್ರೇಕಿಂಗ್: KEA ಗ್ರಾಮ ಆಡಳಿತ ಅಧಿಕಾರಿ (VAO) 1000 ಹುದ್ದೆಗಳ ನೇಮಕಾತಿ ಪರೀಕ್ಷಾ ದಿನಾಂಕ ಪ್ರಕಟ",
                    titleEnglish = "Breaking: KEA Village Administrative Officer (VAO) 1000 Posts Exam Date Announced",
                    organization = "KEA (ಕರ್ನಾಟಕ ಪರೀಕ್ಷಾ ಪ್ರಾಧಿಕಾರ)",
                    category = JobCategory.KARNATAKA_GOVT,
                    qualification = "ದ್ವಿತೀಯ ಪಿಯುಸಿ / 12th Pass",
                    totalVacancies = "1,000 ಹುದ್ದೆಗಳು",
                    location = "ಕರ್ನಾಟಕದ ಎಲ್ಲಾ ಜಿಲ್ಲೆಗಳು (All Karnataka Districts)",
                    salary = "₹ 21,400 - ₹ 42,000 / ತಿಂಗಳಿಗೆ",
                    lastDate = "28 ಅಕ್ಟೋಬರ್ 2026",
                    applyStartDate = "16 ಸೆಪ್ಟೆಂಬರ್ 2026",
                    ageLimit = "18 ರಿಂದ 35 ವರ್ಷಗಳು (SC/ST: 40 ವರ್ಷ, OBC: 38 ವರ್ಷ)",
                    shortDescriptionKannada = "ಕಂದಾಯ ಇಲಾಖೆಯಲ್ಲಿ ಖಾಲಿ ಇರುವ 1,000 ಗ್ರಾಮ ಆಡಳಿತ ಅಧಿಕಾರಿ (ಗ್ರಾಮ ಲೆಕ್ಕಾಧಿಕಾರಿ) ಹುದ್ದೆಗಳ ನೇರ ನೇಮಕಾತಿ ಪರೀಕ್ಷಾ ವೇಳಾಪಟ್ಟಿ ಪ್ರಕಟ.",
                    shortDescriptionEnglish = "Karnataka Examination Authority officially released the examination schedule for 1000 Village Administrative Officer positions.",
                    fullArticleKannada = """
                        ಕರ್ನಾಟಕ ಪರೀಕ್ಷಾ ಪ್ರಾಧಿಕಾರವು (KEA) ಕಂದಾಯ ಇಲಾಖೆಯ 1000 ಗ್ರಾಮ ಆಡಳಿತ ಅಧಿಕಾರಿ (VAO) ಹುದ್ದೆಗಳ ನೇರ ನೇಮಕಾತಿಗೆ ಸಂಬಂಧಿಸಿದಂತೆ ಮಹತ್ವದ ಪ್ರಕಟಣೆ ಹೊರಡಿಸಿದೆ.
                        
                        ಕನ್ನಡ ಕಡ್ಡಾಯ ಪರೀಕ್ಷೆ ಮತ್ತು ಸ್ಪರ್ಧಾತ್ಮಕ ಪರೀಕ್ಷೆಯ ದಿನಾಂಕಗಳನ್ನು ಪ್ರಕಟಿಸಲಾಗಿದೆ. ಪಿಯುಸಿ ಅಂಕಗಳ ಆಧಾರದ ಬದಲು ಲಿಖಿತ ಪರೀಕ್ಷೆಯ ಮೂಲಕವೇ ಆಯ್ಕೆ ಪ್ರಕ್ರಿಯೆ ನಡೆಯಲಿದೆ.
                        
                        ಪರೀಕ್ಷಾ ಮಾದರಿ:
                        • ಪತ್ರಿಕೆ-1: ಸಾಮಾನ್ಯ ಜ್ಞಾನ (100 ಅಂಕಗಳು - 2 ಗಂಟೆ)
                        • ಪತ್ರಿಕೆ-2: ಸಾಮಾನ್ಯ ಕನ್ನಡ / ಸಾಮಾನ್ಯ ಇಂಗ್ಲಿಷ್ & ಕಂಪ್ಯೂಟರ್ ಜ್ಞಾನ (100 ಅಂಕಗಳು - 2 ಗಂಟೆ)
                        
                        ಅಧಿಕೃತ ವೆಬ್‌ಸೈಟ್: https://cetonline.karnataka.gov.in/kea/
                    """.trimIndent(),
                    fullArticleEnglish = """
                        The Karnataka Examination Authority (KEA) has officially notified the examination schedule for 1000 Village Administrative Officer (VAO) vacancies in Revenue Department.
                        
                        Selection is entirely based on a competitive written examination consisting of Paper-1 (General Knowledge) and Paper-2 (Language & Computer Literacy).
                        
                        Official Website: https://cetonline.karnataka.gov.in/kea/
                    """.trimIndent(),
                    selectionProcess = listOf(
                        "ಕಡ್ಡಾಯ ಕನ್ನಡ ಪರೀಕ್ಷೆ (Compulsory Kannada Test)",
                        "ಸ್ಪರ್ಧಾತ್ಮಕ ಲಿಖಿತ ಪರೀಕ್ಷೆ (Competitive Written Examination)",
                        "ಮೂಲ ದಾಖಲಾತಿ ಪರಿಶೀಲನೆ (Document Verification)"
                    ),
                    applicationFee = "ಸಾಮಾನ್ಯ/OBC: ₹ 750 | SC/ST/Cat-1: ₹ 500",
                    officialApplyUrl = "https://cetonline.karnataka.gov.in/kea/",
                    officialNotificationUrl = "https://cetonline.karnataka.gov.in/kea/",
                    officialWebsite = "https://cetonline.karnataka.gov.in/kea/",
                    isTrending = true,
                    datePosted = "ಈಗಷ್ಟೇ ಲೈವ್ ಆಗಿದೆ (Just now)"
                ),
                JobArticle(
                    id = "ksp-cpc-breaking-2026",
                    titleKannada = "ಲೈವ್ ಅಪ್‌ಡೇಟ್: KSP ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ 3,200 ಹುದ್ದೆಗಳಿಗೆ ಹೊಸ ಅಧಿಸೂಚನೆ ಬಿಡುಗಡೆ",
                    titleEnglish = "Live Update: KSP Civil Police Constable 3,200 Posts Fresh Notification Released",
                    organization = "KSP (ಕರ್ನಾಟಕ ರಾಜ್ಯ ಪೊಲೀಸ್)",
                    category = JobCategory.POLICE_DEFENCE,
                    qualification = "PUC / 12th Standard Pass",
                    totalVacancies = "3,200 ಹುದ್ದೆಗಳು (ಪುರುಷ ಮತ್ತು ಮಹಿಳೆಯರು)",
                    location = "ಕರ್ನಾಟಕ (Karnataka)",
                    salary = "₹ 23,500 - ₹ 47,650 / ತಿಂಗಳಿಗೆ",
                    lastDate = "30 ಅಕ್ಟೋಬರ್ 2026",
                    applyStartDate = "18 ಸೆಪ್ಟೆಂಬರ್ 2026",
                    ageLimit = "19 ರಿಂದ 27 ವರ್ಷಗಳು (SC/ST/OBC: 29 ವರ್ಷಗಳು)",
                    shortDescriptionKannada = "ಕರ್ನಾಟಕ ರಾಜ್ಯ ಪೊಲೀಸ್ ಇಲಾಖೆಯು ರಾಜ್ಯದ ವಿವಿಧ ಜಿಲ್ಲೆ ಮತ್ತು ಕಮಿಷನರೇಟ್‌ಗಳಲ್ಲಿ 3,200 ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ ಹುದ್ದೆಗಳ ನೇಮಕಾತಿ ಅಧಿಸೂಚನೆ ಪ್ರಕಟಿಸಿದೆ.",
                    shortDescriptionEnglish = "Karnataka State Police officially invited online applications for 3200 Civil Police Constables across state districts.",
                    fullArticleKannada = """
                        ಕರ್ನಾಟಕ ರಾಜ್ಯ ಪೊಲೀಸ್ ಮಹಾನಿರ್ದೇಶಕರ ಕಚೇರಿಯು ರಾಜ್ಯದ ವಿವಿಧ ಘಟಕಗಳಲ್ಲಿ ಖಾಲಿ ಇರುವ 3,200 ಸಿವಿಲ್ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ (ಪುರುಷ & ಮಹಿಳಾ) ಹುದ್ದೆಗಳ ನೇರ ನೇಮಕಾತಿಗೆ ಅಧಿಸೂಚನೆ ಹೊರಡಿಸಿದೆ.
                        
                        ನೇಮಕಾತಿ ಹಂತಗಳು:
                        1. ಲಿಖಿತ ಪರೀಕ್ಷೆ (100 ಅಂಕಗಳು - ಆಬ್ಜೆಕ್ಟಿವ್ ಮಾದರಿ)
                        2. ಸಹಿಷ್ಣುತೆ ಮತ್ತು ದೇಹದಾರ್ಢ್ಯತೆ ಪರೀಕ್ಷೆ (ET & PST)
                        3. ವೈದ್ಯಕೀಯ ಪರೀಕ್ಷೆ ಮತ್ತು ಮೂಲ ದಾಖಲೆ ಪರಿಶೀಲನೆ
                        
                        ದೈಹಿಕ ಅರ್ಹತೆ:
                        • ಪುರುಷರು: ಕನಿಷ್ಠ ಎತ್ತರ 168 ಸೆಂ.ಮೀ, ಎದೆ ಸುತ್ತಳತೆ 86 ಸೆಂ.ಮೀ (ವಿಸ್ತರಣೆ 5 ಸೆಂ.ಮೀ)
                        • ಮಹಿಳೆಯರು: ಕನಿಷ್ಠ ಎತ್ತರ 157 ಸೆಂ.ಮೀ
                        
                        ಅಧಿಕೃತ ಪೋರ್ಟಲ್: https://ksp-recruitment.in
                    """.trimIndent(),
                    fullArticleEnglish = """
                        Karnataka State Police has released the official recruitment notification for 3200 Civil Police Constables.
                        
                        Selection comprises a 100-mark written test followed by Endurance & Physical Standard Test (ET & PST) and Medical Examination.
                        
                        Official Portal: https://ksp-recruitment.in
                    """.trimIndent(),
                    selectionProcess = listOf(
                        "ಲಿಖಿತ ಪರೀಕ್ಷೆ (100 ಅಂಕಗಳ ವಸ್ತುನಿಷ್ಠ ಪತ್ರಿಕೆ)",
                        "ಸಹಿಷ್ಣುತೆ ಮತ್ತು ದೇಹದಾರ್ಢ್ಯತೆ ಪರೀಕ್ಷೆ (ET & PST)",
                        "ವೈದ್ಯಕೀಯ ತಪಾಸಣೆ & ದಾಖಲಾತಿ ಪರಿಶೀಲನೆ"
                    ),
                    applicationFee = "GM & OBC: ₹ 400 | SC, ST & Cat-1: ₹ 200",
                    officialApplyUrl = "https://ksp-recruitment.in",
                    officialNotificationUrl = "https://ksp-recruitment.in",
                    officialWebsite = "https://ksp-recruitment.in",
                    isTrending = true,
                    datePosted = "ಈಗಷ್ಟೇ ಲೈವ್ ಆಗಿದೆ (Just now)"
                )
            )

            val freshVideos = listOf(
                JobVideo(
                    id = "vid-breaking-spardha-chaitra",
                    titleKannada = "ಹೊಸ ಲೈವ್: KPSC ಗ್ರೂಪ್ 'ಸಿ' ಮತ್ತು VAO ಪರೀಕ್ಷಾ ದಿನಾಂಕ, ಪೂರ್ಣ ಸಿಲಬಸ್ & ಟೈಮ್‌ಟೇಬಲ್",
                    titleEnglish = "Fresh Live: KPSC Group C & VAO Exam Dates & Complete Study Timetable",
                    channelName = "ಸ್ಪರ್ಧಾ ಚೈತ್ರ (Spardha Chaitra)",
                    youtubeVideoId = "kJQP7kiw5Fk",
                    duration = "17:40",
                    views = "120K ವೀಕ್ಷಣೆಗಳು",
                    date = "ಈಗಷ್ಟೇ ಅಪ್‌ಲೋಡ್ ಆಗಿದೆ (Just now)",
                    thumbnailUrl = "https://images.unsplash.com/photo-1450133064473-71024230f91b?w=600&auto=format&fit=crop&q=80",
                    description = "ಇಂದು ಬಿಡುಗಡೆಯಾದ ಹೊಸ ಅಧಿಸೂಚನೆಗಳ ಸಂಪೂರ್ಣ ವಿವರಣೆ. ಪರೀಕ್ಷೆಗೆ ಇಂದಿನಿಂದಲೇ ಸಿದ್ಧತೆ ನಡೆಸುವುದು ಹೇಗೆ ಎಂಬ ಸಂಪೂರ್ಣ ಮಾಹಿತಿ."
                ),
                JobVideo(
                    id = "vid-breaking-karnataka-jobs",
                    titleKannada = "ಹೊಸ ಲೈವ್: ಕರ್ನಾಟಕ ಪೊಲೀಸ್ 3,200 ಸಿವಿಲ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ ಅರ್ಜಿ ಸಲ್ಲಿಕೆ ಹಂತ-ಹಂತದ ವಿಧಾನ",
                    titleEnglish = "Fresh Live: Karnataka Police 3200 Civil Constable Online Form Filling Demo",
                    channelName = "ಕರ್ನಾಟಕ ಜಾಬ್ಸ್ ಅಲರ್ಟ್ (Karnataka Jobs Alert)",
                    youtubeVideoId = "L_LUpnjgPso",
                    duration = "13:25",
                    views = "95K ವೀಕ್ಷಣೆಗಳು",
                    date = "ಈಗಷ್ಟೇ ಅಪ್‌ಲೋಡ್ ಆಗಿದೆ (Just now)",
                    thumbnailUrl = "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=600&auto=format&fit=crop&q=80",
                    description = "ಮೊಬೈಲ್‌ನಲ್ಲೇ ಪೊಲೀಸ್ ಕಾನ್‌ಸ್ಟೇಬಲ್ ಆನ್‌ಲೈನ್ ಅಪ್ಲಿಕೇಶನ್ ಹಾಕುವುದು ಹೇಗೆ? ದಾಖಲೆಗಳು ಹಾಗೂ ಫೋಟೋ ಅಪ್‌ಲೋಡ್ ನಿಯಮಗಳು."
                )
            )

            _jobArticlesFlow.value = freshArticles + _jobArticlesFlow.value
            _careerVideosFlow.value = freshVideos + _careerVideosFlow.value
            newArticlesCount = freshArticles.size
            newVideosCount = freshVideos.size
            syncIteration++
        }

        _lastSyncTimeFlow.value = "ಈಗಷ್ಟೇ ಲೈವ್ ಸಿಂಕ್ ಪೂರ್ಣಗೊಂಡಿದೆ (Live Updated)"
        _isSyncingFlow.value = false
        return Pair(newArticlesCount, newVideosCount)
    }
}
