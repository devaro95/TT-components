package com.builder

import androidx.compose.runtime.Composable
import com.ComponentType
import com.ComponentType.BULLET
import com.ComponentType.BUTTON
import com.sections.bullet.TTBulletSection
import com.sections.bullet.TTButtonSection

@Composable
fun GetSections(type: ComponentType) {
    when (type) {
        BULLET -> TTBulletSection()
        BUTTON -> TTButtonSection()
    }
}