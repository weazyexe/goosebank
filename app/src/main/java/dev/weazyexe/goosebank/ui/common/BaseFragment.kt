package dev.weazyexe.goosebank.ui.common

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * Base fragment with tag
 */
abstract class BaseFragment(@LayoutRes val layoutRes: Int) : Fragment(layoutRes) {

    abstract fun tag(): String
}