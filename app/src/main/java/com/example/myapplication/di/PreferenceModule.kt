package com.example.myapplication.di

import com.example.myapplication.DefaultPreference
import com.example.myapplication.Preference
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class PreferenceModule {

    @Binds
    abstract fun bindPreference(prefs: DefaultPreference): Preference
}