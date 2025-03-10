package com.components.section

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.bullet.TTBullet
import com.components.bullet.TTBulletItemData
import com.components.guide.guideBuilder.BuildSectionParams
import com.domain.model.SectionModel.BulletSection
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTSectionBulletPreview() {
    TTSectionBullet(
        BuildSectionParams(
            sectionModel = BulletSection.Bullet(),
            isEditable = true,
            showButton = true,
            onDeleteSection = {},
            onEditSection = {},
            onCopySection = {},
        )
    )
}

@Composable
fun TTSectionBullet(params: BuildSectionParams) {
    val sectionModel = params.sectionModel as BulletSection
    TTSection(
        modifier = Modifier.padding(horizontal = 16.dp),
        params = params,
    ) {
        TTBullet(
            title = sectionModel.model.title,
            text = sectionModel.model.text,
            itemList = sectionModel.model.itemList.map {
                TTBulletItemData(
                    title = it.title,
                    text = it.text
                )
            }
        )
    }
}