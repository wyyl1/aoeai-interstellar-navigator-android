package com.aoeai.isn.random_result.bagua.data

import androidx.compose.ui.graphics.Color

class YaoCreator {

    companion object {
        fun yin(): YinYaoDto {
            return YinYaoDto(
                leftRightColor = Color.Black,
                middleColor = Color.Transparent
            )
        }

        fun yang(): YangYaoDto {
            return YangYaoDto(
                leftRightColor = Color.Black,
                middleColor = Color.Black
            )
        }
    }
}