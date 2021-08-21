package dev.weazyexe.goosebank.repository

import dev.weazyexe.goosebank.domain.Account
import dev.weazyexe.goosebank.domain.Currency
import dev.weazyexe.goosebank.domain.Transaction
import java.util.*

/**
 * Transactions data source
 */
class TransactionsRepository {

    fun getTransactions(): List<Transaction> = listOf(
        Transaction(amount = 133.0, title = "Store", type = "Groceries", date = Date(1629535265), currency = Currency.RUB),
        Transaction(amount = 534.12, title = "Grocery Store", type = "Restaurants", date = Date(16295825265), currency = Currency.RUB),
        Transaction(amount = 8953.2, title = "Megastore", type = "Transfers", date = Date(1629539265), currency = Currency.USD),
        Transaction(amount = 43.0, title = "Aoaoastore", type = "Clothes", date = Date(1629535219), currency = Currency.EUR),
        Transaction(amount = 99.90, title = "stoorrr", type = "Clothes", date = Date(1629535212), currency = Currency.UAH),
        Transaction(amount = 4126.23, title = "storeee", type = "Groceries", date = Date(1629435265), currency = Currency.USD),
        Transaction(amount = 65.3, title = "superstore", type = "Restaurants", date = Date(1629915265), currency = Currency.EUR),
        Transaction(amount = 9438.3, title = "storesuper*3", type = "Groceries", date = Date(16295925265), currency = Currency.RUB),
        Transaction(amount = 563.3, title = "hahastore", type = "Restaurants", date = Date(1629532865), currency = Currency.USD),
        Transaction(amount = 634.3, title = "store?", type = "Groceries", date = Date(16295385265), currency = Currency.RUB),
        Transaction(amount = 5843.5, title = "IFFFstore", type = "Transfers", date = Date(1629535264), currency = Currency.RUB),
        Transaction(amount = 87523.4, title = "ieeestore", type = "Groceries", date = Date(1628635265), currency = Currency.USD),
        Transaction(amount = 8423.6, title = "nnnnstorennn", type = "Restaurants", date = Date(1629543265), currency = Currency.USD),
        Transaction(amount = 21083.4, title = "ssttoorree", type = "Groceries", date = Date(1629591265), currency = Currency.RUB),
        Transaction(amount = 1234.4, title = "erots", type = "Transfers", date = Date(1529535265), currency = Currency.UAH),
        Transaction(amount = 832.4, title = "eerroottss", type = "Groceries", date = Date(1511115265), currency = Currency.USD),
        Transaction(amount = 85.7, title = "s t o r e", type = "Restaurants", date = Date(1629531165), currency = Currency.RUB),
        Transaction(amount = 82.9, title = "xXx_S70R3_xXx", type = "Groceries", date = Date(1629535265), currency = Currency.USD),
        Transaction(amount = 98432.4, title = "onlinestore", type = "Groceries", date = Date(1621135265), currency = Currency.EUR),
        Transaction(amount = 834.7, title = "offlinestore", type = "Restaurants", date = Date(1629511265), currency = Currency.UAH),
        Transaction(amount = 8213.9, title = "aaaaaaaaaaaaaaaa", type = "Groceries", date = Date(1629335265), currency = Currency.EUR),
        Transaction(amount = 87.7, title = "aaaaoaoaoammmm", type = "Groceries", date = Date(1629535565), currency = Currency.EUR),
        Transaction(amount = 85.0, title = "Spotify", type = "Music", date = Date(1629539965), currency = Currency.RUB)
    )
}