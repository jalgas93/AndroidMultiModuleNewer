package uz.octo.mobile_android.di

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import androidx.navigation.fragment.NavHostFragment
import dagger.Binds
import uz.octo.feature_movies.domain.navigation.NavigationList
import uz.octo.mobile_android.R
import uz.octo.mobile_android.navigation.Navigator

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {
    @Provides
    fun navController(activity: FragmentActivity): NavController {
        return NavHostFragment.findNavController(activity.supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!)
    }

    @Module
    @InstallIn(ActivityComponent::class)
    abstract class NavigationListModule {
        @Binds
        abstract fun popularList(navigator: Navigator): NavigationList
    }
}