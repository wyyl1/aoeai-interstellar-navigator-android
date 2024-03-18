package com.aoeai.qg.twelve_zodiac_signs.data

import org.junit.jupiter.api.Test

class TwelveZodiacSignsCreatorTest {

    @Test
    fun `should always returns the correct value on each invocation`() {
        for (i in 1..100) {
            val signs = TwelveZodiacSignsCreator.randomList(10)
            assert(signs.size == 10)
        }
    }
}