package com.example.remed.features.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.remed.ui.theme.ReMedTheme

@Composable
fun StandardTextField(


    modifier: Modifier,
    text: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    TextField(
        value = text,
        textStyle = MaterialTheme.typography.body2,
        onValueChange = { onValueChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        trailingIcon = trailingIcon,
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            textColor = ReMedTheme.colors.textPrimary,
            backgroundColor = ReMedTheme.colors.uiBackground,
            placeholderColor = ReMedTheme.colors.light,
            unfocusedIndicatorColor = ReMedTheme.colors.brand,
        )
    )
}

@Composable
@Preview
fun PreviewTextField() {
    ReMedTheme {
        StandardTextField(onValueChange = { }, modifier = Modifier)
    }
}