package com.aoeai.qg.bagua.data

import kotlin.random.Random

internal class YaoRandom {

    companion object {
        fun next(): Int {
            return Random.nextInt(0, 2)
        }
    }
}