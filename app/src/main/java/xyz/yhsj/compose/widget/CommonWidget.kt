package xyz.yhsj.compose.widget

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun topBar(title: String) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        elevation = 8.dp,
        actions = {
            IconButton(
                onClick = {},
                icon = { Icon(asset = Icons.Default.Search) }
            )

        }

    )
}