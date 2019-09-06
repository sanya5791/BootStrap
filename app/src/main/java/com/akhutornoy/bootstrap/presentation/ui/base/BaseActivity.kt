package com.akhutornoy.bootstrap.presentation.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.akhutornoy.bootstrap.presentation.ui.extension.showToast

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityLayout())

        initViews()
    }

    @LayoutRes
    abstract fun getActivityLayout(): Int

    abstract fun initViews()

    protected fun showError(errorMessage: String) = showToast(errorMessage)

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
            return
        }
        super.onBackPressed()
    }

}