package com.aoeai.qg.lottery.double_color_ball

class DoubleColorBall {

    /**
     * This method generates a list of 6 unique red ball numbers ranging from 1 to 33.
     * @return A List<Int> containing 6 unique numbers.
     */
    fun generateRedBalls(): List<Int> = (1..33).shuffled().take(6)

    /**
     * This method generates a blue ball number ranging from 1 to 16.
     * @return An Int representing the blue ball number.
     */
    fun generateBlueBall(): Int = (1..16).random()
}