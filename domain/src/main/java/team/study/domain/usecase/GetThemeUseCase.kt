package team.study.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import team.study.domain.model.UserPreference
import team.study.domain.repository.UserDataRepository
import javax.inject.Inject

class GetThemeUseCase @Inject constructor(
    private val userDataRepository: UserDataRepository,
) {
    operator fun invoke(): Flow<UserPreference.ThemeType> {
        return userDataRepository.userPreference.map { prefs ->
            prefs.theme
        }
    }
}
