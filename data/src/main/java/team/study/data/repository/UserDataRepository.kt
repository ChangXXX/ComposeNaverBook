package team.study.data.repository

import kotlinx.coroutines.flow.Flow
import team.study.data.model.UserPreference
import team.study.data.model.UserPreference.ThemeType

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
