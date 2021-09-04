package dev.weazyexe.goosebank.util

import androidx.recyclerview.widget.RecyclerView

/**
 * Scrolls the RecyclerView to the end of the list
 */
fun RecyclerView.scrollDown() {
    adapter?.let {
        smoothScrollToPosition(it.itemCount - 1)
    }
}