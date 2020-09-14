package xyz.yhsj.compose.page

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Divider
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import xyz.yhsj.compose.utils.Navigation
import xyz.yhsj.compose.utils.SharedElement
import xyz.yhsj.compose.utils.SharedElementType

@Composable
fun HomeScreen() {
    val item = arrayListOf("text", "button", "Image", "ListView", "Dialog", "Test")
    LazyColumnFor(items = item) { item ->
        Column {
            TextButton(onClick = {

                when (item) {
                    "text" -> Navigation.push { TextPage() }
                    "button" -> Navigation.push { ButtonPage() }
                    "Image" -> Navigation.push { ImagePage() }
                    "ListView" -> Navigation.push { ListViewPage() }
                    "Dialog" -> Navigation.push { DialogPage() }
                    "Test" -> Navigation.push { Text(text = "test") }
                }


            }) {
                Text(
                    fontSize = TextUnit.Sp(24),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillParentMaxWidth().padding(vertical = 16.dp),
                    text = item
                )
            }
        }
        Divider()
    }
}

