package team.study.data.repository

import kotlinx.coroutines.flow.Flow
import team.study.data.datasource.UserPreferencesDataSource
import team.study.data.model.UserPreference
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userPreferencesDataSource: UserPreferencesDataSource,
) : UserDataRepository {
    override val userPreference: Flow<UserPreference> =
        userPreferencesDataSource.userPreference

    override suspend fun updateTheme(themeType: UserPreference.ThemeType) {
        userPreferencesDataSource.updateTheme(themeType)
    }
}
