package com.aoeai.isn.random_result.bagua.data

import com.aoeai.isn.bagua.data.YaoRandom
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class YaoRandomTest{
    @Test
    fun `should return 0 or 1`() {
        val resultSet = mutableSetOf<Int>()

        for (i in 1..100) {
            resultSet.add(YaoRandom.next())
        }

        assertThat(resultSet).contains(0)
        assertThat(resultSet).contains(1)
    }
}