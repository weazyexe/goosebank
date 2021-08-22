package dev.weazyexe.goosebank.ui.screen.history.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.weazyexe.goosebank.domain.Transaction

/**
 * Diff utils for [TransactionAdapter]
 */
class TransactionDiffUtil(
    private val oldTransactions: List<Transaction>,
    private val newTransactions: List<Transaction>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldTransactions.size

    override fun getNewListSize(): Int = newTransactions.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldTransactions[oldItemPosition].hashCode() == newTransactions[newItemPosition].hashCode()

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldTransactions[oldItemPosition] == newTransactions[newItemPosition]
}