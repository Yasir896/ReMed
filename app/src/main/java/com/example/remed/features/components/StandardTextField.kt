package com.example.remed.features.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remed.R
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