package dev.weazyexe.goosebank.ui.screen.chat.adapter

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.weazyexe.goosebank.R
import dev.weazyexe.goosebank.databinding.ViewHolderMessageBinding
import dev.weazyexe.goosebank.domain.Message
import dev.weazyexe.goosebank.util.color
import dev.weazyexe.goosebank.util.drawable

/**
 * Adapter for list of messages
 */
class MessagesAdapter : RecyclerView.Adapter<MessagesAdapter.Holder>() {

    private val items: MutableList<Message> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ViewHolderMessageBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding.root)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitList(items: List<Message>) {
        val diff = DiffUtil.calculateDiff(MessagesDiffUtil(this.items, items))

        this.items.clear()
        this.items.addAll(items)

        diff.dispatchUpdatesTo(this)
    }

    inner class Holder(parent: View) : RecyclerView.ViewHolder(parent) {

        private val binding = ViewHolderMessageBinding.bind(parent)

        fun bind(message: Message) = with(binding) {
            textTv.text = message.text
            if (message.isMine) {
                renderMineMessage()
            } else {
                renderOthersMessage()
            }
        }

        private fun renderMineMessage() = with(binding.textTv) {
            FrameLayout.LayoutParams(this.layoutParams).apply {
                gravity = Gravity.END
                layoutParams = this
            }
            background = drawable(R.drawable.img_bubble_mine)
            setTextColor(color(R.color.white))
        }

        private fun renderOthersMessage() = with(binding.textTv) {
            FrameLayout.LayoutParams(this.layoutParams).apply {
                gravity = Gravity.START
                layoutParams = this
            }
            background = drawable(R.drawable.img_bubble_other)
            setTextColor(color(R.color.dark_gray))
        }
    }
}