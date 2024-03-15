package com.aoeai.isn.bagua

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aoeai.isn.bagua.ui.YaoView
import com.aoeai.isn.ui.theme.InterstellarNavigatorTheme

class BaguaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterstellarNavigatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorScheme.background
                ) {
                    YaoView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun YaoPreview() {
    InterstellarNavigatorTheme {
        YaoView()
    }
}