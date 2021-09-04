package dev.weazyexe.goosebank.util

import android.app.Activity
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * Gets the color from resources
 */
@ColorInt
fun Activity.color(@ColorRes colorRes: Int): Int = ContextCompat.getColor(this, colorRes)

/**
 * Gets the Activity's root view
 */
fun Activity.rootView(): View = window.decorView.findViewById(android.R.id.content)