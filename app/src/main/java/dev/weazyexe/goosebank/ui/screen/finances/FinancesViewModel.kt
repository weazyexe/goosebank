package dev.weazyexe.goosebank.ui.screen.finances

import androidx.lifecycle.ViewModel
import dev.weazyexe.goosebank.domain.Account
import dev.weazyexe.goosebank.repository.AccountsRepository

/**
 * [FinancesFragment]'s view model
 */
class FinancesViewModel : ViewModel() {

    private val accountsRepository = AccountsRepository()

    fun loadAccounts(): List<Account> = accountsRepository.getAccounts()
}