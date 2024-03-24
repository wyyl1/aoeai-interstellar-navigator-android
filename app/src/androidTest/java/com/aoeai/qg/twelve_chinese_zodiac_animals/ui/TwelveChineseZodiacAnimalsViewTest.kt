package com.aoeai.qg.twelve_chinese_zodiac_animals.ui

import androidx.compose.ui.test.junit4.createComposeRule
import com.aoeai.qg.common.ui.ControlPanelTest
import org.junit.Rule
import org.junit.Test

class TwelveChineseZodiacAnimalsViewTest{
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun should_show_text_with_same_number_when_number_button_is_clicked() {
        rule.setContent { TwelveChineseZodiacAnimalsView() }

        ControlPanelTest.verifyNumberTextAfterClick(
            rule,
            listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
        )
    }
}