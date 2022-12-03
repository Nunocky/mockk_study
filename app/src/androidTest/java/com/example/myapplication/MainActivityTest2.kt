package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.di.PreferenceModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@UninstallModules(PreferenceModule::class)
class MainActivityTest2 {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Module
    @InstallIn(ActivityComponent::class)
    object PreferenceModule {
        private val mock = mockk<Preference>().apply {
            every { hoge } answers { false }
        }

        @Provides
        fun providePrefs(): Preference = mock
    }

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun test1_false() {
        onView(withId(R.id.textView)).check(matches(withText("False")))
    }
}