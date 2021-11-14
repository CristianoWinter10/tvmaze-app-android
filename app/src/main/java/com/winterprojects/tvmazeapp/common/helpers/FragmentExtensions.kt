package com.winterprojects.tvmazeapp.common.helpers

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Fragment.hideSoftKeyboard() {
    this.view?.let {
        val inputManagerMethod = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManagerMethod.hideSoftInputFromWindow(it.windowToken, 0)
    }
}