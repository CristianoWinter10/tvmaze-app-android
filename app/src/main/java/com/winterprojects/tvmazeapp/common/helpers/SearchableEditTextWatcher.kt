package com.winterprojects.tvmazeapp.common.helpers

import java.util.*

class SearchableQueryTextListener(
    private val callback: (term: String) -> Unit,
    private val onSubmit: () -> Unit
) :
    androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private var timer: Timer? = null

    override fun onQueryTextSubmit(text: String?): Boolean {
        timer?.cancel()
        text?.let { callback.invoke(it) }
        onSubmit()
        return true
    }

    override fun onQueryTextChange(text: String?): Boolean {
        timer?.cancel()

        if (text != null) {
            timer = Timer()

            timer?.run {
                this.schedule(
                    object : TimerTask() {
                        override fun run() {
                            callback(text.toString())
                        }
                    },
                    SEARCH_DEBOUNCE_TIME_MILLISECONDS
                )
            }
        }

        return true
    }

    companion object {
        private const val SEARCH_DEBOUNCE_TIME_MILLISECONDS = 300L
    }
}