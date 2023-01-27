package team.study.composenavermovie.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    const val KAKAO_URL = "https://dapi.kakao.com/"
}
