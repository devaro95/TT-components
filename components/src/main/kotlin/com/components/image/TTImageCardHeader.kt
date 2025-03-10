package com.components.image

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.components.styles.White
import com.components.text.TTHeaderText16
import com.components.text.TTHeaderText18
import com.extensions.toBitmap
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.mock.imageMock
import com.mock.titleMock
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@VROLightMultiDevicePreview
@Composable
private fun TTImageCardHeaderPreview() {
    Column(Modifier.fillMaxSize()) {
        TTImageCardHeader(
            image = imageMock,
            title = titleMock
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTImageCardHeader(
    image: String,
    title: String = EMPTY_STRING,
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
    ) {
        TTHeaderText16(
            text = title,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )
        val pagerState = rememberPagerState(pageCount = { 3 })
        HorizontalPager(pagerState) {
            Column {

                Image(
                    bitmap = image.toBitmap().asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(top = 8.dp)
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                    contentScale = ContentScale.Crop
                )
                //TODO Unnused
                TTHeaderText18(
                    text = "Viaje a centroamérica",
                    modifier = Modifier.padding(top = 10.dp, start = 16.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            HorizontalPagerIndicator(
                pageCount = 3,
                pagerState = pagerState
            )
        }

    }
}
