package com.aoeai.isn.random_result.bagua.data

import androidx.compose.ui.graphics.Color

data class YangYaoDto internal constructor(
    override val leftRightColor: Color,
    override val middleColor: Color
) : YaoDto {
    override val value: Byte = 1
}
