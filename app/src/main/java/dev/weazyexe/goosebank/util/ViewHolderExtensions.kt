package dev.weazyexe.goosebank.util

import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.ViewHolder.string(@StringRes stringRes: Int): String =
    itemView.context.getString(stringRes)