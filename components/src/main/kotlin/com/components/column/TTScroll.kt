package com.components.column

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun TTColumnScroll(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val focusManager = LocalFocusManager.current
    val scroll = rememberScrollState()
    if (scroll.isScrollInProgress) focusManager.clearFocus()
    Column(
        modifier = Modifier.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
            onClick = { focusManager.clearFocus() },
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scroll)
                .then(modifier)
        ) {
            content.invoke(this)
        }
    }
}

@Composable
fun TTColumnSmallScroll(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val focusManager = LocalFocusManager.current
    val scroll = rememberScrollState()
    if (scroll.isScrollInProgress) focusManager.clearFocus()
    Column(
        modifier = Modifier.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
            onClick = { focusManager.clearFocus() },
        )
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scroll)
                .then(modifier)
        ) {
            content.invoke(this)
        }
    }
}

@Composable
fun TTBoxScroll(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .then(modifier)
    ) {
        content.invoke(this)
    }
}