package com.aoeai.qg.home.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.aoeai.qg.R
import com.aoeai.qg.bagua.BaguaActivity
import com.aoeai.qg.home.data.FunctionKeyDto
import com.aoeai.qg.number.NumberActivity
import com.aoeai.qg.twelve_chinese_zodiac_animals.TwelveChineseZodiacAnimalsActivity
import com.aoeai.qg.twelve_zodiac_signs.TwelveZodiacSignsActivity
import com.aoeai.qg.ui.theme.InterstellarNavigatorTheme
import kotlinx.coroutines.launch

@Composable
fun Home() {
    Drawer()

    val keys = listOf(
        FunctionKeyDto(R.drawable.bagua, BaguaActivity::class.java),
        FunctionKeyDto(R.drawable.number, NumberActivity::class.java),
        FunctionKeyDto(R.drawable.twelve_zodiac_signs, TwelveZodiacSignsActivity::class.java),
        FunctionKeyDto(
            R.drawable.twelve_chinese_zodiac_animals,
            TwelveChineseZodiacAnimalsActivity::class.java
        )
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // 在 Box 中居中对齐
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(keys) { data ->
                    FunctionKey(data)
                }
            }
        )
    }
}

@Composable
private fun FunctionKey(data: FunctionKeyDto) {
    val packageContext = LocalContext.current
    val image = painterResource(data.resId)

    Card(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = {
                val intent = Intent(packageContext, data.targetActivityCls)
                startActivity(packageContext, intent, null)
            }),
        shape = RoundedCornerShape(10.dp),
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        )
    }
}

@Composable
private fun Drawer() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Box(
                modifier = Modifier.width(200.dp) // Set the width of the drawer
            ) {
                Column {
                    Button(
                        shape = RectangleShape,
                        onClick = {
                            scope.launch {
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://github.com/aoeai/aoeai-qigua-android/issues")
                                )
                                context.startActivity(intent)
                                drawerState.close()
                            }
                        }) {
                        Text(stringResource(id = R.string.menu_communication))
                    }
                }
            }
        },
    ) {
        Box(
            contentAlignment = Alignment.TopStart
        ) {
            IconButton(
                onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
            ) {
                Icon(Icons.Filled.Menu, contentDescription = "Open Drawer")
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    InterstellarNavigatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Home()
        }
    }
}