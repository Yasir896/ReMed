package com.example.remed.features.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.remed.R
import com.example.remed.features.ReMedSurface
import com.example.remed.ui.theme.ReMedTheme

@Composable
fun DropDown(
    onSelect: (Int) -> Unit,
    size: Int,
    getItemText: (Int) -> String,
    selectedItem: MutableState<Int> = mutableStateOf(-1),
    modifier: Modifier = Modifier
) {
    val showCategories = remember { mutableStateOf(false) }
    //var selectedCategory = remember { mutableStateOf(items[0]) }
    val dropDownWidth = remember { mutableStateOf(0) }

    ReMedSurface(
        shape = RoundedCornerShape(12.dp),
        color = ReMedTheme.colors.textSecondary.copy(0.05f),
    ) {
        // Anchor view
        Row(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
                .wrapContentWidth()
                .clickable {
                    //dropdown will not expand
                    // in case of zero value
                    if (size > 0) {
                        showCategories.value = true
                    }
                }
                .fillMaxWidth()
                .onSizeChanged {
                    dropDownWidth.value = it.width
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .wrapContentWidth(),
                text = if (selectedItem.value != -1) getItemText(selectedItem.value) else "Select Category"
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_expand),
                contentDescription = "expand more",
                modifier = Modifier
                    .size(35.dp)
                    .aspectRatio(1f)
            )

        }

        DropdownMenu(
            modifier = Modifier.width(with(LocalDensity.current) { dropDownWidth.value.dp }),
            expanded = showCategories.value,
            onDismissRequest = {
                showCategories.value = false
            }
        ) {
            repeat(size) {
                DropdownMenuItem(
                    onClick = {
                        onSelect(it)
                        showCategories.value = false
                    }
                ) {
                    Text(getItemText(it), color = ReMedTheme.colors.textPrimary)
                }
            }
        }
    }
}