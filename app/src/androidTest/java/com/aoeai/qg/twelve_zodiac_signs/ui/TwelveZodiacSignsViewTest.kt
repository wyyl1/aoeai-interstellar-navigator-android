package com.aoeai.qg.twelve_zodiac_signs.ui

import androidx.compose.ui.test.junit4.createComposeRule
import com.aoeai.qg.common.ui.ControlPanelTest
import org.junit.Rule
import org.junit.Test

class TwelveZodiacSignsViewTest{
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun should_show_text_with_same_number_when_number_button_is_clicked() {
        rule.setContent { TwelveZodiacSignsView() }

        ControlPanelTest.verifyNumberTextAfterClick(
            rule,
            listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
        )
    }
}