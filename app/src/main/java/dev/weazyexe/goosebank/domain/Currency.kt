package dev.weazyexe.goosebank.domain

/**
 * Account's currency enumeration
 */
enum class Currency {
    RUB,
    USD,
    EUR,
    UAH;

    fun symbol(): String = when(this) {
        RUB -> "₽"
        USD -> "$"
        EUR -> "€"
        UAH -> "₴"
    }
}