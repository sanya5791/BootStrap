package com.akhutornoy.bootstrap.presentation.ui.base

import android.os.Bundle
import androidx.lifecycle.Observer
import com.akhutornoy.bootstrap.presentation.ui.extension.showToast
import com.github.ajalt.timberkt.Timber

abstract class BaseViewModelFragment : BaseDaggerFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        handleErrors()

        initViewModelObservers()
    }

    private fun handleErrors() {
        getBaseViewModel().showErrorLiveData.observe(this, Observer { handleErrorMessage(it) })
    }

    protected fun handleErrorMessage(errorMessage: String?) {
        val msg = errorMessage ?: "Error message is NULL"
        Timber.e { msg }
        requireActivity().showToast(msg)
    }

    protected abstract fun getBaseViewModel(): BaseViewModel

    protected abstract fun initViewModelObservers()

    protected fun onError(error: Throwable) {
        Timber.e(error)
        error.message?.let { showInfoMessage(it) }
    }

}