package com.guilda.zup.tmdbguildapjazul

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.guilda.zup.tmdbguildapjazul.theme.ComposeByExampleTheme
import com.guilda.zup.tmdbguildapjazul.ui.Home

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeByExampleTheme {
                Home(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}