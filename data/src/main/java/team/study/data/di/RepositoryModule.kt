package team.study.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import team.study.data.repository.UserDataRepository
import team.study.data.repository.UserDataRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsUserDataRepository(
        userDataRepository: UserDataRepositoryImpl,
    ): UserDataRepository
}
