package com.aoeai.qg.twelve_chinese_zodiac_animals.data

class TwelveChineseZodiacAnimalsCreator  {

    companion object {

        fun randomList(count : Int): List<String> {
            return List(count) { random() }
        }

        private fun random(): String {
            val index = (0..11).random()
            return animals[index]
        }

        private val animals = listOf(
            "🐭", "🐮", "🐯", "🐰", "🐲", "🐍", "🐴", "🐑", "🐵", "🐔", "🐶", "🐷"
        )
    }
}