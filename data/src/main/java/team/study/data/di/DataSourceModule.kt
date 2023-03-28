package team.study.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import team.study.data.datasource.BookRemoteDataSource
import team.study.data.datasource.BookRemoteDataSourceImpl
import team.study.data.network.BookService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideBookDataSource(
        bookService: BookService,
        @Dispatcher(CustomDispatchers.IO) ioDispatcher: CoroutineDispatcher,
    ): BookRemoteDataSource =
        BookRemoteDataSourceImpl(bookService, ioDispatcher)
}
