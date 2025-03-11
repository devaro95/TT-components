package com.utils

import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.icon.TTIcon
import com.components.styles.Background
import com.components.styles.Primary
import com.components.text.TTHeaderText16
import com.vro.compose.states.VROTopBarBaseState.VROTopBarState
import com.vro.constants.EMPTY_STRING

fun topBarBackState(
    navigateBack: () -> Unit,
    title: @Composable String = EMPTY_STRING,
    background: Color = Background,
) = VROTopBarState(
    title = { TTHeaderText16(text = title) },
    navigationButton = {
        IconButton(onClick = navigateBack) {
            TTIcon(
                iconRes = R.drawable.ic_back,
                modifier = Modifier.size(16.dp),
                contentDescription = null,
                tint = Primary,
                onClick = navigateBack
            )
        }
    },
    background = background
)