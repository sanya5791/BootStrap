package com.akhutornoy.bootstrap.presentation.ui.main

import androidx.annotation.LayoutRes
import com.akhutornoy.bootstrap.R
import com.akhutornoy.bootstrap.presentation.ui.base.BaseDaggerActivity
import javax.inject.Inject

class MainActivity : BaseDaggerActivity() {

    @Inject
    lateinit var navigator: MainActivityNavigator

    @LayoutRes
    override fun getActivityLayout(): Int = R.layout.activity_main

    override fun initViews() {
        navigator.navigateToPetList()
    }

}
