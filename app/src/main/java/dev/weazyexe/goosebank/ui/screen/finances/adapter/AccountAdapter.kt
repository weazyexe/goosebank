package dev.weazyexe.goosebank.ui.screen.finances.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.weazyexe.goosebank.databinding.ViewHolderAccountBinding
import dev.weazyexe.goosebank.domain.Account
import dev.weazyexe.goosebank.util.string

/**
 * Adapter for list of accounts
 */
class AccountAdapter : RecyclerView.Adapter<AccountAdapter.Holder>() {

    private val items: MutableList<Account> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ViewHolderAccountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding.root)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitList(items: List<Account>) {
        val diff = DiffUtil.calculateDiff(AccountsDiffUtil(this.items, items))

        this.items.clear()
        this.items.addAll(items)

        diff.dispatchUpdatesTo(this)
    }

    inner class Holder(parent: View) : RecyclerView.ViewHolder(parent) {

        private val binding = ViewHolderAccountBinding.bind(parent)

        fun bind(account: Account) = with(binding) {
            titleTv.text = account.title
            typeTv.text = string(account.type.title())
            amountSv.sum = account.amount
            amountSv.currency = account.currency
        }
    }
}