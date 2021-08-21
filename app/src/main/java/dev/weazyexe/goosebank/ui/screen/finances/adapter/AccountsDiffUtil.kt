package dev.weazyexe.goosebank.ui.screen.finances.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.weazyexe.goosebank.domain.Account

/**
 * Diff utils for [AccountAdapter]
 */
class AccountsDiffUtil(
    private val oldAccounts: List<Account>,
    private val newAccounts: List<Account>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldAccounts.size

    override fun getNewListSize(): Int = newAccounts.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldAccounts[oldItemPosition].hashCode() == newAccounts[newItemPosition].hashCode()

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldAccounts[oldItemPosition] == newAccounts[newItemPosition]
}