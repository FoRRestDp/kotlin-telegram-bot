package com.github.kotlintelegrambot.dispatcher.handlers.media

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.dispatcher.handlers.Handler
import com.github.kotlintelegrambot.dispatcher.handlers.UpdateHandlerEnvironment
import com.github.kotlintelegrambot.entities.Message
import com.github.kotlintelegrambot.entities.Update

public data class MediaHandlerEnvironment<Media>(
    override val bot: Bot,
    override val update: Update,
    val message: Message,
    val media: Media
) : UpdateHandlerEnvironment

internal abstract class MediaHandler<Media>(
    private val handleMediaUpdate: suspend MediaHandlerEnvironment<Media>.() -> Unit,
    private val toMedia: Message.() -> Media,
    private val isUpdateMedia: (Update) -> Boolean
) : Handler {

    override fun checkUpdate(update: Update): Boolean = isUpdateMedia(update)

    override suspend fun handleUpdate(bot: Bot, update: Update) {
        checkNotNull(update.message)
        val media = update.message.toMedia()
        val mediaHandlerEnvironment = MediaHandlerEnvironment(bot, update, update.message, media)
        handleMediaUpdate.invoke(mediaHandlerEnvironment)
    }
}
