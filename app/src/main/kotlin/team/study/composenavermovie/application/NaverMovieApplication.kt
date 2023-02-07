package team.study.composenavermovie.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NaverMovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
