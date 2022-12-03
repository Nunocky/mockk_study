package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


interface Preference {
    var hoge: Boolean
}

class DefaultPreference @Inject constructor(@ApplicationContext context: Context) : Preference {
    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences("sample", Context.MODE_PRIVATE)
    }

    override var hoge: Boolean
        get() {
            return sharedPreferences.getBoolean("hoge", false)
        }
        set(value) {
            sharedPreferences.edit()
                .putBoolean("hoge", value)
                .apply()
        }
}