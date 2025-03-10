package com.skeleton

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TTSkeletonGuideCard() {
    TTSkeletonBox(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
    )
}