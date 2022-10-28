package com.example.mindfulmind

import android.app.Application

class JournalApplication: Application() {
    val db by lazy {
        appDataBase.getInstance(this)
    }
}