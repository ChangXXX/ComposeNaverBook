package team.study.data.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import team.study.data.datasource.UserPreferencesDataSource.PreferencesKey.THEME_KEY
import team.study.data.model.UserPreference
import team.study.data.model.UserPreference.ThemeType
import team.study.data.model.UserPreference.ThemeType.Dark
import team.study.data.model.UserPreference.ThemeType.Light
import team.study.data.model.UserPreference.ThemeType.System
import javax.inject.Inject

class UserPreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<Preferences>,
) {
    private object PreferencesKey {
        val THEME_KEY = intPreferencesKey("THEME_KEY")
    }

    val userPreference: Flow<UserPreference> = userPreferences.data
        .map { prefs ->
            mapUserPreference(prefs)
        }

    suspend fun updateTheme(themeType: ThemeType) {
        userPreferences.edit { prefs ->
            prefs[THEME_KEY] = themeType.type
        }
    }

    private fun mapUserPreference(prefs: Preferences): UserPreference =
        UserPreference(
            theme = when (prefs[THEME_KEY] ?: 0) {
                0 -> {
                    System
                }
                1 -> {
                    Light
                }
                2 -> {
                    Dark
                }
                else -> {
                    System
                }
            },
        )
}
