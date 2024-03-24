package com.aoeai.qg.common.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ControlPanel(
    modifier: Modifier,
    initialNumber: Int,
    numbers: List<Int>,
    onNumberSelected: (Int) -> Unit,
    onClick: () -> Unit
) {
    var number by remember { mutableIntStateOf(initialNumber) }

    Column(
        modifier = modifier
    ) {
        val columnModifier = Modifier.align(Alignment.CenterHorizontally)
        NumberText(number = number, modifier = columnModifier)
        ChooseNumberButtons(numbers = numbers, modifier = columnModifier) {
            number = it
            onNumberSelected(it)
        }
        RandomButton(
            modifier = columnModifier,
            onClick = onClick
        )
    }
}

@Composable
private fun NumberText(number: Int, modifier: Modifier) {
    Text(
        modifier = modifier.testTag("numberText"),
        text = "$number",
        fontSize = 30.sp,
        color = Color.Black
    )
}

@Composable
private fun ChooseNumberButtons(numbers: List<Int>, modifier: Modifier, onNumberSelected: (Int) -> Unit) {
    LazyRow(modifier = modifier.testTag("numberButtons")) {
        itemsIndexed(numbers) { index, number ->
            ChooseNumberButton(text = "$number", onClick = { onNumberSelected(number) })
            if (index < numbers.size - 1) {
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }
}

@Composable
private fun RandomButton(modifier: Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .clip(CircleShape)
            .size(100.dp)
            .padding(10.dp),
        onClick = onClick
    ) {
    }
}

@Composable
fun ChooseNumberButton(text: String, onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Text(text)
    }
}