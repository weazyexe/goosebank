package dev.weazyexe.goosebank.domain

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
)