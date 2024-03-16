package com.aoeai.isn.twelve_zodiac_signs.data

class TwelveZodiacSignsCreator {

        companion object {

            fun randomList(count : Int): List<String> {
                return List(count) { random() }
            }
            private fun random(): String {
                val index = (0..11).random()
                return signs[index]
            }

            val signs = listOf(
                "♈", "♉", "♊", "♋", "♌", "♍", "♎", "♏", "♐", "♑", "♒", "♓"
            )
        }
}