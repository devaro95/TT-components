package com.components.menu

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.app.R
import com.components.icon.TTIcon
import com.components.menu.TTMenuItemData.TTMenuItemClickableArrowData
import com.components.menu.TTMenuItemData.TTMenuItemClickableData
import com.components.menu.TTMenuItemData.TTMenuItemSwitchData
import com.components.styles.Primary
import com.components.styles.Secondary
import com.components.styles.White
import com.components.text.TTBodyText18
import com.components.text.TTHeaderText14
import com.components.text.TTHeaderText16
import com.vro.compose.preview.VROLightMultiDevicePreview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TTMenuItem(
    modifier: Modifier = Modifier,
    data: TTMenuItemData
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    when (data) {
                        is TTMenuItemClickableArrowData -> data.onClick()
                        is TTMenuItemClickableData -> data.onClick()
                        else -> Unit
                    }
                },
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .padding(10.dp)
            ) {
                TTIcon(
                    iconRes = data.icon,
                    size = data.iconSize
                )
            }

            when (data.textType) {
                TTMenuItemData.TextType.NORMAL -> TTHeaderText14(
                    modifier = Modifier.weight(1f),
                    text = data.text,
                    color = data.textColor
                )

                TTMenuItemData.TextType.BIG -> TTHeaderText16(
                    modifier = Modifier.weight(1f),
                    text = data.text,
                    color = data.textColor,
                )
            }
            when (data) {
                is TTMenuItemSwitchData ->
                    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                        Switch(
                            modifier = Modifier
                                .padding(0.dp),
                            checked = data.isChecked,
                            onCheckedChange = data.onChange,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Secondary,
                                checkedTrackColor = Secondary,
                                uncheckedThumbColor = White,
                                uncheckedTrackColor = Secondary
                            )
                        )
                    }

                is TTMenuItemClickableArrowData -> TTIcon(
                    modifier = Modifier.rotate(180f),
                    iconRes = R.drawable.ic_back,
                )

                is TTMenuItemClickableData -> Unit
            }
        }
    }
}

sealed class TTMenuItemData(
    @DrawableRes open val icon: Int,
    open val iconSize: Dp,
    open val text: String,
    open val textColor: Color,
    open val textType: TextType
) {
    data class TTMenuItemSwitchData(
        @DrawableRes override val icon: Int,
        override val iconSize: Dp = 16.dp,
        override val text: String,
        override val textColor: Color = Primary,
        override val textType: TextType = TextType.BIG,
        val isChecked: Boolean,
        val onChange: ((Boolean) -> Unit),
    ) : TTMenuItemData(icon, iconSize, text, textColor, textType)

    data class TTMenuItemClickableArrowData(
        @DrawableRes override val icon: Int,
        override val iconSize: Dp = 16.dp,
        override val text: String,
        override val textColor: Color = Primary,
        override val textType: TextType = TextType.BIG,
        val onClick: () -> Unit,
    ) : TTMenuItemData(icon, iconSize, text, textColor, textType)

    data class TTMenuItemClickableData(
        @DrawableRes override val icon: Int,
        override val iconSize: Dp = 16.dp,
        override val text: String,
        override val textColor: Color = Primary,
        override val textType: TextType = TextType.BIG,
        val onClick: () -> Unit,
    ) : TTMenuItemData(icon, iconSize, text, textColor, textType)

    enum class TextType {
        NORMAL, BIG
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTMenuItemPreview() {
    Column {
        TTMenuItem(
            data = TTMenuItemClickableArrowData(
                icon = R.drawable.ic_delete_2,
                text = "Example",
                onClick = {}
            )
        )
        TTMenuItem(
            modifier = Modifier.padding(top = 60.dp),
            data = TTMenuItemClickableArrowData(
                icon = R.drawable.ic_edit,
                text = "Editar guía",
                onClick = {},
                iconSize = 20.dp,
                textType = TTMenuItemData.TextType.NORMAL
            ),
        )
    }
}