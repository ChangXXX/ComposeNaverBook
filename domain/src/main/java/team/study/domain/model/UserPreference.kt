package team.study.domain.model

data class UserPreference(
    val theme: ThemeType,
) {
    sealed class ThemeType(val type: Int) {
        object System : ThemeType(0)
        object Light : ThemeType(1)
        object Dark : ThemeType(2)
    }
}
