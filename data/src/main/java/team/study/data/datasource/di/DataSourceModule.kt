package team.study.data.datasource.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import team.study.data.datasource.BookRemoteDataSource
import team.study.data.datasource.BookRemoteDataSourceImpl
import team.study.data.network.service.BookService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideBookDataSource(
        bookService: BookService,
    ): BookRemoteDataSource =
        BookRemoteDataSourceImpl(bookService)
}
