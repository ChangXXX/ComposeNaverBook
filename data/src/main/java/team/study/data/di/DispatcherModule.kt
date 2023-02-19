package team.study.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    @Dispatcher(CustomDispatchers.IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val customDispatcher: CustomDispatchers)

enum class CustomDispatchers {
    IO, DEFAULT
}
