package dev.weazyexe.goosebank.domain

/**
 * Message in a chat entity
 */
data class Message(
    val text: String,
    val isMine: Boolean
)