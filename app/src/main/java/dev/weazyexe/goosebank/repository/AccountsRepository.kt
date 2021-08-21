package dev.weazyexe.goosebank.repository

import dev.weazyexe.goosebank.domain.Account
import dev.weazyexe.goosebank.domain.AccountType
import dev.weazyexe.goosebank.domain.Currency

/**
 * Accounts data source
 */
class AccountsRepository {

    fun getAccounts(): List<Account> = listOf(
        Account(title = "GooseBank RUB", amount = 3214.21, type = AccountType.STANDARD, currency = Currency.RUB),
        Account(title = "GooseBank UAH", amount = 432.0, type = AccountType.STANDARD, currency = Currency.UAH),
        Account(title = "GB Platinum USD", amount = 75234.85, type = AccountType.PLATINUM, currency = Currency.USD),
        Account(title = "GB Gold EUR", amount = 0.0, type = AccountType.GOLD, currency = Currency.EUR),
        Account(title = "GB Credit RUB", amount = 92361.12, type = AccountType.STANDARD, currency = Currency.RUB),
        Account(title = "Yet another account", amount = 0.0, type = AccountType.STANDARD, currency = Currency.UAH),
        Account(title = "GB Platinum UAH", amount = 58934.91, type = AccountType.PLATINUM, currency = Currency.UAH)
    )
}