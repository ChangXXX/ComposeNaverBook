package team.study.data.repository

import kotlinx.coroutines.flow.Flow
import team.study.data.datasource.UserPreferencesDataSource
import team.study.domain.model.UserPreference
import team.study.domain.model.UserPreference.ThemeType
import team.study.domain.repository.UserDataRepository
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userPreferencesDataSource: UserPreferencesDataSource,
) : UserDataRepository {

    override val userPreference: Flow<UserPreference> =
        userPreferencesDataSource.userPreference

    override suspend fun updateTheme(themeType: ThemeType) {
        userPreferencesDataSource.updateTheme(themeType)
    }
}
