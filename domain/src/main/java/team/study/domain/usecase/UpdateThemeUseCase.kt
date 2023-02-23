package team.study.domain.usecase

import team.study.domain.model.UserPreference.ThemeType
import team.study.domain.repository.UserDataRepository
import javax.inject.Inject

class UpdateThemeUseCase @Inject constructor(
    private val userDataRepository: UserDataRepository,
) {
    suspend operator fun invoke(themeType: ThemeType) {
        userDataRepository.updateTheme(themeType)
    }
}
