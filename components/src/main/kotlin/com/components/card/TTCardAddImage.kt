package com.components.card

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.R
import com.components.icon.TTIcon
import com.components.styles.*
import com.components.text.TTHeaderText14
import com.domain.model.GuideModel.ImageModel
import com.extensions.toBitmap
import com.mock.imageMock
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTCardAddImage(
    modifier: Modifier = Modifier,
    height: Dp = 180.dp,
    image: ImageModel,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(SecondaryBackground)
            .border(1.dp, InputBorder, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick,
            )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (image.imageBase64.isNotEmpty()) {
                Image(
                    bitmap = image.imageBase64.toBitmap().asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            } else if (image.imageUrl.isNotEmpty()) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = image.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            } else {
                Column(
                    modifier = modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    TTIcon(
                        iconRes = R.drawable.ic_add,
                        size = 24.dp,
                        tint = Placeholder,
                        onClick = onClick
                    )
                }
            }
            if (image.imageBase64.isNotEmpty() || image.imageUrl.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .background(EditionBackground)
                        .align(Alignment.BottomCenter)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = onClick,
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TTIcon(
                        iconRes = R.drawable.ic_edit,
                        size = 20.dp,
                        tint = White,
                        onClick = onClick
                    )
                    TTHeaderText14(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Editar ",
                        color = White,
                    )
                }
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardAddImagePreview() {
    TTCardAddImage(
        onClick = {},
        image = ImageModel(imageUrl = imageMock)
    )
}