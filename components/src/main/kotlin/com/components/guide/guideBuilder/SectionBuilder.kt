package com.components.guide.guideBuilder

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.section.TTSectionBullet
import com.components.section.TTSectionCardRestaurant
import com.components.section.TTSectionParagraph
import com.model.SectionModel
import com.model.SectionModel.BulletSection
import com.model.SectionModel.ImageSection
import com.model.SectionModel.InfoSection
import com.model.SectionModel.ParagraphSection
import com.model.SectionModel.RestaurantSection
import com.model.SectionModel.RouteSection

data class BuildSectionParams(
    val sectionModel: SectionModel,
    val isEditable: Boolean,
    val showButton: Boolean,
    val buttonText: String? = null,
    val onDeleteSection: (SectionModel) -> Unit = {},
    val onEditSection: (SectionModel) -> Unit = {},
    val onCopySection: (SectionModel) -> Unit = {},
)

@Composable
fun BuildSection(params: BuildSectionParams) {
    Column {
        when (params.sectionModel) {
            is BulletSection -> TTSectionBullet(params)
            is ImageSection -> BuildImageSection(params)
            is ParagraphSection -> TTSectionParagraph(params)
            is RestaurantSection -> TTSectionCardRestaurant(params = params)
            is InfoSection -> BuildInfoSection(params)
            is RouteSection -> BuildRouteSection(params)
        }
    }
}
