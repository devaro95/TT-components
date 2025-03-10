package com.components.card.cardaddsectionbuilder

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.bullet.TTBullet
import com.components.bullet.TTBulletItemData
import com.components.section.TTSectionAdd
import com.domain.model.SectionModel
import com.domain.model.SectionModel.BulletSection.Bullet
import com.domain.model.SectionModel.BulletSection.BulletTitle
import com.mock.textMock
import com.mock.titleMock

@Composable
fun CreateSectionBullet(onSectionAddClick: (SectionModel) -> Unit) {
    TTSectionAdd(onSave = { onSectionAddClick.invoke(BulletTitle()) }) {
        TTBullet(
            modifier = Modifier.padding(horizontal = 16.dp),
            title = titleMock,
            text = textMock,
            itemList = listOf(
                TTBulletItemData(
                    title = titleMock,
                    text = textMock
                ),
                TTBulletItemData(
                    title = titleMock,
                    text = textMock
                ),
                TTBulletItemData(
                    title = titleMock,
                    text = textMock
                )
            )
        )
    }
    TTSectionAdd(onSave = { onSectionAddClick.invoke(Bullet()) }) {
        TTBullet(
            modifier = Modifier.padding(horizontal = 16.dp),
            title = titleMock,
            text = textMock,
            itemList = listOf(
                TTBulletItemData(
                    text = textMock
                ),
                TTBulletItemData(
                    text = textMock
                ),
                TTBulletItemData(
                    text = textMock
                )
            )
        )
    }
}