package com.github.kotlintelegrambot.errors

public class RetrieveUpdatesError(private val errorMessage: String) : TelegramError {
    override fun getType(): TelegramError.Error {
        return TelegramError.Error.RETRIEVE_UPDATES
    }

    override fun getErrorMessage(): String = errorMessage
}
