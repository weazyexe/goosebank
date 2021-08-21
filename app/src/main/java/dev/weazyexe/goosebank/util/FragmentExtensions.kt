package dev.weazyexe.goosebank.util

import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.string(@StringRes stringRes: Int): String = getString(stringRes)

@ColorInt
fun Fragment.color(@ColorRes colorRes: Int): Int =
    ContextCompat.getColor(requireContext(), colorRes)