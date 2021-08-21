package dev.weazyexe.goosebank.domain

import androidx.annotation.ColorRes
import dev.weazyexe.goosebank.R

/**
 * Bank account entity
 */
data class Account(
    val title: String,
    val amount: Double,
    val type: AccountType,
    val currency: Currency
)

/**
 * Type of bank account enumeration
 */
enum class AccountType {
    STANDARD,
    PLATINUM,
    GOLD;

    @ColorRes
    fun color(): Int = when(this) {
        STANDARD -> R.color.teal
        PLATINUM -> R.color.dark_gray
        GOLD -> R.color.gold
    }
}

