package com.components.section

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.cardrestaurant.TTCardRestaurant
import com.components.cardrestaurant.TTCardRestaurantType.BOTTOM_FULL
import com.components.cardrestaurant.TTCardRestaurantType.TOP_FULL
import com.components.cardrestaurant.TTCardRestaurantType.TOP_LEFT
import com.components.guide.guideBuilder.BuildSectionParams
import com.model.SectionModel
import com.model.SectionModel.RestaurantSection.BottomImage
import com.model.SectionModel.RestaurantSection.TopImage
import com.model.SectionModel.RestaurantSection.TopLeftImage
import com.model.SectionModel.RestaurantSection.TopRightImage
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTSectionCardRestaurantPreview() {
    TTSectionCardRestaurant(
        BuildSectionParams(
            onDeleteSection = {},
            onEditSection = {},
            onCopySection = {},
            sectionModel = TopImage(),
            isEditable = true,
            showButton = true,
        )
    )
}

@Composable
fun TTSectionCardRestaurant(
    params: BuildSectionParams,
) {
    val sectionModel = params.sectionModel as SectionModel.RestaurantSection
    TTSection(
        modifier = Modifier.padding(horizontal = 16.dp),
        params = params
    ) {
        TTCardRestaurant(
            item = sectionModel.model, type = when (params.sectionModel) {
                is BottomImage -> BOTTOM_FULL
                is TopImage -> TOP_FULL
                is TopLeftImage -> TOP_LEFT
                is TopRightImage -> TOP_FULL
                else -> TOP_FULL
            }
        )
    }
}