package dev.weazyexe.goosebank.util

import android.app.Activity
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

@ColorInt
fun Activity.color(@ColorRes colorRes: Int): Int = ContextCompat.getColor(this, colorRes)