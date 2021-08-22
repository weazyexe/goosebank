package dev.weazyexe.goosebank.ui.screen.history.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.weazyexe.goosebank.databinding.ViewHolderTransactionBinding
import dev.weazyexe.goosebank.domain.Transaction
import dev.weazyexe.goosebank.util.drawable

/**
 * Adapter for list of transactions
 */
class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.Holder>() {

    private val items: MutableList<Transaction> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ViewHolderTransactionBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding.root)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitList(items: List<Transaction>) {
        val diff = DiffUtil.calculateDiff(TransactionDiffUtil(this.items, items))

        this.items.clear()
        this.items.addAll(items)

        diff.dispatchUpdatesTo(this)
    }

    inner class Holder(parent: View) : RecyclerView.ViewHolder(parent) {

        private val binding = ViewHolderTransactionBinding.bind(parent)

        fun bind(transaction: Transaction) = with(binding) {
            titleTv.text = transaction.title
            typeTv.text = transaction.type
            amountSv.sum = transaction.amount
            amountSv.currency = transaction.currency
            iconIv.setImageDrawable(drawable(transaction.icon()))
        }
    }
}