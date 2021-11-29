package com.example.clone.DI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bottomnavigationcat.ui.blank.BlankViewModel
import com.example.bottomnavigationcat.ui.dashboard.DashboardViewModel
import com.example.bottomnavigationcat.ui.home.HomeViewModel
import com.example.bottomnavigationcat.ui.notifications.NotificationsViewModel

import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
    @Binds
    @IntoMap
    @ViewModelKey(BlankViewModel::class)
    abstract fun  bindsBaseSetupViewModel1(baseSetupViewModel: BlankViewModel):ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun  bindsBaseSetupViewModel2(baseSetupViewModel: DashboardViewModel):ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun  bindsBaseSetupViewModel3(baseSetupViewModel: HomeViewModel):ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(NotificationsViewModel::class)
    abstract fun  bindsBaseSetupViewModel4(baseSetupViewModel: NotificationsViewModel):ViewModel


}