package dev.weazyexe.goosebank.util

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * Gets the string from resources
 */
fun RecyclerView.ViewHolder.string(@StringRes stringRes: Int): String =
    itemView.context.getString(stringRes)

/**
 * Gets the drawable from resources
 */
fun RecyclerView.ViewHolder.drawable(@DrawableRes drawableRes: Int): Drawable? =
    ContextCompat.getDrawable(itemView.context, drawableRes)

/**
 * Gets the color from resources
 */
@ColorInt
fun RecyclerView.ViewHolder.color(@ColorRes colorRes: Int): Int =
    ContextCompat.getColor(itemView.context, colorRes)