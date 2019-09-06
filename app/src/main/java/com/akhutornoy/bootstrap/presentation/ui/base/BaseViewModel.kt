package com.akhutornoy.bootstrap.presentation.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.Timber
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _showProgressLiveData = MutableLiveData<Boolean>()
    val showProgressLiveData: LiveData<Boolean>
        get() = _showProgressLiveData

    private val _showErrorLiveData = MutableLiveData<String>()
    val showErrorLiveData: LiveData<String>
        get() = _showErrorLiveData

    protected fun <T> launchBackgroundJob(
        backgroundJob: suspend () -> T,
        onSuccess: (T) -> Unit = {},
        onError: (Throwable) -> Unit = ::showError
    ) {
        viewModelScope.launch {
            showProgress()
            kotlin.runCatching {
                backgroundJob.invoke()
            }
                .onSuccess { result -> onSuccess.invoke(result) }
                .onFailure { error -> onError.invoke(error) }
            hideProgress()
        }
    }

    protected fun showProgress() {
        _showProgressLiveData.value = true
    }

    protected fun hideProgress() {
        _showProgressLiveData.value = false
    }

    protected fun showError(error: Throwable) {
        Timber.e(error)
        error.message?.run { _showErrorLiveData.value = error.message }
    }

}