package dev.weazyexe.goosebank.ui.screen.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.weazyexe.goosebank.domain.Transaction
import dev.weazyexe.goosebank.repository.TransactionsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * [HistoryFragment]'s view model
 */
class HistoryViewModel : ViewModel() {

    private val transactionsRepository = TransactionsRepository()

    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions = _transactions.asStateFlow()

    fun searchTransactions(query: String = "") {
        viewModelScope.launch {
            val transactions = transactionsRepository.getTransactions()
                .filter { it.title.contains(query, ignoreCase = true) }

            _transactions.emit(transactions)
        }
    }
}