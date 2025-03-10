package com.components.pager.register

import androidx.compose.foundation.pager.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TTPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    userScrollEnabled: Boolean = false,
    content: @Composable (RegisterStep) -> Unit,
) {
    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        flingBehavior = PagerDefaults.flingBehavior(
            state = pagerState,
            pagerSnapDistance = PagerSnapDistance.atMost(0)
        ),
        userScrollEnabled = userScrollEnabled,
        beyondViewportPageCount = 0
    ) { page ->
        content(RegisterStep.Companion.getRegisterStep(page))
    }
}

enum class RegisterStep(open val page: Int) {
    ACCOUNT(0), PROFILE(1), AVATAR(2);

    companion object {
        fun getRegisterStep(page: Int) = entries.firstOrNull { it.page == page } ?: ACCOUNT
    }
}
