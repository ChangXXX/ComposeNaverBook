package team.study.presentation.ui.empty

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import team.study.presentation.theme.MagentaTheme

@AndroidEntryPoint
class EmptyActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContent {
            MagentaTheme {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Hello(modifier = Modifier)
                }
            }
        }
    }
}

@Preview
@Composable
fun Hello(
    modifier: Modifier = Modifier
) {
    Text(text = "Hello World!")
}
