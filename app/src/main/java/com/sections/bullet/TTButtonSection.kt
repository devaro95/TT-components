package com.sections.bullet

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ttcomponents.app.R
import com.components.button.*
import com.mock.titleMock
import com.utils.Section
import com.utils.SectionFirst

@Composable
fun TTButtonSection() {
    SectionFirst(title = "TTButton") {
        TTButton(
            text = titleMock,
            onClick = {}
        )
    }
    Section(title = "TTButtonIconSquare") {
        TTButtonIconSquare(
            iconRes = R.drawable.ic_plus,
            text = titleMock
        )
    }
    Section(title = "TTButtonSave") {
        TTButtonSave(
            onClick = {}
        )
    }
    Section(title = "TTButtonSecondary") {
        TTButtonSecondary(
            text = titleMock,
            onClick = {}
        )
    }
    Section(title = "TTButtonText") {
        TTButtonText(
            text = titleMock,
            onClick = {}
        )
    }
    Section(title = "TTFloatingButton") {
        TTFloatingButton(
            text = titleMock,
            onClick = {},
            enabled = true,
            color = Color.Black
        )
    }
}