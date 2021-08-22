package dev.weazyexe.goosebank.domain

import androidx.annotation.DrawableRes
import dev.weazyexe.goosebank.R
import java.util.*

/**
 * Bank transaction entity
 */
data class Transaction(
    val amount: Double,
    val title: String,
    val type: String,
    val date: Date,
    val currency: Currency
) {

    @DrawableRes
    fun icon(): Int = when (type) {
        "Groceries" -> R.drawable.ic_groceries
        "Transport" -> R.drawable.ic_transport
        "Electronics" -> R.drawable.ic_electronics
        "Entertainment" -> R.drawable.ic_entertainment
        else -> -1
    }
}