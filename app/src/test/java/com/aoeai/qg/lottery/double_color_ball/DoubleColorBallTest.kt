package com.aoeai.qg.lottery.double_color_ball

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class DoubleColorBallTest {

    private val doubleColorBall = DoubleColorBall()

    @Test
    fun `should generate red balls within range 1 to 33`() {
        val redBalls = doubleColorBall.generateRedBalls()
        assertTrue(redBalls.all { it in 1..33 })
    }

    @Test
    fun `should generate exactly 6 red balls`() {
        val redBalls = doubleColorBall.generateRedBalls()
        assertEquals(6, redBalls.size)
    }

    @Test
    fun `should generate a blue ball within range 1 to 16`() {
        val blueBall = doubleColorBall.generateBlueBall()
        assertTrue(blueBall in 1..16)
    }

    @Test
    fun `should ensure no duplicate red balls`() {
        val redBalls = doubleColorBall.generateRedBalls()
        assertEquals(redBalls.toSet().size, redBalls.size)
    }

}