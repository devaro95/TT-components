package com.components.progress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.components.styles.Background
import com.components.styles.Secondary
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING
import com.vro.constants.FLOAT_ZERO

@Composable
fun TTProgressLevel(
    modifier: Modifier = Modifier,
    duration: Int,
    finalProgress: Float,
    onFinish: () -> Unit = {}
) {
    var progress by remember { mutableFloatStateOf(FLOAT_ZERO) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = duration),
        label = EMPTY_STRING
    )
    LaunchedEffect(animatedProgress) {
        if (animatedProgress >= finalProgress) {
            onFinish()
        }
    }
    LinearProgressIndicator(
        progress = { animatedProgress },
        modifier = modifier
            .height(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(2.dp, Secondary, RoundedCornerShape(10.dp)),
        color = Secondary,
        trackColor = Background,
    )
    LaunchedEffect(LocalLifecycleOwner.current) {
        progress = finalProgress
    }
}

@VROLightMultiDevicePreview
@Composable
private fun ZQProgressLevelPreview() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TTProgressLevel(
            duration = 4000,
            finalProgress = 1f,
            onFinish = {}
        )
    }
}