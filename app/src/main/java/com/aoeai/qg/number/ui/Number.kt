package com.aoeai.qg.number.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.aoeai.qg.common.ui.ControlPanel
import com.aoeai.qg.number.data.NumberCreator

@Composable
fun NumberView() {
    var count by remember { mutableIntStateOf(6) }
    var numbers by remember { mutableStateOf(NumberCreator.randomList(count)) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = numbers.joinToString(" "),
            fontSize = 60.sp,
            color = Color.Black,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 60.sp
        )

        ControlPanel(
            modifier = Modifier.align(Alignment.BottomCenter),
            onNumberSelected = { count = it },
            initialNumber = count,
            numbers = (1..9).toList()
        ) { numbers = NumberCreator.randomList(count) }
    }
}

@Preview(showBackground = true)
@Composable
fun NumberPreview() {
    com.aoeai.qg.ui.theme.InterstellarNavigatorTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NumberView()
        }
    }
}