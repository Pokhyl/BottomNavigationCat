package com.example.bottomnavigationcat.di

import com.example.bottomnavigationcat.MainActivity
import com.example.bottomnavigationcat.ui.blank.BlankFragment
import com.example.bottomnavigationcat.ui.dashboard.DashboardFragment
import com.example.bottomnavigationcat.ui.home.HomeFragment
import com.example.bottomnavigationcat.ui.notifications.NotificationsFragment
import com.example.clone.DI.ViewModelModule
import dagger.Component

@Component(modules = [ViewModelModule::class])
interface MainComponent {
    @Component.Builder
    interface Builder{
        fun build():MainComponent
    }
    fun inject(mainActivity: MainActivity)
    fun inject(blankFragment: BlankFragment)
   fun inject(dashboardFragment: DashboardFragment)
   fun inject(homeFragment: HomeFragment)
   fun inject(notificationsFragment: NotificationsFragment)
}