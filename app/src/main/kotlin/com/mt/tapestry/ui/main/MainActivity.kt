package com.mt.tapestry.ui.main

import android.os.Bundle
import com.mt.tapestry.R
import com.mt.tapestry.ui.navigator.MainNavigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var navigator: MainNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.navigateToFeeds()
    }
}

