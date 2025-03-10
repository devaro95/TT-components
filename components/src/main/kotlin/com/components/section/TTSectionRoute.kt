package com.components.section

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.guide.guideBuilder.BuildSectionParams
import com.components.route.TTRoute
import com.components.route.TTRouteItemData
import com.domain.model.SectionModel
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTSectionRoutePreview() {
    TTSectionRoute(
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
fun TTSectionRoute(params: BuildSectionParams) {
    val sectionModel = params.sectionModel as SectionModel.RouteSection
    TTSection(
        modifier = Modifier.padding(horizontal = 16.dp),
        params = params
    ) {
        TTRoute(
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