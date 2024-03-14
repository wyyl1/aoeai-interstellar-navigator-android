package com.aoeai.isn.bagua.data

import androidx.compose.ui.graphics.Color

class YaoCreator {

    companion object {

        fun randomList(count : Int): List<YaoDto> {
            return List(count) { random() }
        }
        private fun random(): YaoDto {
            if (YaoRandom.next() == 0) {
                return yin()
            }
            return yang()
        }

        private fun yin(): YinYaoDto {
            return YinYaoDto(
                leftRightColor = Color.Black,
                middleColor = Color.Transparent
            )
        }

        private fun yang(): YangYaoDto {
            return YangYaoDto(
                leftRightColor = Color.Black,
                middleColor = Color.Black
            )
        }
    }
}