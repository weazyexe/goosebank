package dev.weazyexe.goosebank.ui.screen.chat.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.weazyexe.goosebank.domain.Message

/**
 * Diff utils for [MessagesAdapter]
 */
class MessagesDiffUtil(
    private val oldMessages: List<Message>,
    private val newMessages: List<Message>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldMessages.size

    override fun getNewListSize(): Int = newMessages.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldMessages[oldItemPosition].hashCode() == newMessages[newItemPosition].hashCode()

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldMessages[oldItemPosition] == newMessages[newItemPosition]
}