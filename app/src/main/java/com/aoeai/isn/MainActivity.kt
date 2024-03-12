package com.aoeai.isn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aoeai.isn.random_result.bagua.Yao
import com.aoeai.isn.random_result.bagua.YaoShowcase
import com.aoeai.isn.random_result.bagua.data.YaoCreator
import com.aoeai.isn.ui.theme.InterstellarNavigatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterstellarNavigatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val yaoDataList = listOf(
                        YaoCreator.yin(),
                        YaoCreator.yang(),
                        YaoCreator.yin(),
                        YaoCreator.yang(),
                        YaoCreator.yin(),
                        YaoCreator.yang()
                    )
                    YaoShowcase(yaoDataList = yaoDataList)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InterstellarNavigatorTheme {
        Yao(YaoCreator.yin())
    }
}