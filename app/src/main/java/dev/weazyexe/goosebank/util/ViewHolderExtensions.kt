package dev.weazyexe.goosebank.util

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.ViewHolder.string(@StringRes stringRes: Int): String =
    itemView.context.getString(stringRes)

fun RecyclerView.ViewHolder.drawable(@DrawableRes drawableRes: Int): Drawable? =
    ContextCompat.getDrawable(itemView.context, drawableRes)