package team.study.domain.repository

import kotlinx.coroutines.flow.Flow
import team.study.domain.model.UserPreference
import team.study.domain.model.UserPreference.ThemeType

interface UserDataRepository {

    /**
     * Steram of UserData
     */
    val userPreference: Flow<UserPreference>

    /**
     * Update Theme
     * @param themeType: ThemeType
     */
    suspend fun updateTheme(themeType: ThemeType)
}
