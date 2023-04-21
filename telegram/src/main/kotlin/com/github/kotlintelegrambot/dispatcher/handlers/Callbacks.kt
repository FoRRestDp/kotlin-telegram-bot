package com.github.kotlintelegrambot.dispatcher.handlers

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.dispatcher.handlers.media.MediaHandlerEnvironment
import com.github.kotlintelegrambot.entities.Game
import com.github.kotlintelegrambot.entities.Update
import com.github.kotlintelegrambot.entities.files.*
import com.github.kotlintelegrambot.entities.stickers.Sticker

public typealias HandleUpdate = suspend (Bot, Update) -> Unit

public typealias HandleError = suspend ErrorHandlerEnvironment.() -> Unit

public typealias HandleMessage = suspend MessageHandlerEnvironment.() -> Unit

public typealias HandleCommand = suspend CommandHandlerEnvironment.() -> Unit

public typealias HandleText = suspend TextHandlerEnvironment.() -> Unit

public typealias HandleCallbackQuery = suspend CallbackQueryHandlerEnvironment.() -> Unit

public typealias HandleContact = suspend ContactHandlerEnvironment.() -> Unit

public typealias HandleLocation = suspend LocationHandlerEnvironment.() -> Unit

public typealias HandleInlineQuery = suspend InlineQueryHandlerEnvironment.() -> Unit

public typealias HandleNewChatMembers = suspend NewChatMembersHandlerEnvironment.() -> Unit

public typealias HandlePollAnswer = suspend PollAnswerHandlerEnvironment.() -> Unit

public typealias HandleDice = suspend DiceHandlerEnvironment.() -> Unit

public typealias HandleChannelPost = suspend ChannelHandlerEnvironment.() -> Unit

public typealias HandlePreCheckoutQuery = suspend PreCheckoutQueryHandlerEnvironment.() -> Unit

public typealias HandleAudio = suspend MediaHandlerEnvironment<Audio>.() -> Unit

public typealias HandleDocument = suspend MediaHandlerEnvironment<Document>.() -> Unit

public typealias HandleAnimation = suspend MediaHandlerEnvironment<Animation>.() -> Unit

public typealias HandleGame = suspend MediaHandlerEnvironment<Game>.() -> Unit

public typealias HandlePhotos = suspend MediaHandlerEnvironment<List<PhotoSize>>.() -> Unit

public typealias HandleSticker = suspend MediaHandlerEnvironment<Sticker>.() -> Unit

public typealias HandleVideo = suspend MediaHandlerEnvironment<Video>.() -> Unit

public typealias HandleVoice = suspend MediaHandlerEnvironment<Voice>.() -> Unit

public typealias HandleVideoNote = suspend MediaHandlerEnvironment<VideoNote>.() -> Unit
