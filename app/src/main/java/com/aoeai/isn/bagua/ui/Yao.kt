package com.aoeai.isn.bagua.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aoeai.isn.bagua.data.YaoCreator
import com.aoeai.isn.bagua.data.YaoDto

@Composable
fun DrawLine(color: Color, modifier: Modifier) {
    Canvas(modifier = modifier.fillMaxHeight()) {
        val startY = size.height / 2
        val endY = size.height / 2
        drawLine(
            color = color,
            start = Offset(0f, startY),
            end = Offset(size.width, endY),
            strokeWidth = 30f, // Increase the strokeWidth to make the line thicker
            alpha = 1f
        )
    }
}

@Composable
fun Yao(yaoData: YaoDto) {
    Row(modifier = Modifier.padding(all = 20.dp)) {
        // 3/7
        DrawLine(yaoData.leftRightColor, modifier = Modifier.weight(3f))
        // 1/7
        DrawLine(yaoData.middleColor, modifier = Modifier.weight(1f))
        // 3/7
        DrawLine(yaoData.leftRightColor, modifier = Modifier.weight(3f))
    }
}

@Composable
fun YaoShowcase() {
    var count by remember { mutableStateOf(6) }
    var yaoDataList by remember { mutableStateOf(YaoCreator.randomList(count)) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .size(300.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            items(yaoDataList) { yaoData ->
                Yao(yaoData = yaoData)
            }
        }

        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "$count",
                fontSize = 30.sp,
                color = Color.Black
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                ChooseCountButton(text = "1", onClick = { count = 1 })
                Spacer(modifier = Modifier.size(10.dp))
                ChooseCountButton(text = "2", onClick = { count = 2 })
                Spacer(modifier = Modifier.size(10.dp))
                ChooseCountButton(text = "3", onClick = { count = 3 })
                Spacer(modifier = Modifier.size(10.dp))
                ChooseCountButton(text = "6", onClick = { count = 6 })
            }

            Button(modifier = Modifier
                .clip(CircleShape)
                .size(100.dp)
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
                onClick = { yaoDataList = YaoCreator.randomList(count) }) {
            }
        }
    }
}

@Composable
fun ChooseCountButton(text: String, onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun YaoPreview() {
    com.aoeai.isn.ui.theme.InterstellarNavigatorTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            YaoShowcase()
        }
    }
}