package com.components.card.cardaddsectionbuilder

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.route.TTRoute
import com.components.route.TTRouteItemData
import com.components.section.TTSectionAdd
import com.mock.textMock
import com.mock.titleMock
import com.domain.model.SectionModel
import com.domain.model.SectionModel.RouteSection.Route

@Composable
fun CreateSectionRoute(onSectionAddClick: (SectionModel) -> Unit) {
    TTSectionAdd(onSave = { onSectionAddClick.invoke(Route()) }) {
        TTRoute(
            modifier = Modifier.padding(horizontal = 16.dp),
            title = titleMock,
            routeItems = listOf(
                TTRouteItemData(
                    title = titleMock,
                    text = textMock
                ),
                TTRouteItemData(
                    title = titleMock,
                    text = textMock
                )
            )
        )
    }
}