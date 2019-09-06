package com.akhutornoy.bootstrap.presentation.ui.extension

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(msg: String) =
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

fun Context.showToast(@StringRes msgResId: Int) =
    showToast(this.getString(msgResId))