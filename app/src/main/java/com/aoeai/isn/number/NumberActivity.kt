package com.aoeai.isn.number

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aoeai.isn.number.ui.NumberView
import com.aoeai.isn.ui.theme.InterstellarNavigatorTheme

class NumberActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterstellarNavigatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NumberView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun YaoPreview() {
    InterstellarNavigatorTheme {
        NumberView()
    }
}