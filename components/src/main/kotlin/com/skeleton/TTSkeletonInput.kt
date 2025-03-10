package com.skeleton

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TTSkeletonInput(modifier: Modifier = Modifier) {
    TTSkeletonBox(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
    )
}