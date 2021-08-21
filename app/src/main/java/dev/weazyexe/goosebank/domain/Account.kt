package dev.weazyexe.goosebank.domain

import androidx.annotation.StringRes
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

    @StringRes
    fun title(): Int = when (this) {
        STANDARD -> R.string.account_type_standard
        PLATINUM -> R.string.account_type_platinum
        GOLD -> R.string.account_type_gold
    }
}

