package com.components.indicator

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.R
import com.components.button.TTButtonIconSquare
import com.components.styles.Background
import com.components.styles.Primary
import com.components.styles.Secondary
import com.components.styles.White
import com.components.text.TTHeaderTextCustom
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTPagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    itemList: List<String>,
    onAddClick: (() -> Unit)? = null
) {

    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        LazyRow(
            modifier = modifier.wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            state = listState
        ) {
            itemList.forEachIndexed { position, item ->
                val color = if (pagerState.currentPage == position) Secondary else Background
                val textColor = if (pagerState.currentPage == position) White else Primary
                item {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .border(2.dp, Secondary, RoundedCornerShape(16.dp))
                            .background(color)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() },
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(position)

                                        val viewportStart =
                                            listState.layoutInfo.viewportStartOffset
                                        val viewportEnd = listState.layoutInfo.viewportEndOffset
                                        val viewportWidth = viewportEnd - viewportStart

                                        val itemInfo =
                                            listState.layoutInfo.visibleItemsInfo.find { it.index == position }
                                        itemInfo?.let { info ->
                                            val itemCenter = info.offset + info.size / 2
                                            val targetScrollOffset =
                                                itemCenter - viewportStart - viewportWidth / 2
                                            listState.animateScrollToItem(
                                                index = position,
                                                scrollOffset = targetScrollOffset
                                            )
                                        }
                                    }
                                },
                            )
                    ) {
                        TTHeaderTextCustom(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                            text = itemList[position],
                            color = textColor,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            onAddClick?.let {
                item {
                    TTButtonIconSquare(
                        iconRes = R.drawable.ic_save_section,
                        text = stringResource(R.string.tab_manage),
                        onClick = it
                    )
                }
            }
        }
    }
}