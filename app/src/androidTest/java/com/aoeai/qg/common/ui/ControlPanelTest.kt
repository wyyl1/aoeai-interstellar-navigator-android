package com.aoeai.qg.common.ui

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode


class ControlPanelTest {

    companion object {
        fun verifyNumberTextAfterClick(rule: ComposeContentTestRule, numbers: List<String>) {
            val numberButtons = rule.onNodeWithTag("numberButtons")

            numbers.forEach { number ->
                val numberButton = buttonOf(number)
                numberButtons.performScrollToNode(numberButton)
                rule.onNode(numberButton).performClick()

                rule.onNodeWithTag("numberText").assert(hasText(number))
            }
        }

        private fun buttonOf(number: String) = hasText(number) and hasClickAction()
    }
}