package team.study.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import team.study.presentation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NaverBookSearchBar(
    modifier: Modifier,
    value: String,
    onClear: () -> Unit = {},
    onDone: () -> Unit = {},
    onFocusChanged: (FocusState) -> Unit = {},
    onValueChanged: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(.9f)
            .onFocusChanged { onFocusChanged(it) },
        value = value,
        onValueChange = { query ->
            onValueChanged(query)
        },
        label = { Text(text = stringResource(id = R.string.search_hint)) },
        singleLine = true,
        trailingIcon = {
            IconButton(onClick = { onClear() }) {
                Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
            }
        },
        keyboardActions = KeyboardActions(onDone = { onDone() }),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text,
        ),
    )
}
