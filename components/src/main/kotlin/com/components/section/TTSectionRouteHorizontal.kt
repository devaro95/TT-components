package com.components.section

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.guide.guideBuilder.BuildSectionParams
import com.components.route.TTRouteHorizontal
import com.components.route.TTRouteItemData
import com.model.SectionModel
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTSectionRouteHorizontalPreview() {
    TTSectionRouteHorizontal(
        BuildSectionParams(
            sectionModel = SectionModel.RouteSection.Route(),
            isEditable = true,
            showButton = true,
            onDeleteSection = {},
            onEditSection = {},
            onCopySection = {},
        )
    )
}

@Composable
fun TTSectionRouteHorizontal(params: BuildSectionParams) {
    val sectionModel = params.sectionModel as SectionModel.RouteSection
    TTSection(
        params = params,
        footerModifier = Modifier.padding(horizontal = 16.dp)
    ) {
        TTRouteHorizontal(
            title = sectionModel.model.title,
            routeItems = sectionModel.model.itemList.map {
                TTRouteItemData(
                    title = it.title,
                    text = it.text
                )
            },
        )
    }
}