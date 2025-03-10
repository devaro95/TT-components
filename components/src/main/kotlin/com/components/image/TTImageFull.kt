package com.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.components.text.TTBodyText
import com.extensions.toBitmap
import com.mock.imageModelMock
import com.mock.textMock
import com.domain.model.GuideModel.ImageModel
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@VROLightMultiDevicePreview
@Composable
private fun TTImageFullPreview() {
    TTImageFull(
        image = imageModelMock,
        text = textMock
    )
}

@Composable
fun TTImageFull(
    image: ImageModel,
    text: String = EMPTY_STRING,
) {
    Column {
        if (image.imageUrl.isEmpty()) {
            Image(
                bitmap = image.imageBase64.toBitmap().asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                contentScale = ContentScale.Crop
            )
        } else {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                model = image.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        TTBodyText(
            text = text,
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp)
        )
    }
}