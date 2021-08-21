package dev.weazyexe.goosebank.util

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.string(@StringRes stringRes: Int): String = getString(stringRes)