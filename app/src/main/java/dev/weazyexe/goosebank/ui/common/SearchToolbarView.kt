package dev.weazyexe.goosebank.ui.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.MenuRes
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import dev.weazyexe.goosebank.R
import dev.weazyexe.goosebank.databinding.ViewSearchToolbarBinding
import dev.weazyexe.goosebank.ui.common.SearchToolbarState.DEFAULT
import dev.weazyexe.goosebank.ui.common.SearchToolbarState.SEARCH
import dev.weazyexe.goosebank.util.hideKeyboard
import dev.weazyexe.goosebank.util.showKeyboard

/**
 * Toolbar with search function
 */
class SearchToolbarView(
    context: Context,
    attrs: AttributeSet
) : FrameLayout(context, attrs) {

    private val binding = ViewSearchToolbarBinding.inflate(LayoutInflater.from(context))
        .also { addView(it.root) }

    private var state: SearchToolbarState = DEFAULT
        set(value) {
            updateState(value)
            field = value
        }

    var title: String = ""
        set(value) {
            updateTitle(value)
            field = value
        }

    @MenuRes
    var menu: Int = -1
        set(value) {
            updateMenu(value)
            field = value
        }

    var onSearchChanged: (String) -> Unit = {}

    var onBackClicked: () -> Unit = {}

    init {
        initListeners()
    }

    private fun initListeners() = with(binding) {
        clearIb.setOnClickListener {
            searchEv.setText("")
        }
        backIb.setOnClickListener {
            state = DEFAULT
            searchEv.setText("")
            hideKeyboard()
            onBackClicked.invoke()
        }
        searchEv.doOnTextChanged { text, _, _, _ ->
            onSearchChanged.invoke(text.toString())
        }
        toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.action_search) {
                state = SEARCH
                return@setOnMenuItemClickListener true
            }

            false
        }
        searchEv.setOnEditorActionListener { _, _, _ ->
            hideKeyboard()
            searchEv.clearFocus()
            true
        }
    }

    private fun updateState(state: SearchToolbarState) = with(binding) {
        when (state) {
            DEFAULT -> {
                searchToolbarLayout.isVisible = false
                toolbar.isVisible = true
            }
            SEARCH -> {
                searchToolbarLayout.isVisible = true
                toolbar.isVisible = false
                searchEv.requestFocus()
                showKeyboard()
            }
        }
    }

    private fun updateTitle(title: String) = with(binding) {
        toolbar.title = title
    }

    private fun updateMenu(@MenuRes menuRes: Int) = with(binding) {
        toolbar.inflateMenu(menuRes)
    }
}

enum class SearchToolbarState {
    DEFAULT,
    SEARCH
}