package com.components.guide.guideBuilder

import androidx.compose.runtime.Composable
import com.components.section.TTSectionRoute
import com.components.section.TTSectionRouteHorizontal
import com.model.SectionModel

@Composable
fun BuildRouteSection(params: BuildSectionParams) {
    val sectionModel = params.sectionModel as SectionModel.RouteSection
    when (sectionModel) {
        is SectionModel.RouteSection.Route -> TTSectionRoute(params = params)
        is SectionModel.RouteSection.RouteHorizontal -> TTSectionRouteHorizontal(params)
    }
}