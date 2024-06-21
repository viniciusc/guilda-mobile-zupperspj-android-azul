package com.guilda.zup.tmdbguildapjazul.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guilda.zup.tmdbguildapjazul.model.Destination

@Composable
fun ColumnScope.DrawerContent(
    onNavigationSelected: (destination: Destination) -> Unit
) {
    Text(
        modifier = Modifier.padding(16.dp),
        text = "Guilda mobile Android",
        fontSize = 20.sp
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        modifier = Modifier.padding(16.dp),
        text = "Time X",
        fontSize = 16.sp
    )

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )

    Spacer(modifier = Modifier.height(8.dp))

    DrawerItem(
        label = Destination.Settings.path,
        modifier = Modifier.fillMaxWidth()
    ) {
        onNavigationSelected(Destination.Settings)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DrawerContent() {
    MaterialTheme {
        Column {
            DrawerContent(
                onNavigationSelected = { },
            )
        }
    }
}