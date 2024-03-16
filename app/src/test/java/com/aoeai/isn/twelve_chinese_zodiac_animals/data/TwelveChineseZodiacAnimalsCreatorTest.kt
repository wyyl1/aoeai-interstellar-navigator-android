package com.aoeai.isn.twelve_chinese_zodiac_animals.data

import org.junit.jupiter.api.Test

class TwelveChineseZodiacAnimalsCreatorTest{

    @Test
    fun `should always returns the correct value on each invocation`() {
        for (i in 1..100) {
            val signs = TwelveChineseZodiacAnimalsCreator.randomList(10)
            assert(signs.size == 10)
        }
    }
}