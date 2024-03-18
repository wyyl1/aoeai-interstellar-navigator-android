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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ControlPanel(
    modifier: Modifier,
    initialCount: Int,
    counts: List<Int>,
    onCountSelected: (Int) -> Unit,
    onClick: () -> Unit
) {
    var count by remember { mutableIntStateOf(initialCount) }

    Column(
        modifier = modifier
    ) {
        val columnModifier = Modifier.align(Alignment.CenterHorizontally)
        CountText(count = count, modifier = columnModifier)
        ChooseCountButtons(counts = counts, modifier = columnModifier) {
            count = it
            onCountSelected(it)
        }
        RandomButton(
            modifier = columnModifier,
            onClick = onClick
        )
    }
}

@Composable
private fun CountText(count: Int, modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "$count",
        fontSize = 30.sp,
        color = Color.Black
    )
}

@Composable
private fun ChooseCountButtons(counts: List<Int>, modifier: Modifier, onCountSelected: (Int) -> Unit) {
    LazyRow(modifier = modifier) {
        itemsIndexed(counts) { index, count ->
            ChooseCountButton(text = "$count", onClick = { onCountSelected(count) })
            if (index < counts.size - 1) {
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
fun ChooseCountButton(text: String, onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Text(text)
    }
}