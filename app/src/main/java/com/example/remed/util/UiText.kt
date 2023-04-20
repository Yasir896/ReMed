package com.example.remed.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiText {
    data class DynamicString(val value: String): UiText()

    data class StringResource(@StringRes val id: Int, var args: List<Any>): UiText()

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> context.getString(
                id, *args.toTypedArray()
            )
        }
    }

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> stringResource(
                id,
                *args.toTypedArray()
            )
        }
    }
}

/*
this is how this can be used

@Composable
fun ErrorMessage(error: UiText) {
    Text(
        text = error.asString(),
        color = Color.Red
        )
}
 */