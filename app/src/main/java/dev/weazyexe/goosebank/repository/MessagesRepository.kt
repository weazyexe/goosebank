package dev.weazyexe.goosebank.repository

import dev.weazyexe.goosebank.domain.Message

/**
 * Messages data source
 */
class MessagesRepository {

    fun getMessages(): List<Message> = listOf(
        Message("Hello there", isMine = true),
        Message("Hey!", isMine = false),
        Message("How's going?", isMine = true),
        Message("Lorem ipsum dolor sit amet", isMine = false),
        Message("Consectetur adipiscing elit", isMine = false),
        Message("Etiam ornare neque nec mi aliquet facilisis!", isMine = true),
        Message("Aenean tristique pretium dui maximus iaculis. In a aliquet lacus", isMine = true),
        Message("Mauris sem lectus, facilisis ut ante in, consectetur tristique quam.", isMine = false),
        Message("Aliquam malesuada et lectus at malesuada", isMine = true),
        Message("Sed fermentum diam lacinia odio accumsan, nec tristique enim lobortis", isMine = false),
        Message("Praesent sit amet nulla eros. Morbi imperdiet aliquet ligula, in pellentesque tellus lacinia ut.", isMine = false),
        Message("Morbi diam mi", isMine = true),
        Message("Vehicula sed ultrices eget", isMine = true),
        Message("Fermentum tempus nisi", isMine = true),
        Message("Cras in interdum erat, at iaculis nisl", isMine = false),
        Message("Aenean placerat justo lacus, nec venenatis arcu ullamcorper quis. Nulla ac rhoncus mauris", isMine = true),
        Message("Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas", isMine = false),
        Message("I got it, thanks :)", isMine = true),
        Message("Anytime!", isMine = false)
    )
}