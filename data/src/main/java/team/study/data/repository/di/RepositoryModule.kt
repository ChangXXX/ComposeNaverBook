package team.study.data.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import team.study.data.repository.BookRepositoryImpl
import team.study.data.repository.UserDataRepositoryImpl
import team.study.domain.repository.BookRepository
import team.study.domain.repository.UserDataRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindUserDataRepository(
        userDataRepository: UserDataRepositoryImpl,
    ): UserDataRepository

    @Binds
    fun bindBookRepository(
        BookRepository: BookRepositoryImpl,
    ): BookRepository
}
