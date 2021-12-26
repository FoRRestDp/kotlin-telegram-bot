package com.github.kotlintelegrambot.updater

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SuspendLooperTest {

    private val sut = SuspendLooper(
        coroutineDispatcher = UnconfinedTestDispatcher(),
    )

    @Test
    fun `loops until quit is called`() {
        var count = 0

        sut.launchLoop {
            count++

            if (count == 13) {
                sut.cancelLoop()
            }
        }

        assertEquals(13, count)
    }

    @Test
    fun `loops until coroutine is canceled`() {
        var count = 0

        try {
            sut.launchLoop {
                count++

                if (count == 13) {
                    cancel()
                }
            }
        } catch (e: CancellationException) {
            assertEquals(13, count)
        }
    }

    @Test
    fun `loops until an exception is thrown`() {
        var count = 0

        try {
            sut.launchLoop {
                count++

                if (count == 13) {
                    throw RuntimeException("oops")
                }
            }
        } catch (_: RuntimeException) {
        } finally {
            assertEquals(13, count)
        }
    }
}
