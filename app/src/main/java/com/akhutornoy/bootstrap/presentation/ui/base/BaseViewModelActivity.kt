package com.akhutornoy.bootstrap.presentation.ui.base

import android.os.Bundle
import androidx.lifecycle.Observer

abstract class BaseViewModelActivity : BaseDaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModelObservers()
        initViewModelShowErrorObserver()
    }

    abstract fun initViewModelObservers()

    abstract fun getBaseViewModel(): BaseViewModel

    protected fun initViewModelShowErrorObserver() {
        getBaseViewModel().showErrorLiveData.observe(this, Observer(::showError))
    }

}