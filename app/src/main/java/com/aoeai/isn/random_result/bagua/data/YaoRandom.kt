package com.aoeai.isn.random_result.bagua.data

import kotlin.random.Random

internal class YaoRandom {

    companion object {
        fun next(): Int {
            return Random.nextInt(0, 2)
        }
    }
}